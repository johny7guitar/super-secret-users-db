package org.johny7guitar.supersecretusersdb.web;

import org.johny7guitar.supersecretusersdb.entities.User;
import org.johny7guitar.supersecretusersdb.entities.UserStatus;
import org.johny7guitar.supersecretusersdb.exception.EntityNotFoundException;
import org.johny7guitar.supersecretusersdb.repository.UserRepository;
import org.johny7guitar.supersecretusersdb.services.UserService;
import org.johny7guitar.supersecretusersdb.util.UserMapper;
import org.johny7guitar.supersecretusersdb.web.hal.UserIdOnlyModel;
import org.johny7guitar.supersecretusersdb.web.hal.UserModel;
import org.johny7guitar.supersecretusersdb.web.hal.UserStatusChangeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController{

    @Autowired
    private final UserService userService;

    @Autowired
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping
    public HttpEntity<UserIdOnlyModel> addUser(@Valid @RequestBody UserDto user){
        return new ResponseEntity<>(
                new UserIdOnlyModel(userService.addUser(UserMapper.INSTANCE.userDtoToUser(user)).getId()),
                HttpStatus.OK
        );
    }

    @GetMapping(path="/{id}")
    public HttpEntity<UserModel> getUser(@PathVariable("id") Long id){
        return new ResponseEntity<>(
                new UserModel(
                        UserMapper.INSTANCE.userToUserDto(
                                userRepository.findById(id)
                                        .orElseThrow(() -> new EntityNotFoundException(User.class, id))
                        ),
                id),
                HttpStatus.OK);
    }

    @PatchMapping(path="/{id}/update_status/{new_status}")
    public HttpEntity<UserStatusChangeModel> updateUserStatus(
            @PathVariable("id") long id,
            @PathVariable("new_status") UserStatus newStatus
    ){
        UserStatusChangeDto statusChange = userService.updateUserStatus(id, newStatus);

        return new ResponseEntity<>(
                new UserStatusChangeModel(
                        statusChange.getUserId(),
                        statusChange.getOldUserStatus(),
                        statusChange.getNewUserStatus()
                ),
                HttpStatus.OK
        );

    }

}

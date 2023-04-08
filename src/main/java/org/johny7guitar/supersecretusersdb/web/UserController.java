package org.johny7guitar.supersecretusersdb.web;

import org.johny7guitar.supersecretusersdb.repository.UserRepository;
import org.johny7guitar.supersecretusersdb.services.UserService;
import org.johny7guitar.supersecretusersdb.util.UserMapper;
import org.johny7guitar.supersecretusersdb.web.hal.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public Long addUser(@RequestBody UserDto user){
        return userService.addUser(user.getId(), user.getUsername(), user.getEmail())
                .getId();
    }

    @GetMapping(path="/{id}")
    public HttpEntity<UserModel> getUser(@PathVariable("id") Long id){
        return new ResponseEntity<>(
                new UserModel(
                        UserMapper.INSTANCE.userToUserDto(
                                userRepository.findById(id)
                                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                        ),
                id),
                HttpStatus.OK);
    }

}

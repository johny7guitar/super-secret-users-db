package org.johny7guitar.supersecretusersdb.services;

import org.johny7guitar.supersecretusersdb.entities.User;
import org.johny7guitar.supersecretusersdb.entities.UserStatus;
import org.johny7guitar.supersecretusersdb.exception.EntityNotFoundException;
import org.johny7guitar.supersecretusersdb.repository.FakeExternalApi;
import org.johny7guitar.supersecretusersdb.repository.UserRepository;
import org.johny7guitar.supersecretusersdb.util.UserMapper;
import org.johny7guitar.supersecretusersdb.web.UserDto;
import org.johny7guitar.supersecretusersdb.web.UserStatusChangeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService{

    private final FakeExternalApi<User, Long> fakeExternalApi;

    @Autowired
    public UserService(UserRepository userRepository){
        this.fakeExternalApi = new FakeExternalApi<>(userRepository);
    }

    public User addUser(User user){
        return fakeExternalApi.simulateApiCall(
                userRepository -> userRepository.findById(user.getId())
                        .orElseGet(() -> userRepository.save(user)));
    }

    public UserStatusChangeDto updateUserStatus(long userId, UserStatus newUserStatus){

        User targetUser = fakeExternalApi.simulateApiCall(userRepository -> userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(User.class, userId)));

        UserStatus oldUserStatus = targetUser.getUserStatus();
        targetUser.setUserStatus(newUserStatus);

        User saved = fakeExternalApi.simulateApiCall(userRepository -> userRepository.save(targetUser));

        return new UserStatusChangeDto(saved.getId(), oldUserStatus, saved.getUserStatus());

    }

    public UserDto getUser(long id){
        return fakeExternalApi.simulateApiCall(userRepository -> userRepository.findById(id)
                .map(UserMapper.INSTANCE::userToUserDto)
                .orElseThrow(() -> new EntityNotFoundException(User.class, id)));
    }

}

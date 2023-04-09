package org.johny7guitar.supersecretusersdb.services;

import org.johny7guitar.supersecretusersdb.entities.User;
import org.johny7guitar.supersecretusersdb.entities.UserStatus;
import org.johny7guitar.supersecretusersdb.repository.UserRepository;
import org.johny7guitar.supersecretusersdb.web.UserStatusChangeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.NoSuchElementException;

@Service
public class UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User addUser(Long id, String username, String email){
        return userRepository.findById(id)
                .orElse(userRepository.save(new User(id, username, email, URI.create(""))));
    }

    public UserStatusChangeDto updateUserStatus(long userId, UserStatus newUserStatus){

        User targetUser = userRepository.findById(userId)
                .orElseThrow(NoSuchElementException::new);

        UserStatus oldUserStatus = targetUser.getUserStatus();
        targetUser.setUserStatus(newUserStatus);

        User saved = userRepository.save(targetUser);

        return new UserStatusChangeDto(saved.getId(), oldUserStatus, saved.getUserStatus());

    }

}

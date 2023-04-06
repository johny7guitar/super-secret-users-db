package org.johny7guitar.supersecretusersdb.services;

import org.johny7guitar.supersecretusersdb.entities.User;
import org.johny7guitar.supersecretusersdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User addUser(Integer id, String username, String email){
        return userRepository.findById(id)
                .orElse(userRepository.save(new User(id, username, email, URI.create(""))));
    }

}

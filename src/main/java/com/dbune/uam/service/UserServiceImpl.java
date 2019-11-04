
package com.dbune.uam.service;

import java.util.ArrayList;
import java.util.List;

import com.dbune.uam.model.User;
import com.dbune.uam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        User dummyUser = new User();
        dummyUser.setId(123);
        dummyUser.setFirstName("John");
        dummyUser.setLastName("Doe");

        List<User> userList = new ArrayList<>();
        userList.add(dummyUser);
        return userList;
        // return userRepository.findAll();
    }

    public User getUser(long id) {
        User dummyUser = new User();
        dummyUser.setId(321);
        dummyUser.setFirstName("Dow");
        dummyUser.setLastName("John ");
        return dummyUser;
        // return userRepository.findById(id);
    }

}

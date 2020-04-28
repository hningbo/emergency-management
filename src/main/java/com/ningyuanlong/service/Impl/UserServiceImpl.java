package com.ningyuanlong.service.Impl;

import com.ningyuanlong.Repository.UserRepository;
import com.ningyuanlong.domain.User;
import com.ningyuanlong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tony on 2020/4/25.
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public void CreateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }


//    @Override
//    public User getByUsername(String s) {
//        return userRepository.get(s);
//    }

}

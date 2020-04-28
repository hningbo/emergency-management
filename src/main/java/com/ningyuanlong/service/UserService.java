package com.ningyuanlong.service;

import com.ningyuanlong.domain.User;

/**
 * Created by Tony on 2020/4/25.
 */
public interface UserService {
    void CreateUser(User user);

    User getByUsername(String username);
}

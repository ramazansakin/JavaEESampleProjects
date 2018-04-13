package com.sakin.service;

import com.sakin.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}

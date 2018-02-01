package com.tech.service;


import java.util.List;

import com.tech.domain.User;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
}

package com.WDA.bookstore.users.service;

import com.WDA.bookstore.users.mapper.UsersMapper;
import com.WDA.bookstore.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final static UsersMapper usersMapper = UsersMapper.INSTANCE;

    private UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
}

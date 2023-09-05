package com.WDA.bookstore.user.service;

import com.WDA.bookstore.user.entity.User;
import com.WDA.bookstore.user.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsersService {

        @Autowired
        private UsersRepository usersRepository;

        public UsersService(UsersRepository usersRepository){
            this.usersRepository = usersRepository;
        }

        @Transactional
        public User save(User user){
            return usersRepository.save( user );
        }

}

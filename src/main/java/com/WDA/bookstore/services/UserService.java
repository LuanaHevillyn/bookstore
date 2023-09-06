package com.WDA.bookstore.services;

import com.WDA.bookstore.models.User;
import com.WDA.bookstore.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    final UserRepository userRepository;

    public List<User> index() {
        return userRepository.findAll();
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User save(User user){
        return userRepository.save( user );
    }

    public User show(Long id) {
        return userRepository.getReferenceById ( id );
    }


    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(Long id,User newUser) throws Exception {
        User user = userRepository.getOne(id);
        if (user == null) {
            throw new Exception();
        }
        if (user.getId() != id) {
            throw new IllegalArgumentException();
        }

        newUser.setId(id);
        User userDB = userRepository.save(newUser);
        return userDB;
    }


}

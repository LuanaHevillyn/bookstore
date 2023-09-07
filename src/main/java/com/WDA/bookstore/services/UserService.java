package com.WDA.bookstore.services;

import com.WDA.bookstore.exceptions.userException.UserEmailAlredyExistsException;
import com.WDA.bookstore.exceptions.userException.UserNameAlredyExistsException;
import com.WDA.bookstore.models.User;
import com.WDA.bookstore.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    final UserRepository userRepository;

    public List<User> index() {
        return userRepository.findAll();
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user){

        Optional<User> userName = userRepository.findByName ( user.getName () );
        Optional<User> userEmail = userRepository.findByEmail ( user.getEmail () );

        if (userName.isPresent ()) {
            throw new UserNameAlredyExistsException ( user.getName () );
        } else if (userEmail.isPresent ()) {
            throw new UserEmailAlredyExistsException ( user.getEmail () );
        }else {
            return userRepository.save(user);
        }
    }

    public User show(Long id) {
        return userRepository.getReferenceById ( id );
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(Long id,User userEdited) {

        userEdited.setId(id);
        User userDB = userRepository.save(userEdited);
        return userDB;
    }

}

package com.WDA.bookstore.services;

import com.WDA.bookstore.dtos.UserDTO;
import com.WDA.bookstore.exceptions.userException.UserEmailAlredyExistsException;
import com.WDA.bookstore.exceptions.userException.UserNameAlredyExistsException;
import com.WDA.bookstore.models.User;
import com.WDA.bookstore.repositories.UserRepository;
import com.WDA.bookstore.utils.MapperBase;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MapperBase mapperBase;

    public List<UserDTO> findAll() {
        return mapperBase.toList(userRepository.findAll(), new TypeToken<List<UserDTO>>() {
        }.getType());
    }

    public User create(User user) {
        Optional<User> userName = userRepository.findByName(user.getName());
        Optional<User> userEmail = userRepository.findByEmail(user.getEmail());

        if(userName.isPresent()) {
            throw new UserNameAlredyExistsException(user.getName());
        } else if(userEmail.isPresent()) {
            throw new UserEmailAlredyExistsException(user.getEmail());
        } else {
            return userRepository.save(user);
        }
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(Long id, User user) {
        user.setId(id);

        Optional<User> userName = userRepository.findByName(user.getName());
        Optional<User> userEmail = userRepository.findByEmail(user.getEmail());

        if(userName.isPresent()) {
            throw new UserNameAlredyExistsException(user.getName());
        } else if(userEmail.isPresent()) {
            throw new UserEmailAlredyExistsException(user.getEmail());
        } else {
            return userRepository.save(user);
        }
    }

}

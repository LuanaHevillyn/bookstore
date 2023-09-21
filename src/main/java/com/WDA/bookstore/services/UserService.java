package com.WDA.bookstore.services;

import com.WDA.bookstore.dtos.outputs.UserOutput;
import com.WDA.bookstore.exceptions.CantDeleteException;
import com.WDA.bookstore.exceptions.EntityAlreadyExistsException;
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

    public List<UserOutput> findAll() {
        return mapperBase.toList(userRepository.findAll(), new TypeToken<List<UserOutput>>() {
        }.getType());
    }

    public List<User> WhoRentsMore() {
        return mapperBase.toList(userRepository.findWhoRentsMore(), new TypeToken<List<UserOutput>>() {
        }.getType());
    }

    public void create(User user) {
        checkIfCanCreateUser(user);
    }

    public void delete(Long id) {
        User user = userRepository.findById(id).get();
        if(user.getTotal_rents() > 0) {
            throw new CantDeleteException.UserCantBeDeleted();
        } else {
            userRepository.deleteById(id);
        }
    }

    public void update(User user) {
        user.getId();
        checkIfCanUpdateUser(user);
    }

    private void checkIfCanUpdateUser(User user) {
        Optional<User> userName = userRepository.findByName(user.getName());
        Optional<User> userEmail = userRepository.findByEmail(user.getEmail());
        if(userName.isPresent()) {
            throw new EntityAlreadyExistsException.UserNameAlredyExistsException();
        } else if(userEmail.isPresent()) {
            throw new EntityAlreadyExistsException.UserEmailAlredyExistsException();
        } else {
            userRepository.save(user);
        }
    }

    private void checkIfCanCreateUser(User user) {
        Optional<User> userName = userRepository.findByName(user.getName());
        Optional<User> userEmail = userRepository.findByEmail(user.getEmail());

        if(userName.isPresent()) {
            throw new EntityAlreadyExistsException.UserNameAlredyExistsException();
        } else if(userEmail.isPresent()) {
            throw new EntityAlreadyExistsException.UserEmailAlredyExistsException();
        } else {
            userRepository.save(user);
        }
    }

}

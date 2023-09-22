package com.WDA.bookstore.services;

import com.WDA.bookstore.dtos.outputs.UserOutput;
import com.WDA.bookstore.models.User;
import com.WDA.bookstore.repositories.UserRepository;
import com.WDA.bookstore.utils.MapperBase;
import com.WDA.bookstore.validations.user.UserEntityValidator;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityValidator userEntityValidator;

    @Autowired
    private MapperBase mapperBase;

    public List<UserOutput> findAll() {
        return mapperBase.toList(userRepository.findAll(), new TypeToken<List<UserOutput>>() {
        }.getType());
    }

    public List<User> whoRentsMore() {
        return mapperBase.toList(userRepository.findWhoRentsMore(), new TypeToken<List<UserOutput>>() {
        }.getType());
    }

    public void create(User user) {
        userEntityValidator.validateForCreate(user);
        userRepository.save(user);
    }

    public void delete(Long id) {
        userEntityValidator.validateForDelete(id);
        userRepository.deleteById(id);
    }

    public void update(User user) {
        userEntityValidator.validateForUpdate(user);
        userRepository.save(user);
    }
}

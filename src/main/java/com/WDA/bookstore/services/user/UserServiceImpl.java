package com.WDA.bookstore.services.user;

import com.WDA.bookstore.dtos.user.UserGetDTO;
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
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityValidator userEntityValidator;

    @Autowired
    private MapperBase mapperBase;

    public List<User> findAll() {
        return mapperBase.toList(userRepository.findAll(), new TypeToken<List<UserGetDTO>>() {
        }.getType());
    }

    public List<User> whoRentsMore() {
        return mapperBase.toList(userRepository.findWhoRentsMore(), new TypeToken<List<UserGetDTO>>() {
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

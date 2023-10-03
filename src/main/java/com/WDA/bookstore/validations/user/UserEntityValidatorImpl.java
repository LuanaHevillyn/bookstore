package com.WDA.bookstore.validations.user;

import com.WDA.bookstore.exceptions.user.UserCantBeDeletedException;
import com.WDA.bookstore.exceptions.user.UserEmailAlreadyExistsException;
import com.WDA.bookstore.exceptions.user.UserNameAlreadyExistsException;
import com.WDA.bookstore.models.User;
import com.WDA.bookstore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserEntityValidatorImpl implements UserEntityValidator {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void validateForCreate(User user) {
        validateName(user);
        validateEmail(user);
    }

    @Override
    public void validateForUpdate(User user) {
        validateName(user);
        validateEmail(user);
    }

    @Override
    public void validateForDelete(Long id) {
        validateTotalRents(id);
    }

    private void validateName(User user) {
        if(userRepository.existsByName(user.getName())) {
            throw new UserNameAlreadyExistsException();
        }
    }

    private void validateEmail(User user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new UserEmailAlreadyExistsException();
        }
    }

    private void validateTotalRents(Long id) {
        User user = userRepository.findById(id).get();
        if(user.getTotalRents() > 0) {
            throw new UserCantBeDeletedException();
        }
    }
}

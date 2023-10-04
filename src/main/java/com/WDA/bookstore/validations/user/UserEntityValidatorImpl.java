package com.WDA.bookstore.validations.user;

import com.WDA.bookstore.exceptions.user.UserCantBeDeletedException;
import com.WDA.bookstore.exceptions.user.UserDoesntExistException;
import com.WDA.bookstore.exceptions.user.UserEmailAlreadyExistsException;
import com.WDA.bookstore.exceptions.user.UserNameAlreadyExistsException;
import com.WDA.bookstore.models.User;
import com.WDA.bookstore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
        validateUserId(user);
        validateName(user);
        validateEmail(user);
    }

    @Override
    public void validateForDelete(Long id) {
        validateTotalRents(id);
    }

    private void validateName(User user) {
        if(userRepository.existsByNameAndIdNot(user.getName(), user.getId())) {
            throw new UserNameAlreadyExistsException();
        }
    }
    private void validateEmail(User user) {
        if(userRepository.existsByEmailAndIdNot(user.getEmail(), user.getId())) {
            throw new UserEmailAlreadyExistsException();
        }
    }

    private void validateUserId(User user) {
        boolean userOptional = userRepository.existsById(user.getId());
        if (!userOptional) {
            throw new UserDoesntExistException();
        }
    }

    private void validateTotalRents(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            if(user.getTotalRents() > 0) {
                throw new UserCantBeDeletedException();
            }
        }else {
            throw new UserDoesntExistException();
        }
    }
}

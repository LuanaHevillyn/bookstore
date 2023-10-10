package com.WDA.bookstore.services.user;

import com.WDA.bookstore.dtos.user.UserGetDTO;
import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {

     List<User> findAll();

     List<User> whoRentsMore();

     UserGetDTO findById(Long id);

     void create(User user);

     void update(User user);

     void delete(Long id);
}

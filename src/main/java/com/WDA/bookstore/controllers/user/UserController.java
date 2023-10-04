package com.WDA.bookstore.controllers.user;

import com.WDA.bookstore.dtos.user.UserCreateDTO;
import com.WDA.bookstore.dtos.user.UserGetDTO;
import com.WDA.bookstore.dtos.user.UserUpdateDTO;
import com.WDA.bookstore.mappers.UserMapper;
import com.WDA.bookstore.models.User;
import com.WDA.bookstore.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController implements UserControllerDocs {

    @Autowired
    private UserService userService;

    @Autowired
    UserMapper userMapper;

    @PostMapping
    @Override
    public ResponseEntity<Void> create(@RequestBody @Valid UserCreateDTO user) {
        userService.create(userMapper.mapTo(user));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("who-rents-more")
    @Override
    public ResponseEntity<List<User>> whoRentsMore() {
        return new ResponseEntity<>(userService.whoRentsMore(), HttpStatus.OK);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public UserGetDTO findById(Long id) {
        return userService.findById(id);
    }

    @PutMapping
    @Override
    public ResponseEntity<Void> update(@RequestBody @Valid UserUpdateDTO user) {
        userService.update(userMapper.mapTo(user));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

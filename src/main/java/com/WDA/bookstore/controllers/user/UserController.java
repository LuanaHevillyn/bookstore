package com.WDA.bookstore.controllers.user;

import com.WDA.bookstore.dtos.inputs.UserInput;
import com.WDA.bookstore.dtos.outputs.UserOutput;
import com.WDA.bookstore.mappers.UserMapper;
import com.WDA.bookstore.models.User;
import com.WDA.bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController implements UserControllerDocs {

    @Autowired
    private UserService userService;

    @Autowired
    UserMapper userMapper;

    @PostMapping
    @Override
    public ResponseEntity<Void> create(@RequestBody @Valid UserInput user) {
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
    public ResponseEntity<List<UserOutput>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    @Override
    public ResponseEntity<Void> update(@RequestBody UserInput user) {
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

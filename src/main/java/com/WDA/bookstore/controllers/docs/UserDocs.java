package com.WDA.bookstore.controllers.docs;

import com.WDA.bookstore.dtos.UserDTO;
import com.WDA.bookstore.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("userDocs")
public class UserDocs {
    private ModelMapper modelMapper;

    public UserDocs() {
        modelMapper = new ModelMapper();
    }

    public User mapTo(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}

package com.WDA.bookstore.controllers.docs;

import com.WDA.bookstore.dtos.UserDTO;
import com.WDA.bookstore.models.User;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("userDocs")
public class UserDocs {
    private ModelMapper modelMapper;

    final Converter<UserDTO, User> userConverter = new Converter<UserDTO, User>() {

        @Override
        public User convert(MappingContext<UserDTO, User> context) {
            UserDTO userDTO = context.getSource();
            User user = new User();
            user.setName (userDTO.getName ());
            user.setCity (userDTO.getCity ());
            user.setEmail (userDTO.getEmail ());
            user.setAddress (userDTO.getAddress ());
            return user;
        }
    };

    public UserDocs() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(userConverter);
    }

    public User mapTo(UserDTO userDTO) {
        return this.modelMapper.map(userDTO, User.class);
    }
}

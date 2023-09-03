package com.WDA.bookstore.users.mapper;

import com.WDA.bookstore.users.dto.UsersDTO;
import com.WDA.bookstore.users.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsersMapper {

    UsersMapper INSTANCE = Mappers.getMapper( UsersMapper.class );

    Users toModel(UsersDTO usersDTO);

    UsersDTO toDTO(Users users);
}

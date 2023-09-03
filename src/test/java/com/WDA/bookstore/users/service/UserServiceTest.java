package com.WDA.bookstore.users.service;

import com.WDA.bookstore.users.builder.UsersDTOBuilder;
import com.WDA.bookstore.users.dto.UsersDTO;
import com.WDA.bookstore.users.mapper.UsersMapper;
import com.WDA.bookstore.users.repository.UsersRepository;
import com.WDA.bookstore.users.service.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith( MockitoExtension.class )
public class UserServiceTest {

    private final UsersMapper usersMapper = UsersMapper.INSTANCE;

    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private UsersService usersService;

    private UsersDTOBuilder usersDTOBuilder;

    @BeforeEach
    void setUp() {
        usersDTOBuilder = UsersDTOBuilder.builder().build();
    }
}

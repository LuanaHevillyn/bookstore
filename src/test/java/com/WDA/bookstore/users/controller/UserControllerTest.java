package com.WDA.bookstore.users.controller;

import com.WDA.bookstore.users.builder.UsersDTOBuilder;
import com.WDA.bookstore.users.service.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@ExtendWith( MockitoExtension.class )
public class UserControllerTest {

    @Mock
    private UsersService usersService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    private UsersDTOBuilder usersDTOBuilder;

    @BeforeEach
    void setUp(){
        usersDTOBuilder = UsersDTOBuilder.builder().build();
        mockMvc = MockMvcBuilders.standaloneSetup( userController )
                .setCustomArgumentResolvers( new PageableHandlerMethodArgumentResolver() )
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView() )
                .build();
    }
}

package com.WDA.bookstore.user.controller;

import com.WDA.bookstore.user.dto.UsersDTO;
import com.WDA.bookstore.user.entity.User;
import com.WDA.bookstore.user.service.UsersService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController implements UserControllerDocs{

    private UsersService usersService;


    @ApiOperation ( value = "GET Users")
    @ApiResponses ( value = {
            @ApiResponse ( code = 200, message = "OK")
    })
    @GetMapping
    public String hello(){
        return "Hello Users";
    }

    @PostMapping
    public ResponseEntity<Object> saveUsers(@RequestBody @Valid UsersDTO usersDTO){
        var usersEntity = new User ();
        BeanUtils.copyProperties ( usersDTO, usersEntity );
        return ResponseEntity.status ( HttpStatus.CREATED ).body ( usersService.save ( usersEntity ) );
    }
}

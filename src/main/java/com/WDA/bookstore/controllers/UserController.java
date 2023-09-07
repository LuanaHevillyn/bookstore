package com.WDA.bookstore.controllers;

import com.WDA.bookstore.dtos.UserDTO;
import com.WDA.bookstore.models.User;
import com.WDA.bookstore.controllers.docs.UserDocs;
import com.WDA.bookstore.services.UserService;
import com.WDA.bookstore.utils.MapperBase;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    private UserDTO userDTO;

    @Autowired
    private UserService userService;

    @Autowired
    MapperBase mapperBase;

    @Autowired
    UserDocs userDocs;

    @PostMapping({ "/create"})
    @ApiOperation (value = "Criar usuário")
    public ResponseEntity<Object> createUser(@RequestBody @Valid  UserDTO user) {

        User userModel = userDocs.mapTo(user);
        User savedUser = userService.create (userModel);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();


        Map<String, Object> responseMessage = new HashMap<> ();

        responseMessage.put("message",  "Usuário criado com sucesso.");

        return ResponseEntity.created(location).body(responseMessage);
    }

    @ApiOperation(value = "Listar usuários")
    @GetMapping({ "/list" })
    // @formatter:off
    public ResponseEntity<?> indexUsers() {
        Type type = new TypeToken<List<UserDTO>>() {}.getType();

        List<UserDTO> result = mapperBase.toList(userService.index(), type);
        return ResponseEntity.ok(result);

    }

    @ApiOperation(value = "Listar apenas um usuário")
    @GetMapping({ "/list_id/{id}/"})
    public UserDTO showUser(@PathVariable("id") Long id) {
        return mapperBase.mapTo(userService.show(id), UserDTO.class);
    }


    @PutMapping({ "/put/{id}/" })
    @ApiOperation(value = "Editar usuário")
    public ResponseEntity<?> updateUser(
            @Min(value = 1) @PathVariable("id") Long id,
            @RequestBody UserDTO user) throws Exception {
        User user1= userDocs.mapTo(user);
        userService.update(id, user1);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping({ "/delete/{id}/"})
    @ApiOperation(value = "Deletar usuário")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}

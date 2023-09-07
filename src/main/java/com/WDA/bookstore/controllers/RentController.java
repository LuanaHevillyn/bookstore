package com.WDA.bookstore.controllers;

import com.WDA.bookstore.controllers.docs.RentDocs;
import com.WDA.bookstore.dtos.RentDTO;
import com.WDA.bookstore.models.Rent;
import com.WDA.bookstore.services.RentService;
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
import java.util.List;

@RestController
@RequestMapping("/api/v1/rents")
public class RentController {

    @Autowired
    private RentService rentService;

    @Autowired
    MapperBase mapperBase;

    @Autowired
    RentDocs rentDocs;

    @PostMapping({ "/create"})
    @ApiOperation(value = "Criar aluguel")
    public ResponseEntity<Object> createUser(@Valid @RequestBody RentDTO rent) {

        Rent userModel = rentDocs.mapTo(rent);
        Rent savedUser = rentService.create (userModel);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Listar aluguéis")
    @GetMapping({ "/list" })
    // @formatter:off
    public ResponseEntity<?> indexRent() {
        Type type = new TypeToken<List<RentDTO>>() {}.getType();

        List<RentDTO> result = mapperBase.toList(rentService.index(), type);
        return ResponseEntity.ok(result);

    }

    @ApiOperation(value = "Listar apenas um aluguel")
    @GetMapping({ "/list_id/{id}/"})
    public RentDTO showUser(@PathVariable("id") Long id) {
        return mapperBase.mapTo(rentService.show(id), RentDTO.class);
    }

    @PutMapping({ "/put/{id}/" })
    @ApiOperation(value = "Editar aluguel")
    public ResponseEntity<?> updateRent(
            @Min(value = 1) @PathVariable("id") Long id,
            @RequestBody RentDTO rent) throws Exception {
        Rent rent1= rentDocs.mapTo(rent);
        rentService.update(id, rent1);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping({ "/delete/{id}/"})
    @ApiOperation(value = "Deletar aluguel")
    public ResponseEntity<?> deleteRent(@PathVariable("id") Long id) {
        rentService.delete(id);
        return ResponseEntity.ok().build();
    }

}

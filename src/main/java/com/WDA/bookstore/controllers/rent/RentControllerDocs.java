package com.WDA.bookstore.controllers.rent;

import com.WDA.bookstore.dtos.rent.RentCreateDTO;
import com.WDA.bookstore.dtos.rent.RentGetDTO;
import com.WDA.bookstore.dtos.rent.RentUpdateDTO;
import com.WDA.bookstore.models.Rent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Api(tags = "Rents")
@ApiResponses({@ApiResponse(code = 500, message = "There was an internal error", response = Problem.class)})
public interface RentControllerDocs {

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Rent created."),
            @ApiResponse(code = 400, message = "Missing data. Check and try again."),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    @PostMapping
    ResponseEntity<Void> create(@ApiParam(name = "body", value = "Representation of a new rent", required = true) RentCreateDTO request);

    @GetMapping
    ResponseEntity<List<Rent>> findAll();

    @GetMapping("/{id}")
    RentGetDTO findById(Long id);

    @PutMapping
    ResponseEntity<Void> update(@RequestBody @Valid RentUpdateDTO rent);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}

package com.WDA.bookstore.controllers.rent;

import com.WDA.bookstore.dtos.inputs.RentInput;
import com.WDA.bookstore.dtos.outputs.RentOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Rents")
@ApiResponses({@ApiResponse(code = 500, message = "There was an internal error", response = Problem.class)})
public interface RentControllerDocs {

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Rent created."),
            @ApiResponse(code = 400, message = "Missing data. Check and try again."),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    @PostMapping
    ResponseEntity<Void> create(@ApiParam(name = "body", value = "Representation of a new rent", required = true) RentInput request);

    @GetMapping
    public ResponseEntity<List<RentOutput>> findAll();

    @PutMapping
    ResponseEntity<Void> update(@RequestBody RentInput rent);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}

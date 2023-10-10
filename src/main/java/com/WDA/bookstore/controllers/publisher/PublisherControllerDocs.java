package com.WDA.bookstore.controllers.publisher;

import com.WDA.bookstore.dtos.publisher.PublisherCreateDTO;
import com.WDA.bookstore.dtos.publisher.PublisherGetDTO;
import com.WDA.bookstore.dtos.publisher.PublisherUpdateDTO;
import com.WDA.bookstore.models.Publisher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Publishers")
@ApiResponses({@ApiResponse(code = 500, message = "There was an internal error", response = Problem.class)})
public interface PublisherControllerDocs {

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "publisher created."),
            @ApiResponse(code = 400, message = "Missing data. Check and try again."),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    @PostMapping
    ResponseEntity<Void> create(@ApiParam(name = "body", value = "Representation of a new publisher", required = true) PublisherCreateDTO request);

    @GetMapping
    ResponseEntity<?> findAll();

    @GetMapping("findMostUsed")
    ResponseEntity<List<Publisher>> findMostUsed();

    PublisherGetDTO findById(Long id);

    @PutMapping
    ResponseEntity<Void> update(@RequestBody @Valid PublisherUpdateDTO publisher);


    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}

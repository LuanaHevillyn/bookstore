package com.WDA.bookstore.controllers;

import com.WDA.bookstore.controllers.docs.PublisherDocs;
import com.WDA.bookstore.dtos.PublisherDTO;
import com.WDA.bookstore.models.Publisher;
import com.WDA.bookstore.services.PublisherService;
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
@RequestMapping("/api/v1/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @Autowired
    MapperBase appControllerBase;

    @Autowired
    PublisherDocs publisherDocs;

    @PostMapping({ "/create"})
    @ApiOperation(value = "Criar editora")
    public ResponseEntity<Object> createUser(@Valid @RequestBody PublisherDTO publisher) {
        Publisher userModel = publisherDocs.mapTo(publisher);
        Publisher savedUser = publisherService.save (userModel);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Listar editoras")
    @GetMapping({ "/list" })
    // @formatter:off
    public ResponseEntity<?> indexPublisher() {
        Type type = new TypeToken<List<PublisherDTO>>() {}.getType();

        List<PublisherDTO> result = appControllerBase.toList(publisherService.index(), type);
        return ResponseEntity.ok(result);

    }

    @ApiOperation(value = "Listar apenas uma editora")
    @GetMapping({ "/list_id/{id}/"})
    public PublisherDTO showUser(@PathVariable("id") Long id) {
        return appControllerBase.mapTo(publisherService.show(id), PublisherDTO.class);
    }

    @PutMapping({ "/put/{id}/" })
    @ApiOperation(value = "Editar editora")
    public ResponseEntity<?> updatePublisher(
            @Min(value = 1) @PathVariable("id") Long id,
            @RequestBody PublisherDTO publisher) throws Exception {
        Publisher publisher1= publisherDocs.mapTo(publisher);
        publisherService.update(id, publisher1);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping({ "/delete/{id}/"})
    @ApiOperation(value = "Deletar editora")
    public ResponseEntity<?> deletePublisher(@PathVariable("id") Long id) {
        publisherService.delete(id);
        return ResponseEntity.ok().build();
    }

}

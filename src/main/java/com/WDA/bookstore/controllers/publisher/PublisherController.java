package com.WDA.bookstore.controllers.publisher;

import com.WDA.bookstore.dtos.PublisherDTO;
import com.WDA.bookstore.mappers.PublisherMapper;
import com.WDA.bookstore.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/publishers")
public class PublisherController implements PublisherControllerDocs {

    @Autowired
    private PublisherService publisherService;

    @Autowired
    PublisherMapper publisherMapper;

    @PostMapping
    @Override
    public ResponseEntity<Void> create(@RequestBody @Valid PublisherDTO publisher) {
        publisherService.create(publisherMapper.mapTo(publisher));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<PublisherDTO>> findAll() {
        return new ResponseEntity<>(publisherService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody PublisherDTO publisher) {
        publisherService.update(id, publisherMapper.mapTo(publisher));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        publisherService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

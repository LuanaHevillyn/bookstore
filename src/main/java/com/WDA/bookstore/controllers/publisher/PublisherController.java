package com.WDA.bookstore.controllers.publisher;

import com.WDA.bookstore.dtos.inputs.PublisherInput;
import com.WDA.bookstore.dtos.outputs.PublisherOutput;
import com.WDA.bookstore.mappers.PublisherMapper;
import com.WDA.bookstore.models.Publisher;
import com.WDA.bookstore.repositories.PublisherRepository;
import com.WDA.bookstore.services.PublisherService;
import com.WDA.bookstore.utils.MapperBase;
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
    private PublisherRepository publisherRepository;

    @Autowired
    private MapperBase mapperBase;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    PublisherMapper publisherMapper;

    @PostMapping
    @Override
    public ResponseEntity<Void> create(@RequestBody @Valid PublisherInput publisher) {
        publisherService.create(publisherMapper.mapTo(publisher));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<PublisherOutput>> findAll() {
        return new ResponseEntity<>(publisherService.findAll(), HttpStatus.OK);
    }

    @GetMapping("findMostUsed")
    @Override
    public ResponseEntity<List<Publisher>> findMostUsed() {
        return new ResponseEntity<>(publisherService.findMostUsed(), HttpStatus.OK);
    }

    @PutMapping
    @Override
    public ResponseEntity<Void> update(@RequestBody PublisherInput publisher) {
        publisherService.update(publisherMapper.mapTo(publisher));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        publisherService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

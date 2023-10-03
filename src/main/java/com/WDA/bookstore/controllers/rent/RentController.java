package com.WDA.bookstore.controllers.rent;

import com.WDA.bookstore.dtos.rent.RentCreateDTO;
import com.WDA.bookstore.dtos.rent.RentUpdateDTO;
import com.WDA.bookstore.mappers.RentMapper;
import com.WDA.bookstore.models.Rent;
import com.WDA.bookstore.services.rent.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rents")
public class RentController implements RentControllerDocs {

    @Autowired
    private RentService rentService;

    @Autowired
    RentMapper rentMapper;

    @PostMapping
    @Override
    public ResponseEntity<Void> create(@RequestBody @Valid RentCreateDTO rent) {
        rentService.create(rentMapper.mapTo(rent));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Rent>> findAll() {
        return new ResponseEntity<>(rentService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    @Override
    public ResponseEntity<Void> update(@RequestBody @Valid RentUpdateDTO rent) {
        rentService.update(rentMapper.mapTo(rent));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

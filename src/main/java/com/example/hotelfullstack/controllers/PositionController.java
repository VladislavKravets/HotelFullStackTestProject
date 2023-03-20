package com.example.hotelfullstack.controllers;

import com.example.hotelfullstack.models.Client;
import com.example.hotelfullstack.models.Position;
import com.example.hotelfullstack.services.PositionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionController {
    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public ResponseEntity<List<Position>> getAllPosition() {
        List<Position> positions = positionService.getAllPosition();
        return new ResponseEntity<>(positions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Position> getPositionById(@PathVariable Long id) {
        return new ResponseEntity<>(positionService.getPositionById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Position> createPosition(@RequestBody Position position) {
        return new ResponseEntity<>(positionService.createPosition(position), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Position> updatePosition(@PathVariable Long id, @RequestBody Position position) {
        return new ResponseEntity<>(positionService.updatePosition(id, position), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Position> deletePosition(@PathVariable Long id) {
        positionService.deletePosition(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package com.example.hotelfullstack.controllers;

import com.example.hotelfullstack.models.TypeRoom;
import com.example.hotelfullstack.services.TypeRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type-rooms")
public class TypeRoomController {
    private final TypeRoomService typeRoomService;
    public TypeRoomController(TypeRoomService typeRoomService) {
        this.typeRoomService = typeRoomService;
    }
    @GetMapping
    public ResponseEntity<List<TypeRoom>> getAllTypeRooms() {
        List<TypeRoom> rooms = typeRoomService.getAllTypeRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TypeRoom> getTypeRoomById(@PathVariable Long id) {
        TypeRoom typeRoom = typeRoomService.getTypeRoomById(id);
        return new ResponseEntity<>(typeRoom, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<TypeRoom> createTypeRoom(@RequestBody TypeRoom typeRoom) {
        return new ResponseEntity<>(typeRoomService.createTypeRoom(typeRoom), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TypeRoom> updateTypeRoom(@PathVariable Long id, @RequestBody TypeRoom typeRoomDTO) {
        return new ResponseEntity<>(typeRoomService.updateTypeRoom(id, typeRoomDTO), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeRoom(@PathVariable Long id) {
        typeRoomService.deleteTypeRoom(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

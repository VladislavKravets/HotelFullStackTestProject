package com.example.hotelfullstack.services;

import com.example.hotelfullstack.exceptions.ResourceNotFoundException;
import com.example.hotelfullstack.models.TypeRoom;
import com.example.hotelfullstack.repositories.TypeRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeRoomService {
    private final TypeRoomRepository typeRoomRepository;

    @Autowired
    public TypeRoomService(TypeRoomRepository typeRoomRepository) {
        this.typeRoomRepository = typeRoomRepository;
    }

    public List<TypeRoom> getAllTypeRooms() {
        return typeRoomRepository.findAll();
    }

    public TypeRoom createTypeRoom(TypeRoom typeRoom) {
        return typeRoomRepository.save(typeRoom);
    }

    public TypeRoom getTypeRoomById(Long id) {
        return typeRoomRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException("Not found type room")
        );
    }

    public TypeRoom updateTypeRoom(Long id, TypeRoom typeRoom) {
        TypeRoom updatedTypeRoom = typeRoomRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException("Not found type room")
        );
        updatedTypeRoom.setName(typeRoom.getName());
        return typeRoomRepository.save(updatedTypeRoom);
    }

    public void deleteTypeRoom(Long id) {
        TypeRoom typeRoom = typeRoomRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException("not found type room")
        );
        typeRoomRepository.delete(typeRoom);
    }
}

package com.example.hotelfullstack.services;

import com.example.hotelfullstack.dtos.RoomDTO;
import com.example.hotelfullstack.models.Room;
import com.example.hotelfullstack.models.TypeRoom;
import com.example.hotelfullstack.repositories.RoomRepository;
import com.example.hotelfullstack.repositories.TypeRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final TypeRoomRepository typeRoomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository, TypeRoomRepository typeRoomRepository) {
        this.roomRepository = roomRepository;
        this.typeRoomRepository = typeRoomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException("Room not found")
        );
    }

    public Room createRoom(RoomDTO roomDTO, Long typeRoomId) {
        TypeRoom typeRoom = typeRoomRepository.findById(typeRoomId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid type room ID"));

        Room room = new Room();
        room.setCapacity(roomDTO.getCapacity());
        room.setCost(roomDTO.getCost());
        room.setDescription(roomDTO.getDescription());
        room.setTypeRoom(typeRoom);
        return roomRepository.save(room);
    }

    public Room updateRoom(Long id, RoomDTO roomDTO, Long typeRoomId) {
        Room room = roomRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException("Room not found")
        );
        TypeRoom typeRoom = typeRoomRepository.findById(typeRoomId).orElseThrow(
//                () -> new IllegalArgumentException("Invalid type room ID")
        );

        room.setCapacity(roomDTO.getCapacity());
        room.setTypeRoom(typeRoom);
        room.setCost(roomDTO.getCost());
        room.setDescription(roomDTO.getDescription());

        return roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException("Room not found")
        );
        roomRepository.delete(room);
    }
}

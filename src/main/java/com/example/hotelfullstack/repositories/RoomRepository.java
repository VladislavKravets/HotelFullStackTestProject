package com.example.hotelfullstack.repositories;

import com.example.hotelfullstack.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}

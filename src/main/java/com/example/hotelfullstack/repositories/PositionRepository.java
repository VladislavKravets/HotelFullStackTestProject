package com.example.hotelfullstack.repositories;

import com.example.hotelfullstack.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}

package com.example.hotelfullstack.services;

import com.example.hotelfullstack.exceptions.ResourceNotFoundException;
import com.example.hotelfullstack.models.Position;
import com.example.hotelfullstack.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {
    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> getAllPosition() {
        return positionRepository.findAll();
    }

    public Position createPosition(Position position) {
        return positionRepository.save(position);
    }

    public Position getPositionById(Long id) {
        return positionRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException("Not found position")
        );
    }

    public Position updatePosition(Long id, Position position) {
        Position updatedPosition = positionRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException("Not found position")
        );
        updatedPosition.setName(position.getName());
        updatedPosition.setSalary(position.getSalary());
        updatedPosition.setResponsibilities(position.getResponsibilities());
        return positionRepository.save(updatedPosition);
    }

    public void deletePosition(Long id) {
        Position position = positionRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException("not found position")
        );
        positionRepository.delete(position);
    }

}

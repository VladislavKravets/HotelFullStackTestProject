package com.example.hotelfullstack.services;

import com.example.hotelfullstack.dtos.EmployeeDTO;
import com.example.hotelfullstack.exceptions.ResourceNotFoundException;
import com.example.hotelfullstack.models.Employee;
import com.example.hotelfullstack.models.Position;
import com.example.hotelfullstack.repositories.EmployeeRepository;
import com.example.hotelfullstack.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, PositionRepository positionRepository) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException("Employee not found")
        );
    }

    public Employee createEmployee(EmployeeDTO employeeDTO, Long positionId) {
        Position position = positionRepository.findById(positionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid position ID"));

        Employee employee = new Employee();

        employee.setFullName(employeeDTO.getFullName());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setSex(employeeDTO.getSex());
        employee.setPhone(employeeDTO.getPhone());
        employee.setPositionId(position);

        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO, Long positionId) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException("Employee not found")
        );
        Position position = positionRepository.findById(positionId).orElseThrow(
//                () -> new IllegalArgumentException("Invalid position ID")
        );

        employee.setFullName(employeeDTO.getFullName());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setSex(employeeDTO.getSex());
        employee.setPhone(employeeDTO.getPhone());
        employee.setPositionId(position);

        return employeeRepository.save(employee);
    }

    public String deleteEmployee(Long id) {
        try {
            Employee employee = employeeRepository.findById(id).orElseThrow(
//                    () -> new ResourceNotFoundException("Employee not found")
            );
            employeeRepository.delete(employee);
            return "Employee deleted successfully";
        } catch (ResourceNotFoundException ex) {
            return "Error: " + ex.getMessage();
        } catch (Exception ex) {
            return "Error deleting employee: " + ex.getMessage();
        }
    }
}

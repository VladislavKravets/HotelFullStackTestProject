package com.example.hotelfullstack.repositories;

import com.example.hotelfullstack.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

package com.shahrukh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shahrukh.entity.Employee;
import java.util.Optional;


@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Long>{

	Optional<Employee> findByEmail(String email);

}

package com.test.test.repositroy;
import org.springframework.data.repository.CrudRepository;

import com.test.test.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}

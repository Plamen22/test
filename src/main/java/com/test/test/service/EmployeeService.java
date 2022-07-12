package com.test.test.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.test.models.Employee;
import com.test.test.repositroy.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public boolean existsById(int id) {
        return employeeRepository.existsById(id);
    }

    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateWithPartialDate(int id, Employee updateInfo) {

        Optional<Employee> employeeFound = findById(id);

        Employee employeeToUpdate = employeeFound.get();

        if (updateInfo.getName() != null && updateInfo.getName().length() > 0) { // if the request has a name param
            employeeToUpdate.setName(updateInfo.getName());
        }
        if (updateInfo.getSalary() != 0) { // if the request, has a non-zero salary
            employeeToUpdate.setSalary(updateInfo.getSalary());
        }
        if (updateInfo.getContractId() != 0) { // if the request, has a non-zero contract id
            employeeToUpdate.setContractId(updateInfo.getContractId());
        }

        return employeeRepository.save(employeeToUpdate);
    }

    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}

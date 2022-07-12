package com.test.test.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.test.models.Employee;
import com.test.test.models.NotFoundException;
import com.test.test.service.EmployeeService;

@RestController
@RequestMapping("employees")
public class ReservationController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    private ResponseEntity<Iterable<Employee>> getAll() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    //employees/111
    @GetMapping(value = "/{id}")
    private ResponseEntity<Employee> getOne(@PathVariable int id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK); // If so, give me the value of that key
        }
        throw new NotFoundException(String.format("Employee with id %d not found", id));
    }

    @PostMapping
    private ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    private ResponseEntity<Employee> update(@PathVariable int id, @RequestBody Employee employee) {
        Optional<Employee> employeeFound = employeeService.findById(id);

        if (!employeeFound.isPresent()) {
            return new ResponseEntity<>(employee, HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    private ResponseEntity<Employee> updatePartially(@PathVariable int id, @RequestBody Employee updateInfo) {
        Optional<Employee> employeeFound = employeeService.findById(id);
        if (!employeeFound.isPresent()) {
            return new ResponseEntity<>(updateInfo, HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(employeeService.updateWithPartialDate(id, updateInfo), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    private void delete(@PathVariable int id) {
        if (!employeeService.existsById(id)) {
            throw new NotFoundException("Not found");
        }
        employeeService.deleteById(id);
    }

}

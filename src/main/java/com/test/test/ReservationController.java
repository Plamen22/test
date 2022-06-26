package com.test.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employees")
public class ReservationController {

    private int lastKey = 5;

    private Map<Integer, Employee> employees;

    ReservationController() {
        employees = new HashMap<>();
        employees.put(1, new Employee(1, "Radoslav", 234435, -100, null));
        employees.put(2, new Employee(2, "Chavdar", 878678, 2000, null));
        employees.put(3, new Employee(3, "Plamen", 1435, 2100, null));
        employees.put(4, new Employee(4, "Kaloqn", 878678, 1900, null));
    }

    /*
    key - value
    1     Radoslav
    2     Chavdar
    3     Plamen
    4     Kaloqn
     */
    @GetMapping
    private ResponseEntity<Collection<Employee>> getAll() {
        return new ResponseEntity<>(employees.values(), HttpStatus.OK);
    }

    //employees/111
    @GetMapping(value = "/{id}")
    private ResponseEntity<Employee> getOne(@PathVariable int id) {
        if (employees.containsKey(id)) { // Do you have such a key (such an employee?)
            return new ResponseEntity<>(employees.get(id), HttpStatus.OK); // If so, give me the value of that key
        }
        // If we get here, then we don't have such a key
        return new ResponseEntity<>(new Employee(0, "Uknown", -1, -1, null), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    private ResponseEntity<Employee> create(@RequestBody Employee employee) {
        employees.put(lastKey++, employee);
        return new ResponseEntity<>(employee, HttpStatus.OK); // If so, give me the value of that key
    }

    @PutMapping(value = "/{id}")
    private ResponseEntity<Employee> update(@PathVariable int id, @RequestBody Employee employee) {
        if (!employees.containsKey(id)) {
            return new ResponseEntity<>(employee, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        employees.put(id, employee);
        return new ResponseEntity<>(employee, HttpStatus.OK); // If so, give me the value of that key
    }
}

package com.example.demo.rest;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    /**
     * TODO::handle the exceptions for employee not found
     * @param employeeService
     */
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> findAll(){
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> findById(@PathVariable(name = "employeeId") Integer id){
        Employee employee = employeeService.findById(id);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @DeleteMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> deleteById(@PathVariable(name = "employeeId") Integer id){
        employeeService.deleteById(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @PostMapping("/employee")
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        /**
         * Incase is has been provided in json
         */
        employee.setId(0);
        Employee employee1 = employeeService.save(employee);
        return new ResponseEntity<>(employee1, HttpStatus.OK);
    }
    @PutMapping("/employee")
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        Employee employee1 = employeeService.save(employee);
        return new ResponseEntity<>(employee1, HttpStatus.OK);
    }
}

package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.error.ErrorsHandler;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.utility.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private InputValidator inputValidator;
    private EmployeeResourceImpl(EmployeeService employeeService, InputValidator inputValidator){
        this.employeeService = employeeService;
        this.inputValidator = inputValidator;
    }

    @Override
    public ResponseEntity<Employee> employeeGetById(String id) {

        Employee employee = new Employee();
        employee.setId(Integer.valueOf(id));
        employee.setFirstName("BFS");
        employee.setLastName("Developer");

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @Override
    public ResponseEntity createEmployee(Employee employeeReq) {
        if(null != employeeReq.getId()){
            Optional<Employee> employee = employeeService.getById(employeeReq.getId()+"");
            if(employee.isPresent()) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Employee exist");
            }
        }
        Optional<List<ErrorsHandler>> errorsList = inputValidator.getErrors(employeeReq);
        if(errorsList.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorsList);
        }
        return employeeService.create(employeeReq) ? new ResponseEntity<>(HttpStatus.CREATED) :
                new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    }
}

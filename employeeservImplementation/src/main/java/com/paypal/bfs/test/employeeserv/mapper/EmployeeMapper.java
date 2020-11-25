package com.paypal.bfs.test.employeeserv.mapper;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.model.EmployeesDetails;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeesDetails linkDB(Employee employee){
        EmployeesDetails employeesDetails = new EmployeesDetails();
        employeesDetails.setFirstName(employee.getFirstName());
        employeesDetails.setLastName(employee.getLastName());
        employeesDetails.setDateOfBirth(employee.getDateOfBirth());
        employeesDetails.setAddessLine1(employee.getAddressLine1());
        employeesDetails.setAddressLine2(employee.getAddressLine2());
        employeesDetails.setCity(employee.getCity());
        employeesDetails.setState(employee.getState());
        employeesDetails.setCountry(employee.getCountry());
        employeesDetails.setZipCode(employee.getZipCode());
        return employeesDetails;

    }
    public Employee APILink(EmployeesDetails employeesDetails){
        Employee employee = new Employee();
        employee.setId(employeesDetails.getId());
        employee.setFirstName(employeesDetails.getFirstName());
        employee.setLastName(employeesDetails.getLastName());
        employee.setDateOfBirth(employeesDetails.getDateOfBirth());
        employee.setAddressLine1(employeesDetails.getAddessLine1());
        employee.setAddressLine2(employeesDetails.getAddressLine2());
        employee.setCity(employeesDetails.getCity());
        employee.setState(employeesDetails.getState());
        employee.setCountry(employeesDetails.getCountry());
        employee.setZipCode(employeesDetails.getZipCode());
        return employee;
    }
}

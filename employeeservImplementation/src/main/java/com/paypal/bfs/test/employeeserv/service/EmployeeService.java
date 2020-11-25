package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.mapper.EmployeeMapper;
import com.paypal.bfs.test.employeeserv.model.EmployeesDetails;
import com.paypal.bfs.test.employeeserv.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;
    private final Map<Integer, Employee> map = new HashMap<>();
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper){
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }
    public Optional<Employee> getById(String id ){
        Employee employee = map.get(Integer.valueOf(id));
        if(Objects.nonNull(employee)){
            return Optional.of(employee);
        }
        Optional<EmployeesDetails> ed = employeeRepository.findById(Integer.valueOf(id));
        if(ed.isPresent()){
            Employee em = employeeMapper.APILink(ed.get());
            if(Objects.nonNull(em)){
                map.put(em.getId(), em);
                return Optional.of(em);
            }
        }
        return Optional.empty();
    }
    public boolean create (Employee employee){
        EmployeesDetails employeesDetails = null;
        try {
            employeesDetails = employeeRepository.save(employeeMapper.linkDB(employee));
            if (Objects.nonNull(employeesDetails)) {
                return true;
            }
        }catch(Exception e){
            System.out.println("Error creating table " + e);
        }
        return false;
    }
}

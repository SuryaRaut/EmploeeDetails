package com.paypal.bfs.test.employeeserv.repo;

import com.paypal.bfs.test.employeeserv.model.EmployeesDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeesDetails, Integer> {
}

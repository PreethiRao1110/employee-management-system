package com.EmployeeManagement.Portal.Service;

import com.EmployeeManagement.Portal.Model.Employee;
import com.EmployeeManagement.Portal.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public Employee saveEmployee(Employee employee) throws IllegalStateException {
        Optional<Employee> existingEmployee = employeeRepo.findByEmail(employee.getEmail());

        if (existingEmployee.isPresent()) {
            System.out.println("Employee already exists");
            throw new IllegalStateException("Employee with email " +employee.getEmail() + " already exists");
        } else {
            return employeeRepo.save(employee);
        }
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepo.findById(id);
    }


    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
       Employee employee1 = employeeRepo.findById(id).orElseThrow();
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());
        return employeeRepo.save(employee1);
    }

    @Override
    public void deleteEmployee(int id) {
        if (employeeRepo.existsById(id)){
            employeeRepo.deleteById(id);
            System.out.println("Employee deleted");
        } else {
            System.out.println("Employee not found");
        }
    }

}

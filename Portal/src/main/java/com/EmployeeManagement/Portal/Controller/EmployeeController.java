package com.EmployeeManagement.Portal.Controller;

import com.EmployeeManagement.Portal.Model.Employee;
import com.EmployeeManagement.Portal.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
   private EmployeeService employeeService;

//This is a post request, and we are saving employee here
    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

//This is a get request and here we are getting employees by their id
    @GetMapping("/get/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }

//Here we are getting all the employees
    @GetMapping("/get/all")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

//Updating the existing employee
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

//Deleting the existing employee
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
    }

}

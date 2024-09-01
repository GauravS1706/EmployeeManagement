package com.emp.controller;


import com.emp.dto.EmployeeDto;
import com.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping
public class EmployeeController {

    @Autowired
    private EmployeeService empService;


    @PostMapping("/emp/add")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto empDto)
    {
        EmployeeDto savedEmp=empService.createEmployee(empDto);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }

    @GetMapping("/emp/{id}")
    @ResponseBody
    public  ResponseEntity<EmployeeDto> getEmployeeByID(@PathVariable("id")  Long empId)
    {
        EmployeeDto employeeDto =empService.getEmpById(empId);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping("/emp")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee()
    {
        List<EmployeeDto> employeeDto=empService.getAllEmp();
        return ResponseEntity.ok(employeeDto);

    }

    @PutMapping("/emp/{id}")
    public  ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long empId ,@RequestBody EmployeeDto updateEmp)
    {
        EmployeeDto empDto=empService.updateEmp(empId,updateEmp);
        return ResponseEntity.ok(empDto);
    }


    @DeleteMapping("/emp/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long empId)
    {
        empService.deleteEmp(empId);
        return ResponseEntity.ok("Employee Delete Successfully");
    }



}

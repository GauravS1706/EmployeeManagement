package com.emp.service;

import com.emp.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto empDto);

    EmployeeDto getEmpById(Long empId);

    List<EmployeeDto> getAllEmp();

    void  deleteEmp(Long empId);

    EmployeeDto  updateEmp(Long empId, EmployeeDto updateEmployee);
}

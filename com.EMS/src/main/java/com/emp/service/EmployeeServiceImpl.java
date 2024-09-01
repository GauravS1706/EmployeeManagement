   package com.emp.service;

import com.emp.dto.EmployeeDto;
import com.emp.entity.Employee;
import com.emp.exception.ResourceNotFoundException;
import com.emp.mapper.EmployeeMapper;
import com.emp.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo empRepo;

    @Override
    public EmployeeDto createEmployee(EmployeeDto empDto) {
        Employee emp= EmployeeMapper.mapEmployee(empDto);
        Employee savedEmp=empRepo.save(emp);
        return EmployeeMapper.mapEmployeeDto(savedEmp);
    }

    @Override
    public EmployeeDto getEmpById(Long empId) {
        Employee emp = empRepo.findById(empId)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("Employee is not exists with given id : "+empId)
                );
        return EmployeeMapper.mapEmployeeDto(emp);
    }

    @Override
    public List<EmployeeDto> getAllEmp() {
        List<Employee>  emp=empRepo.findAll();
        return emp.stream().map((employee)-> EmployeeMapper.mapEmployeeDto(employee)).collect(Collectors.toList());
//          return  emp.stream().map(EmployeeMapper::mapEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmp(Long empId, EmployeeDto updateEmployee) {
        Employee emp=empRepo.findById(empId)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("Employee is not exists with given id : " + empId )
                );
        emp.setFName(updateEmployee.getFName());
        emp.setLName(updateEmployee.getLName());
        emp.setEMail(updateEmployee.getEMail());
        Employee updateEmployeeobj = empRepo.save(emp);
        return EmployeeMapper.mapEmployeeDto(updateEmployeeobj);
    }

    @Override
    public void deleteEmp(Long empID) {
        Employee emp=empRepo.findById(empID)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("Employee is not exists with given id : " + empID )
                );
        empRepo.deleteById(empID);

    }

}

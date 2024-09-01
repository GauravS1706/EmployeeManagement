package com.emp.mapper;

import com.emp.dto.EmployeeDto;
import com.emp.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapEmployeeDto(Employee emp)
    {
        return new EmployeeDto(
                emp.getId(),
                emp.getFName(),
                emp.getLName(),
                emp.getEMail()
        );
    }

    public static Employee mapEmployee(EmployeeDto empDto)
    {
        return  new Employee(
                empDto.getId(),
                empDto.getFName(),
                empDto.getLName(),
                empDto.getEMail()
        );
    }

}

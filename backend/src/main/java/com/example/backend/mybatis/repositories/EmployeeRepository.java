package com.example.backend.mybatis.repositories;

import com.example.backend.models.Employee;
import com.example.backend.mybatis.UuidTypeHandler;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeRepository {

    @Select("""
            SELECT * FROM employee;
            """)
    @Result(column = "id", property = "id", typeHandler = UuidTypeHandler.class)
    List<Employee> getAllEmployees();
}

package com.example.backend.mybatis.repositories;

import com.example.backend.models.Employee;
import com.example.backend.mybatis.UuidTypeHandler;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Mapper
@Repository
public interface EmployeeRepository {

    @Select("""
            SELECT * FROM employee;
            """)
    @Result(column = "id", property = "id", typeHandler = UuidTypeHandler.class)
    List<Employee> getAllEmployees();

    @Select("""
            SELECT * FROM employee
            WHERE id = #{id};
            """)
    @Result(column = "id", property = "id", typeHandler = UuidTypeHandler.class)
    Employee getEmployeeById(@Param("id")UUID id);

    @Select("""
            SELECT * FROM employee
            WHERE email = #{email};
            """)
    @Result(column = "id", property = "id", typeHandler = UuidTypeHandler.class)
    Employee getEmployeeByEmail(@Param("email") String email);

    @Insert("""
            INSERT INTO employee (id, name, surname, email, company, admin)
            VALUES (#{employee.id}, #{employee.name}, #{employee.surname}, #{employee.email}, #{employee.company}, #{employee.admin});
            """)
    void createEmployee(@Param("employee") Employee employee);

    @Delete("""
            DELETE FROM employee
            WHERE id = #{id};
            """)
    void deleteEmployeeById(@Param("id") UUID id);
}

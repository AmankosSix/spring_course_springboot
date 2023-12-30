package com.amankos.sprig.springboot.spring_course_springboot.dao;

import com.amankos.sprig.springboot.spring_course_springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

package com.amankos.sprig.springboot.spring_course_springboot.dao;

import com.amankos.sprig.springboot.spring_course_springboot.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getEmployees() {
        Query query = entityManager.createQuery("from Employee");
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Employee newEmp = entityManager.merge(employee);
        employee.setId(newEmp.getId());
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}

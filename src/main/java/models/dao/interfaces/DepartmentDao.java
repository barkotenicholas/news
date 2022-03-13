package models.dao.interfaces;

import models.pojos.Department;

import java.util.List;

public interface DepartmentDao {

    void add(Department department);

    Department findById(int id);

    List<Department> findAll();

    void Update (String name ,String desc ,int employeecount ,int id);

    void delete(int id);

    void clearALl();
}

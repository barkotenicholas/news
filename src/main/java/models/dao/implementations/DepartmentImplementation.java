package models.dao.implementations;

import models.dao.interfaces.DepartmentDao;
import models.pojos.Department;
import org.sql2o.Sql2o;

import java.util.List;

public class DepartmentImplementation  implements DepartmentDao {

    private final Sql2o sql2o;

    public DepartmentImplementation(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(Department department) {

    }

    @Override
    public Department findById(int id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }

    @Override
    public void Update(String name, String desc, int employeecount, int id) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void clearALl() {

    }
}

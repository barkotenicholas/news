package models.dao.implementations;

import models.dao.interfaces.DepartmentDao;
import models.pojos.Department;
import models.pojos.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class DepartmentImplementation  implements DepartmentDao {

    private final Sql2o sql2o;

    public DepartmentImplementation(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(Department department) {

        String sql = " INSERT INTO department (name ,description,employeesCount) values (:name ,:description,:employeesCount)";

        try(Connection conn = sql2o.open()){
            int id = (int) conn.createQuery(sql,true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        }catch (Sql2oException e) {
            e.printStackTrace();
        }
   }

    @Override
    public Department findById(int id) {
        String sql = "SELECT * FROM department WHERE id = :id ;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Department.class);
        }
    }

    @Override
    public List<Department> findAll() {
        try (Connection conn = sql2o.open()){
            String sql = "SELECT * FROM department;";
            return conn.createQuery(sql).executeAndFetch(Department.class);
        }
    }

    @Override
    public void Update(String name, String desc, int employeecount, int id) {

        String sql = "UPDATE department SET (name,description, employeescount) = (:name, :desc, :employeescount) WHERE id = :id ;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("desc", desc)
                    .addParameter("employeescount", employeecount)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM department WHERE id = :id;";
        try (Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    @Override
    public void clearALl() {
        String sql = "DELETE FROM department;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        }
    }
}

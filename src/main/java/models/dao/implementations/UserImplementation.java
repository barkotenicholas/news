package models.dao.implementations;

import models.dao.interfaces.UserDao;
import models.pojos.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.sql.SQLException;
import java.util.List;

public class UserImplementation implements UserDao {
    private final Sql2o sql2o;

    public UserImplementation(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(User user) {

        String sql = "INSERT INTO users (firstname,lastname,role,departmentid) values (:firstname,:lastname,:role,:departmentid);";
        try(Connection conn = sql2o.open()){
           int id = (int) conn.createQuery(sql,true)
                   .bind(user)
                   .executeUpdate()
                   .getKey();
           user.setId(id);
        }catch (Sql2oException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(int id) {
        String sql = "SELECT * FROM users WHERE id = :id ;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(User.class);
        }
    }

    @Override
    public List<User> getAll() {
        try (Connection conn = sql2o.open()){
            String sql = "SELECT * FROM users;";
            return conn.createQuery(sql).executeAndFetch(User.class);
        }
    }

    @Override
    public void update(String fname, String lname, String role, int depatmentId,int id) {

        String sql = "UPDATE users SET (firstname,lastname, role, departmentid) = (:fname, :lname, :role, :departmentId) WHERE id = :id ;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("fname", fname)
                    .addParameter("lname", lname)
                    .addParameter("role", role)
                    .addParameter("departmentId", depatmentId)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    @Override
    public void delete(int id) {

        String sql = "DELETE FROM users WHERE id = :id;";
        try (Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE FROM users;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        }
    }
}

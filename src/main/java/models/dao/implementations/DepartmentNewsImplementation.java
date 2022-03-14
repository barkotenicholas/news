package models.dao.implementations;

import models.dao.interfaces.DepartmentNewsDao;
import models.pojos.DepartmentNews;
import models.pojos.GeneralNews;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.sql.SQLException;
import java.util.List;

public class DepartmentNewsImplementation  implements DepartmentNewsDao {

    private final Sql2o sql2o;

    public DepartmentNewsImplementation(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(DepartmentNews departmentNews) {
        String sql = "INSERT INTO news (content, author, type,departmentid) VALUES (:content, :author, :type,:departmentid);";
        try (Connection conn = sql2o.open()) {
            int id = (int) conn.createQuery(sql, true)
                    .bind(departmentNews)
                    .addParameter("type", DepartmentNews.getType())
                    .addParameter("departmentid", departmentNews.getDepartmentId())
                    .executeUpdate()
                    .getKey();
            departmentNews.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public DepartmentNews findById(int id) {
        String sql = "SELECT * FROM news WHERE id = :id;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(DepartmentNews.class);
        }
    }

    @Override
    public List<DepartmentNews> findAll() {
        try (Connection conn = sql2o.open()){
            String sql = "SELECT * FROM news WHERE type = :type;";
            return conn.createQuery(sql)
                    .addParameter("type", DepartmentNews.getType())
                    .executeAndFetch(DepartmentNews.class);
        }
    }

    @Override
    public void update(String content, String author, int depid, int id) {
        String sql = "UPDATE news SET (content, author) = (:content, :author) WHERE id = :id; ";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("content", content)
                    .addParameter("author", author)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM news WHERE id = :id ;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE FROM news;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        }
    }
}

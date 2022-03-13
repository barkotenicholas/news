package models.dao.interfaces;

import models.pojos.News;
import models.pojos.User;

import java.util.List;

public interface UserDao {

    void add(News news);

    User findById(int id);

    List<User> getAll();

    void update(String fname , String lname , String role ,int depatmentId);

    void delete(int id);

}

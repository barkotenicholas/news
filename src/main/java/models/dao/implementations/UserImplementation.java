package models.dao.implementations;

import models.dao.interfaces.UserDao;
import models.pojos.News;
import models.pojos.User;

import java.util.List;

public class UserImplementation implements UserDao {

    @Override
    public void add(News news) {

    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void update(String fname, String lname, String role, int depatmentId) {

    }

    @Override
    public void delete(int id) {

    }
}

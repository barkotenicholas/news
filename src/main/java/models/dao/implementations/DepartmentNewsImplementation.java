package models.dao.implementations;

import models.dao.interfaces.DepartmentNewsDao;
import models.pojos.DepartmentNews;

import java.util.List;

public class DepartmentNewsImplementation  implements DepartmentNewsDao {
    @Override
    public void add(DepartmentNews departmentNews) {

    }

    @Override
    public DepartmentNews findById(int id) {
        return null;
    }

    @Override
    public List<DepartmentNews> findAll() {
        return null;
    }

    @Override
    public void update(String content, String author, int depid, int id) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}

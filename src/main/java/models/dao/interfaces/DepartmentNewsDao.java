package models.dao.interfaces;

import models.pojos.DepartmentNews;
import models.pojos.GeneralNews;

import java.util.List;

public interface DepartmentNewsDao {

    void add(DepartmentNews departmentNews);

    DepartmentNews findById(int id);

    List<DepartmentNews> findAll();

    void update(String content, String author  ,int depid,int id);

    //delete
    void deleteById(int id);
    void clearAll();
}

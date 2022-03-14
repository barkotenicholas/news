package models.dao.interfaces;

import models.pojos.GeneralNews;

import java.util.List;

public interface GeneralNewsDao {

    void add(GeneralNews generalNews);

    GeneralNews findById(int id);

    List<GeneralNews> findAll();

    void update(String content, String author  ,int id);

    //delete
    void deleteById(int id);
    void clearAll();
}

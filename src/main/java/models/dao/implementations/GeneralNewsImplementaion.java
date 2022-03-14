package models.dao.implementations;

import models.dao.interfaces.GeneralNewsDao;
import models.pojos.GeneralNews;

import java.util.List;

public class GeneralNewsImplementaion implements GeneralNewsDao {
    @Override
    public void add(GeneralNews generalNews) {

    }

    @Override
    public GeneralNews findById(int id) {
        return null;
    }

    @Override
    public List<GeneralNews> findAll() {
        return null;
    }

    @Override
    public void update(String content, String author, int id) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}

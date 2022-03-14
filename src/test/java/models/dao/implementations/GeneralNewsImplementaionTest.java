package models.dao.implementations;

import models.pojos.GeneralNews;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class GeneralNewsImplementaionTest {
    private static GeneralNewsImplementaion gen;
    private static Connection connection;

    @BeforeAll
    static void setUp(){

        String connectionString = "jdbc:postgresql://localhost:5432/newsportaltest";
        Sql2o sql2o = new Sql2o(connectionString,"moringa","access");
        gen = new GeneralNewsImplementaion(sql2o);
        connection = sql2o.open();

    }
    @AfterEach
    void tearDown(){
        gen.clearAll();
    }
    @AfterAll
    static void shutdown(){

        connection.close();

    }

    @Test
    void add() {

        GeneralNews generalNews = setUpNews();
        int id = generalNews.getId();
        gen.add(generalNews);
        assertNotEquals(id , generalNews.getId());

    }


    @Test
    void findById() {
        GeneralNews generalNews = setUpNews();
        GeneralNews test = new GeneralNews("one by one","Eton");

        gen.add(generalNews);
        gen.add(test);

        System.out.println("this is "+test.getId());
        GeneralNews found = gen.findById(test.getId());
        assertEquals(found,test);

    }

    @Test
    void findAll() {
        GeneralNews generalNews = setUpNews();
        GeneralNews test = new GeneralNews("one by one","Eton");

        gen.add(generalNews);
        gen.add(test);

        assertEquals(2 , gen.findAll().size());

    }

    @Test
    void update() {

        GeneralNews generalNews = setUpNews();
        gen.add(generalNews);
        gen.update("This is new","mine",generalNews.getId());
        GeneralNews update = gen.findById(generalNews.getId());
        assertNotEquals(update.getContent(),generalNews.getContent());

    }

    @Test
    void deleteById() {
        GeneralNews generalNews = setUpNews();
        gen.add(generalNews);
        gen.deleteById(generalNews.getId());
        assertEquals(0,gen.findAll().size());
    }

    @Test
    void clearAll() {
        GeneralNews generalNews = setUpNews();
        GeneralNews test = new GeneralNews("one by one","Eton");

        gen.add(generalNews);
        gen.add(test);
        gen.clearAll();
        assertEquals(0,gen.findAll().size());
    }

    private GeneralNews setUpNews() {
        return new GeneralNews("this is this","glen");
    }

}
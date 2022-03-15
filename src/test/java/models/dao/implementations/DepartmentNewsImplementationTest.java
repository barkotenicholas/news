package models.dao.implementations;

import models.dao.interfaces.DepartmentNewsDao;
import models.pojos.DepartmentNews;
import models.pojos.GeneralNews;
import org.junit.jupiter.api.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;
@Disabled
class DepartmentNewsImplementationTest {

    private static DepartmentNewsImplementation dep;
    private static Connection connection;

    @BeforeAll
    static void setUp(){

        String connectionString = "jdbc:postgresql://localhost:5432/newsportaltest";
        Sql2o sql2o = new Sql2o(connectionString,"moringa","access");
        dep = new DepartmentNewsImplementation(sql2o);
        connection = sql2o.open();

    }
    @AfterEach
    void tearDown(){
        dep.clearAll();
    }
    @AfterAll
    static void shutdown(){

        connection.close();

    }


    @Test
    void add() {
        DepartmentNews departmentNews = setUpDepartment();
        int id = departmentNews.getId();
        dep.add(departmentNews);
        System.out.println(id);
        System.out.println(departmentNews.getId());
        assertNotEquals(id,departmentNews.getDepartmentId());
    }


    @Test
    void findById() {
        DepartmentNews departmentNews = setUpDepartment();
        dep.add(departmentNews);
        DepartmentNews found = dep.findById(departmentNews.getId());
        System.out.println(found.getAuthor());
        assertEquals(found,departmentNews);

    }

    @Test
    void findAll() {
        DepartmentNews departmentNews = setUpDepartment();
        DepartmentNews test = new DepartmentNews("That is that","Ellen",2);

        dep.add(departmentNews);
        dep.add(test);

        System.out.println( dep.findAll().size());
        assertEquals(2, dep.findAll().size());
    }

    @Test
    void update() {
        DepartmentNews departmentNews = setUpDepartment();
        dep.add(departmentNews);
        dep.update("This is new","mine",23,departmentNews.getId());
        DepartmentNews found = dep.findById(departmentNews.getId());
        System.out.println(found.getContent() + departmentNews.getContent());
        assertNotEquals(found.getContent(),departmentNews.getContent());
    }

    @Test
    void deleteById() {
        DepartmentNews departmentNews = setUpDepartment();
        DepartmentNews test = new DepartmentNews("That is that","Ellen",2);

        dep.add(departmentNews);
        dep.add(test);

        dep.deleteById(test.getId());
        assertEquals(1,dep.findAll().size());
    }

    @Test
    void clearAll() {
    }


    private DepartmentNews setUpDepartment() {
        return new DepartmentNews("This is this","Nick",2);
    }
}
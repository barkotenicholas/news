package models.dao.implementations;

import models.pojos.Department;
import org.junit.jupiter.api.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("Department implementation test")
class DepartmentImplementationTest {
    private static DepartmentImplementation dep;
    private static Connection connection;

    @BeforeAll
    static void setUp(){

        String connectionString = "jdbc:postgresql://localhost:5432/newsportaltest";
        Sql2o sql2o = new Sql2o(connectionString,"moringa","access");
        dep = new DepartmentImplementation(sql2o);
        connection = sql2o.open();

    }
    @AfterEach
    void tearDown(){
        dep.clearALl();
    }
    @AfterAll
    static void shutdown(){

        connection.close();

    }

    @DisplayName("Add adds user id to database")
    @Test
    void add() {

        var test = setUpDep();
        int id = test.getId();
        dep.add(test);
        assertNotEquals(id,test.getId());

    }

    @DisplayName("Find by Id returns department")
    @Test
    void findById() {
        var test = setUpDep();
        var test1 = setUpDep();

        dep.add(test);
        dep.add(test1);

        var found = dep.findById(test1.getId());

        assertEquals(found ,test1);
    }

    @DisplayName("Returns All users")
    @Test
    void findAll() {
        var test = setUpDep();
        var test1 = setUpDep();

        dep.add(test);
        dep.add(test1);
        assertEquals(2 ,dep.findAll().size());
    }

    @DisplayName("Updated record in db")
    @Test
    void update() {

        var test = setUpDep();
        dep.add(test);
        dep.Update("InfoTech","makes systems",40, test.getId());

        Department updated = dep.findById(test.getId());

        assertNotEquals(test,updated);

    }

    @DisplayName("Delete removes record from table")
    @Test
    void delete() {
        var test = setUpDep();
        var test1 = setUpDep();

        dep.add(test);
        dep.add(test1);

        dep.delete(test1.getId());

        assertEquals(1 , dep.findAll().size());
    }

    @DisplayName("clears all record in the database")
    @Test
    void clearALl() {
        var test = setUpDep();
        var test1 = setUpDep();

        dep.add(test);
        dep.add(test1);

        dep.clearALl();

        assertEquals(0 , dep.findAll().size());
    }

    private Department setUpDep() {
        return new Department("I.T","manages comps",50);
    }

}
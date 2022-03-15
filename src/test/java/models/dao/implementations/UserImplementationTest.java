package models.dao.implementations;

import models.pojos.User;
import org.junit.jupiter.api.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
@Disabled
@DisplayName("User implementation Test")
class UserImplementationTest {

    private static UserImplementation user;
    private static Connection connection;

    @BeforeAll
    static void setUp(){

        String connectionString = "jdbc:postgresql://localhost:5432/newsportaltest";
        Sql2o sql2o = new Sql2o(connectionString,"moringa","access");
        user = new UserImplementation(sql2o);
        connection = sql2o.open();

    }
    @AfterEach
    void tearDown(){
        user.clearAll();
    }
    @AfterAll
    static void shutdown(){

        connection.close();

    }

    @DisplayName("Adding user sets id")
    @Test
    void setId_addingUserSetsId_Integer(){

        User testUser = setUpUser();
        int id = testUser.getId();
        user.add(testUser);
        assertNotEquals(id,testUser.getId());
    }

    @DisplayName("User can find an individual user by id")
    @Test
    void find_userCanBeFoundById_User(){

        User testUser = setUpUser();
        User testUserTwo = new User("Francis","Njambi","dev",33);

        user.add(testUser);
        user.add(testUserTwo);

        User find = user.findById(testUserTwo.getId());
        assertEquals(find,testUserTwo);
    }

    @DisplayName("get all returns all users in database")
    @Test
    void findAll_userCanBeFoundById_ListUser(){

        User testUser = setUpUser();
        User testUserTwo = new User("Francis","Njambi","dev",33);

        user.add(testUser);
        user.add(testUserTwo);

        assertEquals(2,user.getAll().size());
    }
    @DisplayName("Empty db returns zero")
    @Test
    void noUsers_returnsAllUsersAs0_Int(){
        assertEquals(0,user.getAll().size());
    }

    @DisplayName("update changes content of the database")
    @Test
    void update_UpdatesUsersInfo_User(){
        User testUser = setUpUser();
        user.add(testUser);

        user.update("Steven","segal","actor",33 ,testUser.getId());

        User updated = user.findById(testUser.getId());

        assertNotEquals(updated,testUser);


    }

    @DisplayName("Delete deletes user by id")
    @Test
    void delete_removesRecordFrom(){
        User testUser = setUpUser();
        User testUserTwo = new User("Francis","Njambi","dev",33);

        user.add(testUser);
        user.add(testUserTwo);

        user.delete(testUserTwo.getId());


        assertEquals(1,user.getAll().size());
    }
    private User setUpUser() {
        return new User("Nicholas","Barkote","dev",2);
    }


}
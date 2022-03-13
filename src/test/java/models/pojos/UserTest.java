package models.pojos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("User class test")
class UserTest {


    @DisplayName("Check if User class instantiates correctly")
    @Test
    void user_instantiatesCorrectly_true(){
        User testUser = new User("Nicholas","Barkote","softwareDev",23);

        assertTrue(testUser instanceof User);

    }


    @DisplayName("Check if user returns firstname")
    @Test
    void getName_returnsFirstName_String(){
        User testUser = new User("Nicholas","Barkote","softwareDev",23);

        assertEquals("Nicholas",testUser.getFirstname());
    }

    @DisplayName("Check if user returns lastname")
    @Test
    void getName_returnsLastName_String(){
        User testUser = new User("Nicholas","Barkote","softwareDev",23);

        assertEquals("Barkote",testUser.getLastname());
    }

    @DisplayName("Check if user returns role assigned")
    @Test
    void getRole_returnsRoleAssigned_String(){
        User testUser = new User("Nicholas","Barkote","softwareDev",23);

        assertEquals("softwareDev",testUser.getRole());
    }
    @DisplayName("Check if user Department id  assigned")
    @Test
    void getDepartment_returnsDepartment_Integer(){
        User testUser = new User("Nicholas","Barkote","softwareDev",23);

        assertEquals(23,testUser.getDepartmentID());
    }

    @DisplayName("Equals check if two instancesof user are same")
    @Test
    void equals_checkIfTwoInstancesOfUserAreEqual_true(){

        User testUserOne = new User("Nicholas","Barkote","softwareDev",23);
        User testUserTwo = new User("Nicholas","Barkote","softwareDev",23);

        assertEquals(testUserOne, testUserTwo);

    }
}
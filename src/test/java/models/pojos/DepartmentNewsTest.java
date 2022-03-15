package models.pojos;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@Disabled
@DisplayName("Department news")
class DepartmentNewsTest {


    @DisplayName("check if department initializes correctly")
    @Test
    void departmentNews_instantiatesCorrectly(){
        DepartmentNews test = new DepartmentNews("this is this","Nickson",12);
        assertTrue(test instanceof DepartmentNews);
    }

    @DisplayName("Department id is returned ")
    @Test
    void getDepartmentId() {
        DepartmentNews test = new DepartmentNews("this is this","Nickson",12);
        assertEquals(12,test.getDepartmentId());
    }

    @DisplayName("Check if two instances of department are equal ")
    @Test
    void testEquals() {
        DepartmentNews testOne = new DepartmentNews("this is this","Nickson",12);
        DepartmentNews testTwo = new DepartmentNews("this is this","Nickson",12);

        assertTrue(testOne.equals(testTwo));
    }
}
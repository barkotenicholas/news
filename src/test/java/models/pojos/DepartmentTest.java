package models.pojos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Department Test")
class DepartmentTest {

   @DisplayName("check if department instantiates correctly")
   @Test
   void department_instantiatesCorrectly_True(){
       Department testDepartment = new Department("Operations","involved in the daily running of the compamny",20);

       assertTrue(testDepartment instanceof Department);
   }

   @DisplayName("check if department returns name")
   @Test
   void getName_departmentReturnsName_String(){

       Department testDepartment = new Department("Operations","involved in the daily running of the compamny",20);
       assertEquals("Operations",testDepartment.getName());

   }
    @DisplayName("check if department returns description")
    @Test
    void getDescription_departmentReturnsName_String(){

        Department testDepartment = new Department("Operations","involved in the daily running of the company",20);
        assertEquals("involved in the daily running of the company",testDepartment.getDesc());

    }

    @DisplayName("check if department returns description")
    @Test
    void getNoOfEmployees_departmentReturnsName_Int(){

        Department testDepartment = new Department("Operations","involved in the daily running of the company",20);
        assertEquals(20,testDepartment.getEmployeesCount());

    }

    @DisplayName("check if two instances of department are equal")
    @Test
    void equals_checkIfTwoInstancesOfDepartmentAreEqual_True(){
        Department testDepartmentOne = new Department("Operations","involved in the daily running of the company",20);
        Department testDepartmentTwo = new Department("Operations","involved in the daily running of the company",20);

        assertEquals(testDepartmentOne, testDepartmentTwo);
    }

}
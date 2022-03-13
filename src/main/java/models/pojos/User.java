package models.pojos;

import java.util.Objects;

public class User {

    private int id;
    private String firstname;
    private String lastname;
    private String role;
    private int departmentID;

    public User(String firstname, String lastname, String role, int departmentID) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.departmentID = departmentID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && departmentID == user.departmentID && Objects.equals(firstname, user.firstname) && Objects.equals(lastname, user.lastname) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, role, departmentID);
    }
}

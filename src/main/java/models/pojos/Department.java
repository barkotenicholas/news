package models.pojos;

import java.util.Objects;

public class Department {

    private int id;
    private String name;
    private String desc;
    private int employeesCount;

    public Department(String name, String desc, int employeesCount) {
        this.name = name;
        this.desc = desc;
        this.employeesCount = employeesCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(int employeesCount) {
        this.employeesCount = employeesCount;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id && employeesCount == that.employeesCount && Objects.equals(name, that.name) && Objects.equals(desc, that.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, employeesCount);
    }
}

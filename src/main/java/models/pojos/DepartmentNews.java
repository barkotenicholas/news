package models.pojos;

import java.util.Objects;

public class DepartmentNews  extends News{

    public static final String DATABASE ="Department";
    private int departmentId;
    private  String type;
    public DepartmentNews(String content, String author ,int departmentId) {
        super(content, author);
        this.departmentId = departmentId;
        this.type = DATABASE;
    }

    public static String getType() {
        return DATABASE;
    }

    public void setDbtype(String dbtype) {
        this.type = dbtype;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DepartmentNews that = (DepartmentNews) o;
        return departmentId == that.departmentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), departmentId);
    }
}

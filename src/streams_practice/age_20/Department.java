package streams_practice.age_20;

import java.util.List;

public class Department {
    String id;
    String name;
    String managerId;
    List<Employee> employees;

    public Department(String id, String name, String managerId, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
        this.employees = employees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

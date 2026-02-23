package streams_practice.age_20;

public class Employee {
    private String id;
    private String name;
    private int age;
    private boolean isManager;

    public Employee(String id, String name, int age, boolean isManager) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isManager = isManager;
    }

    // Copy constructor (deep copy for current fields)
    public Employee(Employee employee) {
        this.id = employee.id;
        this.name = employee.name;
        this.age = employee.age;
        this.isManager = employee.isManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isManager=" + isManager +
                '}';
    }
}

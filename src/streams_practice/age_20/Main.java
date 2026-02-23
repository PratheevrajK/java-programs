package streams_practice.age_20;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("e1", "Pratheev", 18, false);
        Employee e2 = new Employee("e2", "Rajendra", 28, true);
        Employee e3 = new Employee("e3", "Akarsh", 20, false);
        Employee e4 = new Employee("e4", "Ranjitha", 19, true);
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);

        //get employee names in list whose age is less than 20.
        List<String> names = employees.stream().filter(a -> a.getAge()<20).map(Employee::getName).collect(Collectors.toList());
        System.out.println(names);//[Pratheev, Ranjitha]

        // count of managers in employees list.
        int count = countManager(employees);
        System.out.println(count);//2

        List<Employee> employees2 = new ArrayList<>();
        Employee e5 = new Employee("e5", "Sharan", 21, true);
        Employee e6 = new Employee("e6", "Deepak", 19, false);
        employees2.add(e5);
        employees2.add(e6);

        List<Employee> employees3 = new ArrayList<>();
        Employee e7 = new Employee("e5", "Tilag", 21, false);
        Employee e8 = new Employee("e6", "Kalyan", 19, true);
        employees3.add(e7);
        employees3.add(e8);

        Department dept1 = new Department("d1", "Loans", "e4", employees);
        Department dept2 = new Department("d2", "Tax and Compliance", "e5", employees2);
        Department dept3 = new Department("d3", "Tax", "e1", employees3);

        List<Department> depts = new ArrayList<>();
        depts.add(dept1);
        depts.add(dept2);
        depts.add(dept3);

        // dept name should start with 'Tax' and employee age should be less than 20 and employee name length should be less than 7.
        List<String> empNames = getYoungTaxEmployeeNames(depts);
        System.out.println(empNames);//[Deepak, Kalyan]
    }

    public static Integer countManager(List<Employee> employees) {
        return (int) employees.stream().filter(Employee::isManager).count();
    }
    public static List<String> getYoungTaxEmployeeNames(List<Department> depts) {
        List<String> names = new ArrayList<>();
        for (Department dept : depts) {
            if (dept.getName().toLowerCase().startsWith("tax")) {
                names.addAll(dept.getEmployees().stream().filter(e -> e.getAge()<20 && e.getName().length()<7).map(Employee::getName).toList());
            }
        }

//        List<String> names =
//                depts.stream()
//                        // keep only departments whose name starts with "tax" (case-insensitive)
//                        .filter(dept -> dept.getName() != null &&
//                                dept.getName().toLowerCase().startsWith("tax"))
//                        // flatten employees from each matching department into one stream<Employee>
//                        .flatMap(dept -> dept.getEmployees().stream())
//                        // keep only employees with your conditions
//                        .filter(e -> e.getAge() < 20 && e.getName() != null && e.getName().length() < 7)
//                        // map to names
//                        .map(Employee::getName)
//                        // materialize as a List (use Collectors for wider JDK compatibility)
//                        .collect(Collectors.toList());

        return names;
    }
}


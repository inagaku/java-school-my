package homework.java8.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService {
    public static int totalSalary(List<Employee> employeeList) {
        return employeeList.stream().mapToInt(Employee::getSalary).sum();
    }

    public static int totalSalaryReduce(List<Employee> employeeList) {
        return employeeList.stream().map(Employee::getSalary).reduce(Integer::sum).get();
    }

    public static List<String> orderBySalary(List<Employee> employeeList) {
        return employeeList.stream()
                .sorted((t1, t2) -> t2.getSalary() - t1.getSalary())
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    public static Map<String, Employee> listToMapBySalary(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.toMap(Employee::getName, t -> t, (t1, t2) -> new Employee(t1.getName(), Math.max(t1.getSalary(), t2.getSalary()))));
    }

    public static void main(String[] args) {
//        System.out.println(totalSalary(List.of(new Employee("Jhon", 1000), new Employee("Jarvis", 2000), new Employee("Jack", 3500))));
//        System.out.println(totalSalaryReduce(List.of(new Employee("Jhon", 1000), new Employee("Jarvis", 2000), new Employee("Jack", 3500))));


        orderBySalary(List.of(new Employee("Jhon", 1000), new Employee("Jarvis", 2000), new Employee("Jack", 3500))).stream()
                .forEach(System.out::println);

        listToMapBySalary(List.of(new Employee("Jack", 1000), new Employee("Jarvis", 2000), new Employee("Jack", 3500)))
                .forEach((key, value) -> System.out.println(key + "-" + value));
    }
}

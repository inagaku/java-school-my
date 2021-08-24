package homework.java8.streams;

import java.util.List;

public class EmployeeService {
    public static int totalSalary(List<Employee> employeeList) {
        return employeeList.stream().mapToInt(Employee::getSalary).sum();
    }

    public static int totalSalaryReduce(List<Employee> employeeList) {
        return employeeList.stream().map(Employee::getSalary).reduce(Integer::sum).get();
    }

    public static void main(String[] args) {
        System.out.println(totalSalary(List.of(new Employee("Jhon", 1000), new Employee("Jarvis", 2000), new Employee("Jack", 3500))));
        System.out.println(totalSalaryReduce(List.of(new Employee("Jhon", 1000), new Employee("Jarvis", 2000), new Employee("Jack", 3500))));
    }
}

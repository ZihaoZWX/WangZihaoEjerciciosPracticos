package ejercicio1jas2d1;

import ejercicio1jas2d1.models.Employee;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Zihao Wang
 */
public class Main {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Santiago", 1000, "front"));
        employees.add(new Employee("Josefina", 2000, "backend"));
        employees.add(new Employee("Luis", 1000, "front"));
        employees.add(new Employee("Alfredo", 3000, "manager"));
        employees.add(new Employee("Jesus", 2000, "backend"));
        
        Stream<Employee> employeeList = employees.stream();
        employeeList.filter(employee -> employee.getSalary() > 1000).forEach(employee->System.out.println(employee.toString()));
        Map<String, List<Employee>> employeeCategory = employees.stream().collect(Collectors.groupingBy(Employee::getCategory));
        employeeCategory.forEach((category, employeeByCategory) -> {
            double averageSalary=employeeByCategory.stream().mapToDouble(Employee::getSalary).average().orElse(0);
            System.out.println("Category " + category);
            System.out.println("The average salary is "+averageSalary);
        });
        
        Optional<Double> maxSalary=employees.stream().map(Employee::getSalary).max(Double::compare);
        maxSalary.ifPresent(salario->System.out.println("The highest salary is "+maxSalary.get()));
    }

}

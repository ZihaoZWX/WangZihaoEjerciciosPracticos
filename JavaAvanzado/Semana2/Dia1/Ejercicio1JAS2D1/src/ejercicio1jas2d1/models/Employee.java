
package ejercicio1jas2d1.models;

/**
 *
 * @author Zihao Wang
 */
public class Employee {
    
    private String name;
    private double salary;
    private String category;

    public Employee() {
    }

    public Employee(String name, double salary, String category) {
        this.name = name;
        this.salary = salary;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", salary=" + salary + ", category=" + category + '}';
    }
    
}

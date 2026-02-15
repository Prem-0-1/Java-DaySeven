import java.util.ArrayList;
import java.util.List;

class Employee {
    private String employeeId;
    private String name;
    private String role;
    private double baseSalary;
    private double finalSalary;

    public Employee(String employeeId, String name, String role, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.baseSalary = baseSalary;
        this.finalSalary = 0;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void calculateSalary() {
        switch (role) {
            case "Manager":
                finalSalary = baseSalary + (baseSalary * 0.20);
                break;
            case "Developer":
                finalSalary = baseSalary + (baseSalary * 0.10);
                break;
            case "Designer":
                finalSalary = baseSalary + (baseSalary * 0.05);
                break;
            case "Intern":
                finalSalary = 1000;
                break;
            default:
                finalSalary = baseSalary;
                break;
        }
    }

    public void applyDeduction(double amount) {
        if (amount > 0) {
            finalSalary -= amount;
        }
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);
        System.out.println("Final Salary: " + finalSalary);
        System.out.println("----------------------------");
    }
}

class Payroll {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    public void calculateAllSalaries() {
        for (Employee employee : employees) {
            employee.calculateSalary();
            employee.displayEmployeeDetails();
        }
    }

    public Employee findEmployeeById(String employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                return employee;
            }
        }
        return null;
    }
}

public class EmployeePayrollManagementSystem {
    public static void main(String[] args) {

        Payroll payroll = new Payroll();

        Employee e1 = new Employee("E101", "Rahul", "Manager", 5000);
        Employee e2 = new Employee("E102", "Sneha", "Developer", 4000);
        Employee e3 = new Employee("E103", "Amit", "Intern", 2000);

        payroll.addEmployee(e1);
        payroll.addEmployee(e2);
        payroll.addEmployee(e3);

        System.out.println("\nCalculated Salaries:");
        payroll.calculateAllSalaries();

        System.out.println("\nApplying deduction of 200 to Developer:");
        Employee found = payroll.findEmployeeById("E102");
        if (found != null) {
            found.applyDeduction(200);
            found.displayEmployeeDetails();
        }
    }
}

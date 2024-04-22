
import java.util.ArrayList;
import java.util.Scanner;

class employee {
    private final int id;
    private final String name;
    private final int age;
    private final String department;
    private final String code;
    private final double salaryRate;

    public employee(int id, String name, int age, String department, String code, double salaryRate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.code = code;
        this.salaryRate = salaryRate;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Department: " + department + ", Code: " + code
                + ", Salary Rate: " + salaryRate;
    }

    public int getId() {
        return 0;
    }
}

public class EmployeeManagement {
    private static final ArrayList<employee> employees = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        initializeEmployees();
        displayEmployees();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a new employee");
            System.out.println("2. Remove an employee");
            System.out.println("3. Exit");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addEmployee(scanner);
                    displayEmployees();
                    break;
                case 2:
                    removeEmployee(scanner);
                    displayEmployees();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private static void initializeEmployees() {
        employees.add(new employee(nextId++, "henryd", 19, "IT", "HD001", 2500.0));
        employees.add(new employee(nextId++, "Jennie Kim", 28, "HR", "JK002", 2800.0));
        // Add more employees as needed
    }

    private static void displayEmployees() {
        System.out.println("\nList of employees:");
        for (employee emp : employees) {
            System.out.println(emp);
        }
    }

    private static void addEmployee(Scanner scanner) {
        System.out.println("Enter employee name:");
        String name = scanner.nextLine();
        System.out.println("Enter employee age:");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter employee department:");
        String department = scanner.nextLine();
        System.out.println("Enter employee code:");
        String code = scanner.nextLine();
        System.out.println("Enter employee salary rate:");
        double salaryRate = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        employees.add(new employee(nextId++, name, age, department, code, salaryRate));
        System.out.println("Employee added successfully.");
    }

    private static void removeEmployee(Scanner scanner) {
        System.out.println("Enter the ID of the employee to remove:");
        int idToRemove = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boolean removed = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == idToRemove) {
                employees.remove(i);
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found with ID: " + idToRemove);
        }
    }
}

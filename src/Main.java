import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import employees.Employee;
import tasks.Task;

public class Main {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();
        loadTasksAndEmployees("../data/tasks_list.csv", "../data/employees_list.csv", tasks, employees);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Scheduling Algorithms Menu:");
            System.out.println("1. Apply Algorithm");
            System.out.println("2. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }

    private static void loadTasksAndEmployees(String taskFilePath, String employeeFilePath, ArrayList<Task> tasks, ArrayList<Employee> employees) {
        // Load task data from input_data.csv
        try (BufferedReader taskReader = new BufferedReader(new FileReader(taskFilePath))) {
            String line;
			taskReader.readLine();
            while ((line = taskReader.readLine()) != null) {
                String[] data = line.split(",");
                Task task = new Task(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3]), data[4], data[5], Integer.parseInt(data[6]));
                tasks.add(task);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Load employee data from employee.csv
        try (BufferedReader employeeReader = new BufferedReader(new FileReader(employeeFilePath))) {
            String line;
			employeeReader.readLine();
            while ((line = employeeReader.readLine()) != null) {
                String[] data = line.split(",");
                Employee employee = new Employee(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3]));
                employees.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
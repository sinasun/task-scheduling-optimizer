import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import employees.Employee;
import scheduling.*;
import scheduling.algorithm.PriorityDueDateSchedulingAlgorithm;
import scheduling.SchedulingAlgorithm;
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
            System.out.println("2. Save to File");
            System.out.println("3. Exit");

            int choice = getInt(scanner, "Enter your choice: ", 1, 3); 

            switch (choice) {
                case 1:
                    SchedulingAlgorithm algorithm = new PriorityDueDateSchedulingAlgorithm(scheduler);
                    algorithm.applyAlgorithm();

                    System.out.println("Algorithm applied. Tasks scheduled.");
                    break;
                case 2:
                    String outputFilePath = getString(scanner, "Enter the output file path: ");
                    scheduler.generateOutputScheduleFile(outputFilePath);
                    System.out.println("Results saved to file: " + outputFilePath);
                    break;
                case 3:
                    exit = true;
                    break;
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
                Task task = new Task(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]));
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
                Employee employee = new Employee(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3]), 0);
                employees.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static int getInt(Scanner input, String prompt, int min, int max) {
		boolean isInputBad = true;
		boolean hasNextInt;
		int value = 0;

		while (isInputBad) {
			System.out.print(prompt);

			hasNextInt = input.hasNextInt();
			if (hasNextInt) {
				value = input.nextInt();
				if (value >= min && value <= max) {

					isInputBad = false; // break out of loop

				} else {
					System.out.println("Please select a number in the range");

				}
			} else {
				System.out.println("Please enter an integer");
			}
			input.nextLine(); // clean up input stream
		}

		return value;

	}

    private static String getString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }
}

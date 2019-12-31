package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		List<Employee> list = new ArrayList<>();
		int id;
		String name;
		double salary;

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("How many employees will be registered? ");
		int employeeNum = sc.nextInt();
		System.out.println();

		for (int i = 1; i <= employeeNum; i++) {
			sc.nextLine();
			System.out.println("Employee #" + i);
			System.out.print("Id: ");
			id = sc.nextInt();
			sc.nextLine();
			System.out.print("Name: ");
			name = sc.nextLine();
			System.out.print("Salary: ");
			salary = sc.nextDouble();
			list.add(new Employee(id, name, salary));
			System.out.println();
		}

		System.out.print("Enter the employee id that will have salary increase: ");
		int idNum = sc.nextInt();
		Employee emp = list.stream().filter(employee -> employee.getId() == idNum).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}
		
		System.out.println();
		System.out.println("List of employees:");
		
		for (Employee obj : list) {
			System.out.println(obj);
		}

		sc.close();
	}

}

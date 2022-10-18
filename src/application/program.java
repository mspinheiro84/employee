package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourceEmployee;

public class program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> employees = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Employee #"+i+" data:");
			System.out.print("Outsourced (y/n)? ");
			char c = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			if (c == 'y') {
				System.out.print("Additional Charge: ");
				double additionalCharge = sc.nextDouble();
				employees.add(new OutsourceEmployee(name, hours, valuePerHour, additionalCharge));
			} else {
				employees.add(new Employee(name, hours, valuePerHour));
			}
		}
		
		System.out.println("");
		System.out.println("PAYMENTS:");
		for(Employee e : employees) {
			System.out.println(e.getName() + " - $" + String.format("%.2f", e.payment()));
		}
		
		sc.close();
	}

}

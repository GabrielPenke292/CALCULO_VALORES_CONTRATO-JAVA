package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String deparmentName = sc.nextLine();
		
		System.out.println("Enter Worker data:");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(deparmentName));
		
		System.out.print("How many contracts to this worker? ");
		int numberOfContracts = sc.nextInt();
		
		for(int i = 1; i<=numberOfContracts; i++) {
			System.out.println("Enter contract #" + i + " data: ");
			System.out.println("Date (dd/MM/yyyy) :");
			Date contractDate = sdf.parse(sc.next());

			System.out.println("Value per hour:");
			double valuePerHour = sc.nextDouble();
			
			System.out.println("Duration (hours):");
			int durationHours = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, durationHours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Enter a month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name " + worker.getName());
		System.out.println("Department " + worker.getDeparment().getName());
		System.out.println("Income for " + monthAndYear + ": " + worker.income(year, month));
		
		
		sc.close();
	}
}

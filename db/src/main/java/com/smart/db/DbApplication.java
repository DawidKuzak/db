package com.smart.db;

import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.smart.db.entity.Department;
import com.smart.db.entity.DeptManager;
import com.smart.db.entity.Employee;
import com.smart.db.entity.Salary;
import com.smart.db.entity.Title;
import com.smart.db.entity.WorksIn;
import com.smart.db.repository.DepartmentRepo;
import com.smart.db.repository.DeptManagerRepo;
import com.smart.db.repository.EmployeeRepo;
import com.smart.db.repository.SalaryRepo;
import com.smart.db.repository.TitleRepo;
import com.smart.db.repository.WorksInRepo;

@SpringBootApplication
public class DbApplication implements CommandLineRunner {

	@Autowired
	private DepartmentRepo depRepo;

	@Autowired
	private EmployeeRepo empRepo;

	@Autowired
	private WorksInRepo worksinRepo;

	@Autowired
	private SalaryRepo salaryRepo;

	@Autowired
	private TitleRepo titleRepo;

	@Autowired
	private DeptManagerRepo depMgrRepo;

	public static void main(String[] args) {
		SpringApplication.run(DbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		boolean run = true;
		Scanner inp = new Scanner(System.in);

		try {
			Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://mysql.wmi.amu.edu.pl/s462090_Projekt_Programowanie", "s462090", "HasloTestowe123");
			System.out.println("Database connected..");
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			int n;

			while (run) {

				System.out.println("1. Import");
				System.out.println("2. Export");
				System.out.println("3. Query");
				System.out.println("4. Exit");

				System.out.print("Enter choice: ");
				n = inp.nextInt();

				inp = new Scanner(System.in);
				switch (n) {
				case 1:
					boolean runImport = true;
					while (runImport) {
						System.out.println("1. Employees");
						System.out.println("2. Departments");
						System.out.println("3. Salaries");
						System.out.println("4. Titles");
						System.out.println("5. WorksIn");
						System.out.println("6. Department Managers");
						System.out.println("0. Exit");
						System.out.print("Enter choice: ");
						n = inp.nextInt();

						if (n == 0)
							break;

						inp = new Scanner(System.in);
						System.out.print("Enter filename: ");
						String filename = inp.next();
						JsonReader reader = new JsonReader(new FileReader(filename));
						switch (n) {
						case 1:

							List<Employee> emps = gson.fromJson(reader, new TypeToken<List<Employee>>() {
							}.getType());

							empRepo.saveAll(emps);
							break;
						case 2:
							List<Department> depts = gson.fromJson(reader, new TypeToken<List<Department>>() {
							}.getType());

							depRepo.saveAll(depts);
							break;
						case 3:
							List<Salary> sals = gson.fromJson(reader, new TypeToken<List<Salary>>() {
							}.getType());

							salaryRepo.saveAll(sals);
							break;
						case 4:
							List<Title> titles = gson.fromJson(reader, new TypeToken<List<Title>>() {
							}.getType());

							titleRepo.saveAll(titles);
							break;
						case 5:
							List<WorksIn> works = gson.fromJson(reader, new TypeToken<List<WorksIn>>() {
							}.getType());

							worksinRepo.saveAll(works);
							break;
						case 6:
							List<DeptManager> deptMgrs = gson.fromJson(reader, new TypeToken<List<DeptManager>>() {
							}.getType());

							depMgrRepo.saveAll(deptMgrs);
							break;
						case 0:
							runImport = false;
							break;
						default:
							System.out.println("Invalid choice!!!");
						}
					}
					break;
				case 2:
					boolean runExport = true;
					while (runExport) {
						System.out.println("What to export?");
						System.out.println("1. Employees");
						System.out.println("2. Departments");
						System.out.println("3. Salaries");
						System.out.println("4. Titles");
						System.out.println("5. WorksIn");
						System.out.println("6. Department Managers");
						System.out.println("0. Exit");
						System.out.print("Enter choice: ");
						n = inp.nextInt();

						if (n == 0)
							break;

						inp = new Scanner(System.in);
						System.out.print("Enter filename: ");
						String filename = inp.next();

						FileWriter writer;
						writer = new FileWriter(filename);
						String json = null;
						switch (n) {
						case 1:
							var data = empRepo.findAll();
							json = gson.toJson(data);
							break;
						case 2:
							var deps = depRepo.findAll();
							json = gson.toJson(deps);
							break;
						case 3:
							var sals = salaryRepo.findAll();
							json = gson.toJson(sals);
							break;
						case 4:
							var titles = titleRepo.findAll();
							json = gson.toJson(titles);
							break;
						case 5:
							var works = worksinRepo.findAll();
							json = gson.toJson(works);
							break;
						case 6:
							var depMgrs = depMgrRepo.findAll();
							json = gson.toJson(depMgrs);
							break;
						case 0:
							runExport = false;
							break;
						default:
							System.out.println("Invalid choice!!!");
						}
						writer.write(json);
						writer.close();
					}
					break;
				case 3:
					try {
						System.out.print("Query: ");
						String query = inp.nextLine();

						Statement stmt = conn.createStatement();
						if (query.toLowerCase().contains("update") || query.toLowerCase().contains("delete")
								|| query.toLowerCase().contains("insert")) {
							stmt.executeUpdate(query);
						} else {
							ResultSet set = stmt.executeQuery(query);
							ResultSetMetaData meta = set.getMetaData();
							int columnCount = meta.getColumnCount();
							for (int i = 1; i <= columnCount; i++) {
								System.out.print(meta.getColumnName(i) + ", ");
							}
							System.out.println();
							while (set.next()) {
								String row = "";
								for (int i = 1; i <= columnCount; i++) {
									row += set.getObject(i) + ", ";
								}
								System.out.println(row);

							}
						}
						System.out.println("Query executed..");
					} catch (Exception ex) {
						System.out.println("SQL ERROR: " + ex.getMessage());
					}
					break;
				case 4:
					run = false;
					break;

				default:
					System.out.println("Invalid choice!!!");
					break;
				}
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("ERROR: " + e.toString());
		}
		inp.close();
	}
}
package com.studentmanagementconsole;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.studentmanagementconsole.dao.StudentDao;
import com.studentmanagementconsole.entities.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/studentmanagementconsole/config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;

		while (go) {
			System.out.println("\n===============================");
			System.out.println("   Student Management System  ");
			System.out.println("===============================");
			System.out.println("PRESS 1 for Add New Student");
			System.out.println("PRESS 2 for Display All Students");
			System.out.println("PRESS 3 for Get Details of Single Student");
			System.out.println("PRESS 4 for Update Student");
			System.out.println("PRESS 5 for Delete Student");
			System.out.println("PRESS 0 for Exit");
			System.out.println("*******************************");

			try {
				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1:
					addNewStudent(br, studentDao);
					break;
				case 2:
					displayAllStudents(studentDao);
					break;
				case 3:
					getSingleStudentDetails(br, studentDao);
					break;
				case 4:
					updateStudent(br, studentDao);
					break;
				case 5:
					deleteStudent(br, studentDao);
					break;
				case 0:
					go = false;
					System.out.println("Exiting the system. Goodbye!");
					break;
				default:
					System.out.println("Invalid input. Please try again.");
				}
			} catch (Exception e) {
				System.out.println("Invalid input. Please try again.");
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	// Method to add a new student to the system
	private static void addNewStudent(BufferedReader br, StudentDao studentDao) throws Exception {
		System.out.print("\nEnter Student ID: ");
		int id = Integer.parseInt(br.readLine());
		System.out.print("Enter Student Name: ");
		String name = br.readLine();
		System.out.print("Enter Student City: ");
		String city = br.readLine();

		Student student = new Student(id, name, city);
		studentDao.insert(student);
		System.out.println("Successfully inserted student with ID: " + id);
	}

	// Method to display all students in the system
	private static void displayAllStudents(StudentDao studentDao) {
		System.out.println("\nDisplaying All Students:");
		for (Student student : studentDao.getStudents()) {
			System.out.printf("ID: %d, Name: %s, City: %s%n", student.getStudentId(), student.getStudentName(),
					student.getStudentCity());
		}
	}

	// Method to get details of a single student by their ID
	private static void getSingleStudentDetails(BufferedReader br, StudentDao studentDao) throws Exception {
		System.out.print("\nEnter Student ID to Get Details: ");
		int studentId = Integer.parseInt(br.readLine());
		Student student = studentDao.getStudent(studentId);
		if (student != null) {
			System.out.printf("ID: %d, Name: %s, City: %s%n", student.getStudentId(), student.getStudentName(),
					student.getStudentCity());
		} else {
			System.out.println("Student not found.");
		}
	}

	// Method to update an existing student's details
	private static void updateStudent(BufferedReader br, StudentDao studentDao) throws Exception {
		System.out.print("\nEnter Student ID to Update: ");
		int studentId = Integer.parseInt(br.readLine());
		Student studentToUpdate = studentDao.getStudent(studentId);

		if (studentToUpdate != null) {
			System.out.print("Enter New Name: ");
			String newName = br.readLine();
			System.out.print("Enter New City: ");
			String newCity = br.readLine();

			studentToUpdate.setStudentName(newName);
			studentToUpdate.setStudentCity(newCity);
			studentDao.updateStudent(studentToUpdate);
			System.out.println("Successfully updated student.");
		} else {
			System.out.println("Student not found.");
		}
	}

	// Method to delete a student by their ID
	private static void deleteStudent(BufferedReader br, StudentDao studentDao) throws Exception {
		System.out.print("\nEnter Student ID to Delete: ");
		int studentId = Integer.parseInt(br.readLine());
		studentDao.deleteStudent(studentId);
		System.out.println("Successfully deleted student.");
	}
}

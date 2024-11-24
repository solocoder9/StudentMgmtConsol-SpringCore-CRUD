# 🎓 Student Management Console

Student Management Console is a Java-based console application for managing student records. It allows users to add a student, display all students, view a single student's details, update a student's information, and delete a student. This project utilizes Spring Core, Spring ORM (Hibernate), MySQL, and Eclipse IDE for seamless database interaction and CRUD operations.

## Table of Contents

- [🌟 Features](#features)
- [💻 Technologies Used](#technologies-used)
- [🛠️ Setup Instructions](#setup-instructions)
- [🚀 Usage](#usage)
- [🤝 Contributing](#contributing)
- [📝 License](#license)

## 🌟 Features

1. **Student Management:**
   - **Add Student:** Allows users to add a new student with name, age, and grade.
   - **View All Students:** Displays a list of all students in the system.
   - **View Student Details:** Allows users to view details of a single student by ID.
   - **Update Student Information:** Enables users to update existing student records.
   - **Delete Student:** Allows users to delete a student from the system.

2. **Database Integration:**
   - Uses Hibernate ORM for mapping Java objects to a MySQL database (`student_mgmt_db`).
   - Performs CRUD operations directly with the database.

3. **Console-Based Interface:**
   - A simple and user-friendly command-line interface to interact with the student records.

## 💻 Technologies Used

- Java
- Spring Core
- Spring ORM (Hibernate)
- MySQL
- Eclipse IDE
- Maven

## 🛠️ Setup Instructions

Follow these steps to set up the **Student Management Console** project on your local environment:

1. **Prerequisites:**
   - JDK (Java Development Kit) installed.
   - MySQL installed with a database named `student_mgmt_db`.
   - Eclipse IDE (or any Java IDE) installed.

2. **Clone the Repository:**
   ```bash
   git clone https://github.com/solocoder9/StudentMgmtConsol-SpringCore-CRUD.git
   ```

3. **Import the Project into Eclipse:**
   - Open Eclipse IDE.
   - Select `File` > `Import` > `Existing Maven Projects`.
   - Browse to the cloned repository and select the project.

4. **Configure MySQL Database:**
   - Ensure MySQL server is running.
   - Create a database named `student_mgmt_db`:
     ```sql
     CREATE DATABASE student_mgmt_db;
     ```

5. **Modify Hibernate Configuration:**
   - Open the `hibernate.cfg.xml` file located in the project directory.
   - Update the database connection details (URL, username, password) according to your MySQL setup.

6. **Run the Application:**
   - Right-click the project in Eclipse and select `Run As` > `Java Application`.
   - The application will run in the console.

## 🚀 Usage

1. **Home Page:**
   - Upon running the application, the user will be presented with a menu of options to choose from.
   - The options include adding a student, viewing students, updating records, and deleting a student.

2. **Add a New Student:**
   - Select the option to add a student.
   - Enter the student's details (name, age, grade) when prompted.

3. **View Students:**
   - Select the option to display all students or view a single student's details by ID.

4. **Update a Student:**
   - Select the option to update a student's information by entering their ID and the new details.

5. **Delete a Student:**
   - Select the option to delete a student by entering their ID.

## 🤝 Contributing

Contributions are welcome to improve the Student Management Console project! To contribute:

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/YourFeature`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Create a new Pull Request.

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

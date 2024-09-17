import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int id;
    private int age;
    private String grade;

    public Student(String name, int id, int age, String grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

    public void updateInformation(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}

public class StudentManagement {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static int totalStudents = 0; // Calculate total number of Student

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        // Menu options for Student Management System
        do {
            System.out.println("1. Add New Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Details");
            System.out.println("4. Exit");
            System.out.print("What you want to do? Enter a number: ");
            choice = scanner.nextInt(); // take user input choice
            scanner.nextLine(); // take newline

            // switch statement to determine user input
            switch (choice) {
                case 1: // run to add student
                    addStudent(scanner);
                    break;
                case 2: // run to update student
                    updateStudent(scanner);
                    break;
                case 3: // run to view student detail
                    viewStudentDetails(scanner);
                    break;
                case 4: // exit from program
                    System.out.println("Thanke you for using student management system. Exiting...");
                    break;
                default: // invalid input
                    System.out.println("Invalid choice. Please enter valid choice.");
            }
        } while (choice != 4);

        scanner.close();
    }

    // New Student Add
    private static void addStudent(Scanner scanner) { 
        // take input for name, id, age, grade
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();
        // store new student
        Student newStudent = new Student(name, id, age, grade);
        studentList.add(newStudent);
        totalStudents++;
        System.out.println("New student added successfully.");
    }

    // Update Student Information
    private static void updateStudent(Scanner scanner) {
        System.out.print("Enter student ID to update: ");
        // Take an id to update detail information
        int id = Integer.parseInt(scanner.nextLine());    
        boolean found = false;
        for (Student student : studentList) {
            if (student.getId() == id) {
                found = true;
                // take update information
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new age: ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter new grade: ");
                String grade = scanner.nextLine();
                // store data
                student.updateInformation(name, age, grade);
                System.out.println("Student information updated.");
                break;
            }
        }
        if (!found) {
            // error message when user input is invalid
            System.out.println("Student with ID: " + id + " not found.");
        }
    }
    

    // View the Student Detail
    private static void viewStudentDetails(Scanner scanner) { 
        System.out.print("Enter student ID to view details: ");
        // Take an id to view student detail information
        int id = scanner.nextInt();
        boolean found = false;
        for (Student student : studentList) {
            if (student.getId() == id) {
                found = true;
                System.out.println(student);
                break;
            }
        }
        if (!found) {
            // error message when user input is invalid
            System.out.println("Student with ID: " + id + " not found.");
        }
    }
}

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// class Student {
//     private String name;
//     private int id;
//     private List<Course> enrolledCourses;

//     public Student(String name, int id) {
//         this.name = name;
//         this.id = id;
//         this.enrolledCourses = new ArrayList<>();
//     }

//     public String getName() {
//         return name;
//     }

//     public int getId() {
//         return id;
//     }

//     public List<Course> getEnrolledCourses() {
//         return enrolledCourses;
//     }

//     public void enrollCourse(Course course) {
//         enrolledCourses.add(course);
//         course.increaseEnrolled();
//     }

//     public void assignGrade(Course course, int grade) {
//         for (Course enrolledCourse : enrolledCourses) {
//             if (enrolledCourse.getCode().equals(course.getCode())) {
//                 enrolledCourse.setGrade(this, grade);
//                 return;
//             }
//         }
//         System.out.println("Student is not enrolled in this course.");
//     }
// }

// class Course {
//     private String code;
//     private String name;
//     private int maxCapacity;
//     private static int totalEnrolled = 0;
//     private List<Student> enrolledStudents;
//     private List<Integer> grades;

//     public Course(String code, String name, int maxCapacity) {
//         this.code = code;
//         this.name = name;
//         this.maxCapacity = maxCapacity;
//         this.enrolledStudents = new ArrayList<>();
//         this.grades = new ArrayList<>();
//     }

//     public String getCode() {
//         return code;
//     }

//     public String getName() {
//         return name;
//     }

//     public int getMaxCapacity() {
//         return maxCapacity;
//     }

//     public static int getTotalEnrolled() {
//         return totalEnrolled;
//     }

//     public void increaseEnrolled() {
//         totalEnrolled++;
//     }

//     public void setGrade(Student student, int grade) {
//         int index = enrolledStudents.indexOf(student);
//         if (index != -1) {
//             grades.set(index, grade);
//         } else {
//             System.out.println("Student not found in the course.");
//         }
//     }

//     public void enrollStudent(Student student) {
//         if (enrolledStudents.size() < maxCapacity) {
//             enrolledStudents.add(student);
//             grades.add(0); // Initialize grade to 0
//         } else {
//             System.out.println("Course capacity reached. Cannot enroll student.");
//         }
//     }

//     public void printEnrolledStudents() {
//         System.out.println("Enrolled students in course " + name + ":");
//         for (Student student : enrolledStudents) {
//             System.out.println("- " + student.getName());
//         }
//     }

//     public void printGrades() {
//         System.out.println("Grades for course " + name + ":");
//         for (int i = 0; i < enrolledStudents.size(); i++) {
//             System.out.println(enrolledStudents.get(i).getName() + ": " + grades.get(i));
//         }
//     }

//     public double getGrade(Student student) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'getGrade'");
//     }
// }

// class CourseManagement {
//     private static List<Course> courses = new ArrayList<>();
//     private static List<Student> students = new ArrayList<>();

//     public static void addCourse(String code, String name, int maxCapacity) {
//         Course course = new Course(code, name, maxCapacity);
//         courses.add(course);
//     }

//     public static void enrollStudent(Student student, Course course) {
//         if (!students.contains(student)) {
//             students.add(student);
//         }
//         course.enrollStudent(student);
//         student.enrollCourse(course);
//     }

//     public static void assignGrade(Student student, Course course, int grade) {
//         course.setGrade(student, grade);
//     }

//     public static void calculateOverallGrade(Student student) {
//         List<Course> enrolledCourses = student.getEnrolledCourses();
//         double totalCredits = 0;
//         double weightedSum = 0;
//         for (Course course : enrolledCourses) {
//             double credits = 3.0; // Assuming all courses have 3 credits for simplicity
//             totalCredits += credits;
//             weightedSum += credits * course.getGrade(student);
//         }
//         double overallGrade = weightedSum / totalCredits;
//         System.out.println("Overall grade for student " + student.getName() + ": " + overallGrade);
//     }

//     public static void printEnrolledStudents(Course course) {
//         course.printEnrolledStudents();
//     }

//     public static void printGrades(Course course) {
//         course.printGrades();
//     }
// }

// public class AdministratorInterface {
//     private static Scanner scanner = new Scanner(System.in);

//     public static void main(String[] args) {
//         boolean exit = false;
//         while (!exit) {
//             System.out.println("\nMenu:");
//             System.out.println("1. Add a new course");
//             System.out.println("2. Enroll a student");
//             System.out.println("3. Assign grade to a student");
//             System.out.println("4. Calculate overall course grade for a student");
//             System.out.println("5. Print enrolled students in a course");
//             System.out.println("6. Print grades for a course");
//             System.out.println("7. Exit");
//             System.out.print("Enter your choice: ");

//             int choice = scanner.nextInt();
//             scanner.nextLine(); // Consume newline character

//             switch (choice) {
//                 case 1:
//                     addNewCourse();
//                     break;
//                 case 2:
//                     enrollStudent();
//                     break;
//                 case 3:
//                     assignGrade();
//                     break;
//                 case 4:
//                     calculateOverallGrade();
//                     break;
//                 case 5:
//                     printEnrolledStudents();
//                     break;
//                 case 6:
//                     printGrades();
//                     break;
//                 case 7:
//                     exit = true;
//                     break;
//                 default:
//                     System.out.println("Invalid choice. Please enter a number from 1 to 7.");
//             }
//         }
//         scanner.close();
//     }

//     private static void printGrades() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'printGrades'");
//     }

//     private static void printEnrolledStudents() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'printEnrolledStudents'");
//     }

//     private static void calculateOverallGrade() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'calculateOverallGrade'");
//     }

//     private static void addNewCourse() {
//         System.out.print("Enter course code: ");
//         String code = scanner.nextLine();
//         System.out.print("Enter course name: ");
//         String name = scanner.nextLine();
//         System.out.print("Enter maximum capacity: ");
//         int maxCapacity = scanner.nextInt();

//         CourseManagement.addCourse(code, name, maxCapacity);
//         System.out.println("Course added successfully.");
//     }

//     private static void enrollStudent() {
//         System.out.print("Enter student name: ");
//         String studentName = scanner.nextLine();
//         System.out.print("Enter student ID: ");
//         int studentId = scanner.nextInt();
//         scanner.nextLine(); // Consume newline character

//         System.out.print("Enter course code to enroll in: ");
//         String courseCode = scanner.nextLine();

//         Student student = new Student(studentName, studentId);
//         Course course = findCourseByCode(courseCode);

//         if (course != null) {
//             CourseManagement.enrollStudent(student, course);
//             System.out.println("Student enrolled successfully in course " + course.getName());
//         } else {
//             System.out.println("Course not found.");
//         }
//     }

//     private static Course findCourseByCode(String courseCode) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findCourseByCode'");
//     }

//     private static void assignGrade() {
//         System.out.print("Enter student name: ");
//         System.out.print("Enter course code: ");
//         System.out.print("Enter grade: ");
//     }
// }



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int id;
    private List<Course> enrolledCourses;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        course.enrollStudent(this);
    }

    public void assignGrade(Course course, int grade) {
        course.setGrade(this, grade);
    }

    public int getGrade(Course course) {
        return course.getGrade(this);
    }
}

class Course {
    private String code;
    private String name;
    private int maxCapacity;
    private static int totalEnrolled = 0;
    private List<Student> enrolledStudents;
    private List<Integer> grades;

    public Course(String code, String name, int maxCapacity) {
        this.code = code;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public static int getTotalEnrolled() {
        return totalEnrolled;
    }

    public static void increaseEnrolled() {
        totalEnrolled++;
    }

    public void setGrade(Student student, int grade) {
        int index = enrolledStudents.indexOf(student);
        if (index != -1) {
            grades.set(index, grade);
        } else {
            System.out.println("Student not found in the course.");
        }
    }

    public void enrollStudent(Student student) {
        if (enrolledStudents.size() < maxCapacity) {
            enrolledStudents.add(student);
            grades.add(0); // Initialize grade to 0
            increaseEnrolled();
        } else {
            System.out.println("Course capacity reached. Cannot enroll student.");
        }
    }

    public int getGrade(Student student) {
        int index = enrolledStudents.indexOf(student);
        if (index != -1) {
            return grades.get(index);
        }
        System.out.println("Student not found in the course.");
        return -1; // Error condition
    }

    public void printEnrolledStudents() {
        System.out.println("Enrolled students in course " + name + ":");
        for (Student student : enrolledStudents) {
            System.out.println("- " + student.getName());
        }
    }

    public void printGrades() {
        System.out.println("Grades for course " + name + ":");
        for (int i = 0; i < enrolledStudents.size(); i++) {
            System.out.println(enrolledStudents.get(i).getName() + ": " + grades.get(i));
        }
    }
}

class CourseManagement {
    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();

    public static void addCourse(String code, String name, int maxCapacity) {
        Course course = new Course(code, name, maxCapacity);
        courses.add(course);
    }

    public static void enrollStudent(Student student, Course course) {
        if (!students.contains(student)) {
            students.add(student);
        }
        course.enrollStudent(student);
        student.enrollCourse(course);
    }

    public static void assignGrade(Student student, Course course, int grade) {
        course.setGrade(student, grade);
    }

    public static void calculateOverallGrade(Student student) {
        List<Course> enrolledCourses = student.getEnrolledCourses();
        double totalCredits = 0;
        double weightedSum = 0;

        for (Course course : enrolledCourses) {
            double credits = 3.0; // Assuming all courses have 3 credits for simplicity
            totalCredits += credits;
            weightedSum += credits * course.getGrade(student);
        }

        if (totalCredits > 0) {
            double overallGrade = weightedSum / totalCredits;
            System.out.println("Overall grade for student " + student.getName() + ": " + overallGrade);
        } else {
            System.out.println("Student is not enrolled in any courses.");
        }
    }

    public static void printEnrolledStudents(Course course) {
        course.printEnrolledStudents();
    }

    public static void printGrades(Course course) {
        course.printGrades();
    }

    public static Course findCourseByCode(String code) {
        for (Course course : courses) {
            if (course.getCode().equals(code)) {
                return course;
            }
        }
        return null; // Course not found
    }
}

public class AdministratorInterface {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new course");
            System.out.println("2. Enroll a student");
            System.out.println("3. Assign grade to a student");
            System.out.println("4. Calculate overall course grade for a student");
            System.out.println("5. Print enrolled students in a course");
            System.out.println("6. Print grades for a course");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addNewCourse();
                    break;
                case 2:
                    enrollStudent();
                    break;
                case 3:
                    assignGrade();
                    break;
                case 4:
                    calculateOverallGrade();
                    break;
                case 5:
                    printEnrolledStudents();
                    break;
                case 6:
                    printGrades();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 7.");
            }
        }
        scanner.close();
    }

    private static void printEnrolledStudents() {
        String name;
        // TODO Auto-generated method stub
        System.out.println("Enrolled students in course " + name + ":");
        Student[] enrolledStudents;
        for (Student student : enrolledStudents) {
            System.out.println("- " + student.getName());
        }
    }

    private static void addNewCourse() {
        System.out.print("Enter course code: ");
        String code = scanner.nextLine();
        System.out.print("Enter course name: ");
        String name = scanner.nextLine();
        System.out.print("Enter maximum capacity: ");
                int maxCapacity = scanner.nextInt();
        
                CourseManagement.addCourse(code, name, maxCapacity);
                System.out.println("Course added successfully.");
            }
        
            private static void enrollStudent() {
                System.out.print("Enter student name: ");
                String studentName = scanner.nextLine();
                System.out.print("Enter student ID: ");
                int studentId = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
        
                System.out.print("Enter course code to enroll in: ");
                String courseCode = scanner.nextLine();
        
                Student student = new Student(studentName, studentId);
                Course course = findCourseByCode(courseCode);
        
                if (course != null) {
                    CourseManagement.enrollStudent(student, course);
                    System.out.println("Student enrolled successfully in course " + course.getName());
                } else {
                    System.out.println("Course not found.");
                }
            }
        
            private static Course findCourseByCode(String courseCode) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'findCourseByCode'");
            }
        
            private static void assignGrade() {
                System.out.print("Enter student name: ");
                System.out.print("Enter course code: ");
                System.out.print("Enter grade: ");
            }
        }

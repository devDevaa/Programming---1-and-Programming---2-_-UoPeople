package com.studentmanagementsystem.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        // Set the title of the window
        setTitle("Student Management System");

        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout manager
        setLayout(new BorderLayout());

        // Initialize GUI components
        initMenu();
        initComponents();

        // Pack the components and set the window size
        pack();
        setSize(800, 600);

        // Make the window visible
        setVisible(true);
    }

    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu studentMenu = new JMenu("Student");
        JMenuItem addStudentItem = new JMenuItem("Add Student");
        JMenuItem updateStudentItem = new JMenuItem("Update Student");
        JMenuItem viewStudentsItem = new JMenuItem("View Students");
        
        studentMenu.add(addStudentItem);
        studentMenu.add(updateStudentItem);
        studentMenu.add(viewStudentsItem);
        menuBar.add(studentMenu);
        
        JMenu courseMenu = new JMenu("Course");
        JMenuItem enrollStudentItem = new JMenuItem("Enroll Student");
        JMenuItem assignGradeItem = new JMenuItem("Assign Grade");

        courseMenu.add(enrollStudentItem);
        courseMenu.add(assignGradeItem);
        menuBar.add(courseMenu);

        setJMenuBar(menuBar);

        // Add event listeners for menu items
        addStudentItem.addActionListener(e -> showAddStudentForm());
        updateStudentItem.addActionListener(e -> showUpdateStudentForm());
        viewStudentsItem.addActionListener(e -> showStudentDetails());
        enrollStudentItem.addActionListener(e -> showEnrollStudentForm());
        assignGradeItem.addActionListener(e -> showAssignGradeForm());
    }

    private void initComponents() {
        // Initialize main components like tables, forms, etc.
    }

    private void showAddStudentForm() {
        // Code to display the form for adding a new student
    }

    private void showUpdateStudentForm() {
        // Code to display the form for updating student information
    }

    private void showStudentDetails() {
        // Code to display the table of student details
    }

    private void showEnrollStudentForm() {
        // Code to display the form for enrolling a student in a course
    }

    private void showAssignGradeForm() {
        // Code to display the form for assigning a grade to a student
    }
}

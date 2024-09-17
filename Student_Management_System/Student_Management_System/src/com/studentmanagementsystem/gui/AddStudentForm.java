package com.studentmanagementsystem.gui;

import java.awt.LayoutManager;

import javax.swing.*;

public class AddStudentForm {
    public static void showAddStudentForm() {
        JFrame addStudentFrame = new JFrame("Add Student");
        addStudentFrame.setLayout((LayoutManager) new GridLayout());

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel idLabel = new JLabel("Student ID:");
        JTextField idField = new JTextField();
        JLabel courseLabel = new JLabel("Course:");
        JTextField courseField = new JTextField();
        JButton addButton = new JButton("Add");

        addStudentFrame.add(nameLabel);
        addStudentFrame.add(nameField);
        addStudentFrame.add(idLabel);
        addStudentFrame.add(idField);
        addStudentFrame.add(courseLabel);
        addStudentFrame.add(courseField);
        addStudentFrame.add(new JLabel()); // Empty cell
        addStudentFrame.add(addButton);

        addButton.addActionListener(e -> {
            // Code to add student to the system
            String name = nameField.getText();
            String studentId = idField.getText();
            String course = courseField.getText();
            // Add student to database or list

            // Display success message
            JOptionPane.showMessageDialog(addStudentFrame, "Student added successfully!");
            addStudentFrame.dispose();
        });

        addStudentFrame.pack();
        addStudentFrame.setVisible(true);
    }
}

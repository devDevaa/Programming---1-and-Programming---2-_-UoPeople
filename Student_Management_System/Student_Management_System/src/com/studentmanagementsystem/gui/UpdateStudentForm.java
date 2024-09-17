package com.studentmanagementsystem.gui;

import javax.swing.*;

public class UpdateStudentForm {
    public static void showUpdateStudentForm() {
        JFrame updateStudentFrame = new JFrame("Update Student");
        updateStudentFrame.setLayout(new GridLayout(5, 2));

        JLabel idLabel = new JLabel("Student ID:");
        JTextField idField = new JTextField();
        JButton searchButton = new JButton("Search");

        updateStudentFrame.add(idLabel);
        updateStudentFrame.add(idField);
        updateStudentFrame.add(new JLabel()); // Empty cell
        updateStudentFrame.add(searchButton);

        searchButton.addActionListener(e -> {
            String studentId = idField.getText();
            // Search for the student in the system

            // If student found, display their current information
            JFrame editFrame = new JFrame("Edit Student");
            editFrame.setLayout(new GridLayout(5, 2));

            JLabel nameLabel = new JLabel("Name:");
            JTextField nameField = new JTextField(/* student's current name */);
            JLabel courseLabel = new JLabel("Course:");
            JTextField courseField = new JTextField(/* student's current course */);
            JButton updateButton = new JButton("Update");

            editFrame.add(nameLabel);
            editFrame.add(nameField);
            editFrame.add(courseLabel);
            editFrame.add(courseField);
            editFrame.add(new JLabel()); // Empty cell
            editFrame.add(updateButton);

            updateButton.addActionListener(ev -> {
                // Code to update student information
                String name = nameField.getText();
                String course = courseField.getText();
                // Update student in database or list

                // Display success message
                JOptionPane.showMessageDialog(editFrame, "Student updated successfully!");
                editFrame.dispose();
            });

            editFrame.pack();
            editFrame.setVisible(true);
        });

        updateStudentFrame.pack();
        updateStudentFrame.setVisible(true);
    }
}

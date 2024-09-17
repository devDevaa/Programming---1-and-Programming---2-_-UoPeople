package com.studentmanagementsystem.gui;

import javax.swing.*;

public class EnrollStudentForm {
    public static void showEnrollStudentForm() {
        JFrame enrollFrame = new JFrame("Enroll Student");
        enrollFrame.setLayout(new GridLayout(3, 2));

        JLabel courseLabel = new JLabel("Course:");
        JComboBox<String> courseDropdown = new JComboBox<>(new String[]{"Math", "Science"});
        JLabel studentLabel = new JLabel("Student ID:");
        JTextField studentField = new JTextField();
        JButton enrollButton = new JButton("Enroll");

        enrollFrame.add(courseLabel);
        enrollFrame.add(courseDropdown);
        enrollFrame.add(studentLabel);
        enrollFrame.add(studentField);
        enrollFrame.add(new JLabel()); // Empty cell
        enrollFrame.add(enrollButton);

        enrollButton.addActionListener(e -> {
            String course = (String) courseDropdown.getSelectedItem();
            String studentId = studentField.getText();
            // Enroll student in the course

            // Display success message
            JOptionPane.showMessageDialog(enrollFrame, "Student enrolled successfully!");
            enrollFrame.dispose();
        });

        enrollFrame.pack();
        enrollFrame.setVisible(true);
    }
}

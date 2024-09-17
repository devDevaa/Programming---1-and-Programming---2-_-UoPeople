package com.studentmanagementsystem.gui;
import java.awt.LayoutManager;
import javax.swing.*;

public class AssignGradeForm {
    public static void showAssignGradeForm() {
        JFrame gradeFrame = new JFrame("Assign Grade");
        gradeFrame.setLayout((LayoutManager) new GridLayout());
        JLabel studentLabel = new JLabel("Student ID:");
        JTextField studentField = new JTextField();
        JLabel courseLabel = new JLabel("Course:");
        JTextField courseField = new JTextField();
        JLabel gradeLabel = new JLabel("Grade:");
        JTextField gradeField = new JTextField();
        JButton assignButton = new JButton("Assign");

        gradeFrame.add(studentLabel);
        gradeFrame.add(studentField);
        gradeFrame.add(courseLabel);
        gradeFrame.add(courseField);
        gradeFrame.add(gradeLabel);
        gradeFrame.add(gradeField);
        gradeFrame.add(new JLabel()); // Empty cell
        gradeFrame.add(assignButton);

        assignButton.addActionListener(e -> {
            String studentId = studentField.getText();
            String course = courseField.getText();
            String grade = gradeField.getText();
            // Assign grade to student

            // Display success message
            JOptionPane.showMessageDialog(gradeFrame, "Grade assigned successfully!");
            gradeFrame.dispose();
        });

        gradeFrame.pack();
        gradeFrame.setVisible(true);
    }
}

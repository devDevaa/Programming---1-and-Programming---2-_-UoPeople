package com.studentmanagementsystem.gui;

import javax.swing.*;
import java.awt.*;

public class ViewStudentsForm {
    public static void showStudentDetails() {
        JFrame viewFrame = new JFrame("Student Details");
        String[] columnNames = {"Student ID", "Name", "Course"};
        Object[][] data = {
            {"1", "John Doe", "Math"},
            {"2", "Jane Smith", "Science"}
            // Populate with actual student data
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        viewFrame.add(scrollPane, BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);
    }
}

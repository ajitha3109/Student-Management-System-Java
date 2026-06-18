import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class AttendancePage {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame("Attendance Module");

        frame.getContentPane()
                .setBackground(
                        new Color(
                                245,
                                245,
                                245));

        // TITLE
        JLabel title =
                new JLabel(
                        "MARK ATTENDANCE");

        title.setBounds(
                90,
                20,
                250,
                40);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24));

        title.setForeground(
                new Color(
                        0,
                        102,
                        204));

        // STUDENT ID
        JLabel idLabel =
                new JLabel("Student ID:");

        idLabel.setBounds(
                50,
                90,
                100,
                30);

        JTextField idField =
                new JTextField();

        idField.setBounds(
                180,
                90,
                150,
                30);

        // DATE
        JLabel dateLabel =
                new JLabel("Date:");

        dateLabel.setBounds(
                50,
                150,
                100,
                30);

        JTextField dateField =
                new JTextField();

        dateField.setBounds(
                180,
                150,
                150,
                30);

        dateField.setText("2026-06-16");

        // STATUS
        JLabel statusLabel =
                new JLabel("Status:");

        statusLabel.setBounds(
                50,
                210,
                100,
                30);

        String[] statusOptions = {
                "Present",
                "Absent"
        };

        JComboBox<String> statusBox =
                new JComboBox<>(statusOptions);

        statusBox.setBounds(
                180,
                210,
                150,
                30);

        // SAVE BUTTON
        JButton saveBtn =
                new JButton("Save Attendance");

        saveBtn.setBounds(
                60,
                310,
                150,
                40);

        saveBtn.setBackground(
                new Color(
                        0,
                        153,
                        76));

        saveBtn.setForeground(
                Color.WHITE);

        // BACK BUTTON
        JButton backBtn =
                new JButton("Back");

        backBtn.setBounds(
                240,
                310,
                100,
                40);

        backBtn.setBackground(
                Color.GRAY);

        backBtn.setForeground(
                Color.WHITE);

        // SAVE ACTION
        saveBtn.addActionListener(e -> {

            try {

                int studentId =
                        Integer.parseInt(
                                idField.getText());

                String date =
                        dateField.getText();

                String status =
                        statusBox.getSelectedItem()
                                .toString();

                // LOAD DRIVER
                Class.forName(
                        "com.mysql.cj.jdbc.Driver");

                // CONNECTION
                Connection con =
                        DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/studentdb",
                                "root",
                                "root123");

                // QUERY
                String query =
                        "INSERT INTO attendance(student_id, attendance_date, status) VALUES (?, ?, ?)";

                PreparedStatement pst =
                        con.prepareStatement(query);

                pst.setInt(1, studentId);

                pst.setString(2, date);

                pst.setString(3, status);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(
                        frame,
                        "Attendance Saved Successfully!");

                // CLEAR FIELD
                idField.setText("");

                con.close();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        ex.getMessage());
            }
        });

        // BACK ACTION
        backBtn.addActionListener(e -> {

            frame.dispose();
        });

        // ADD COMPONENTS
        frame.add(title);

        frame.add(idLabel);
        frame.add(idField);

        frame.add(dateLabel);
        frame.add(dateField);

        frame.add(statusLabel);
        frame.add(statusBox);

        frame.add(saveBtn);

        frame.add(backBtn);

        // FRAME SETTINGS
        frame.setSize(
                430,
                430);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        frame.setResizable(false);

        frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);
    }
}

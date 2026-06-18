import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class SmartAttendancePage {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame("Smart Attendance System");

        frame.getContentPane()
                .setBackground(
                        new Color(
                                245,
                                245,
                                245));

        // TITLE
        JLabel title =
                new JLabel(
                        "ATTENDANCE MANAGEMENT",
                        SwingConstants.CENTER);

        title.setBounds(
                150,
                20,
                400,
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

        // DATE
        JLabel dateLabel =
                new JLabel("Date:");

        dateLabel.setBounds(
                30,
                90,
                60,
                30);

        JTextField dateField =
                new JTextField("2026-06-16");

        dateField.setBounds(
                90,
                90,
                150,
                30);

        // TABLE
        String[] columns = {
                "Student ID",
                "Name",
                "Department",
                "Attendance"
        };

        DefaultTableModel model =
                new DefaultTableModel(columns, 0);

        JTable table =
                new JTable(model);

        JComboBox<String> combo =
                new JComboBox<>(
                        new String[] {
                                "Present",
                                "Absent"
                        });

        table.getColumnModel()
                .getColumn(3)
                .setCellEditor(
                        new DefaultCellEditor(combo));

        JScrollPane scrollPane =
                new JScrollPane(table);

        scrollPane.setBounds(
                30,
                140,
                620,
                250);

        // LOAD STUDENTS
        try {

            Class.forName(
                    "com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/studentdb",
                            "root",
                            "root123");

            String query =
                    "SELECT * FROM students";

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(query);

            while(rs.next()) {

                int id =
                        rs.getInt("id");

                String name =
                        rs.getString("name");

                String dept =
                        rs.getString("department");

                model.addRow(
                        new Object[] {
                                id,
                                name,
                                dept,
                                "Present"
                        });
            }

            con.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    frame,
                    ex.getMessage());
        }

        // SAVE BUTTON
        JButton saveBtn =
                new JButton("Save Attendance");

        saveBtn.setBounds(
                180,
                430,
                170,
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
                400,
                430,
                100,
                40);

        backBtn.setBackground(
                Color.GRAY);

        backBtn.setForeground(
                Color.WHITE);

        // SAVE ACTION
        saveBtn.addActionListener(e -> {

            try {

                Class.forName(
                        "com.mysql.cj.jdbc.Driver");

                Connection con =
                        DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/studentdb",
                                "root",
                                "root123");

                String date =
                        dateField.getText();

                for(int i = 0;
                    i < model.getRowCount();
                    i++) {

                    int studentId =
                            Integer.parseInt(
                                    model.getValueAt(i, 0)
                                            .toString());

                    String status =
                            model.getValueAt(i, 3)
                                    .toString();

                    String query =
                            "REPLACE INTO attendance(student_id, attendance_date, status) VALUES (?, ?, ?)";

                    PreparedStatement pst =
                            con.prepareStatement(query);

                    pst.setInt(1, studentId);

                    pst.setString(2, date);

                    pst.setString(3, status);

                    pst.executeUpdate();
                }

                JOptionPane.showMessageDialog(
                        frame,
                        "Attendance Saved Successfully!");

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

        frame.add(dateLabel);

        frame.add(dateField);

        frame.add(scrollPane);

        frame.add(saveBtn);

        frame.add(backBtn);

        // SETTINGS
        frame.setSize(
                700,
                550);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);
    }
}

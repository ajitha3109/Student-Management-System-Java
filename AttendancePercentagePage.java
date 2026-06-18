import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class AttendancePercentagePage {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame(
                        "Attendance Percentage");

        // TABLE COLUMNS
        String[] columns = {
                "Student ID",
                "Present Days",
                "Total Days",
                "Percentage"
        };

        DefaultTableModel model =
                new DefaultTableModel(columns, 0);

        JTable table =
                new JTable(model);

        JScrollPane scrollPane =
                new JScrollPane(table);

        scrollPane.setBounds(
                20,
                20,
                540,
                300);

        // DATABASE FETCH
        try {

            Class.forName(
                    "com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/studentdb",
                            "root",
                            "root123");

            String query =
                    "SELECT student_id, " +
                    "SUM(status='Present') AS present_days, " +
                    "COUNT(*) AS total_days " +
                    "FROM attendance " +
                    "GROUP BY student_id";

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(query);

            while(rs.next()) {

                int studentId =
                        rs.getInt("student_id");

                int presentDays =
                        rs.getInt("present_days");

                int totalDays =
                        rs.getInt("total_days");

                double percentage =
                        ((double) presentDays
                                / totalDays) * 100;

                model.addRow(
                        new Object[] {
                                studentId,
                                presentDays,
                                totalDays,
                                String.format(
                                        "%.2f%%",
                                        percentage)
                        });
            }

            con.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    frame,
                    ex.getMessage());
        }

        // BACK BUTTON
        JButton backBtn =
                new JButton("Back");

        backBtn.setBounds(
                240,
                340,
                100,
                35);

        backBtn.addActionListener(e -> {

            frame.dispose();
        });

        // ADD COMPONENTS
        frame.add(scrollPane);

        frame.add(backBtn);

        // FRAME SETTINGS
        frame.setSize(
                600,
                430);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);
    }
}

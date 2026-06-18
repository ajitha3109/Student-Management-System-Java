import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewAttendancePage {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame("View Attendance");

        // TABLE COLUMNS
        String[] columns = {
                "Attendance ID",
                "Student ID",
                "Date",
                "Status"
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
                640,
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
                    "SELECT * FROM attendance";

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(query);

            while(rs.next()) {

                int attendanceId =
                        rs.getInt("attendance_id");

                int studentId =
                        rs.getInt("student_id");

                String date =
                        rs.getString("attendance_date");

                String status =
                        rs.getString("status");

                model.addRow(
                        new Object[] {
                                attendanceId,
                                studentId,
                                date,
                                status
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
                280,
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
                700,
                430);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);
    }
}

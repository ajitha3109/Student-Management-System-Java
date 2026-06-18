import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewMarksPage {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame("View Marks");

        // TABLE COLUMNS
        String[] columns = {
                "Student ID",
                "Internal 1",
                "Internal 2",
                "Assignment",
                "Model Mark",
                "Total"
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
                740,
                300);

        try {

            Class.forName(
                    "com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/studentdb",
                            "root",
                            "root123");

            String query =
                    "SELECT * FROM marks";

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(query);

            while(rs.next()) {

                int studentId =
                        rs.getInt("student_id");

                int internal1 =
                        rs.getInt("internal1");

                int internal2 =
                        rs.getInt("internal2");

                int assignment =
                        rs.getInt("assignment_mark");

                int modelMark =
                        rs.getInt("model_mark");

                int total =
                        internal1
                        + internal2
                        + assignment
                        + modelMark;

                model.addRow(
                        new Object[] {
                                studentId,
                                internal1,
                                internal2,
                                assignment,
                                modelMark,
                                total
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
                330,
                340,
                100,
                40);

        backBtn.addActionListener(e -> {

            frame.dispose();
        });

        frame.add(scrollPane);

        frame.add(backBtn);

        frame.setSize(
                800,
                450);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);
    }
}
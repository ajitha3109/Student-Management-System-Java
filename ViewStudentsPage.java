import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewStudentsPage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("View Students");

        // TABLE COLUMNS
        String[] columns = {
                "ID",
                "Name",
                "Department",
                "Age"
        };

        DefaultTableModel model =
                new DefaultTableModel(columns, 0);

        JTable table =
                new JTable(model);

        JScrollPane scrollPane =
                new JScrollPane(table);

        scrollPane.setBounds(20, 20, 540, 300);

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

                int age =
                        rs.getInt("age");

                model.addRow(
                        new Object[] {
                                id,
                                name,
                                dept,
                                age
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

        backBtn.setBounds(240, 330, 100, 35);

        backBtn.addActionListener(e -> {

            frame.dispose();
        });

        // ADD COMPONENTS
        frame.add(scrollPane);

        frame.add(backBtn);

        // FRAME SETTINGS
        frame.setSize(600, 430);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);
    }
}
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class SearchStudentPage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Search Student");

        frame.getContentPane().setBackground(
                new Color(245, 245, 245));

        // TITLE
        JLabel title = new JLabel("SEARCH STUDENT");

        title.setBounds(90, 20, 250, 40);

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

        // SEARCH LABEL
        JLabel searchLabel =
                new JLabel("Enter Student ID:");

        searchLabel.setBounds(
                40,
                100,
                140,
                30);

        JTextField searchField =
                new JTextField();

        searchField.setBounds(
                180,
                100,
                150,
                30);

        // SEARCH BUTTON
        JButton searchBtn =
                new JButton("Search");

        searchBtn.setBounds(
                120,
                170,
                120,
                40);

        searchBtn.setBackground(
                new Color(
                        0,
                        153,
                        76));

        searchBtn.setForeground(
                Color.WHITE);

        // BACK BUTTON
        JButton backBtn =
                new JButton("Back");

        backBtn.setBounds(
                250,
                170,
                90,
                40);

        backBtn.addActionListener(e -> {

            frame.dispose();
        });

        // RESULT AREA
        JTextArea resultArea =
                new JTextArea();

        resultArea.setBounds(
                40,
                230,
                350,
                180);

        resultArea.setEditable(false);

        resultArea.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        14));

        // SEARCH ACTION
        searchBtn.addActionListener(e -> {

            try {

                int id =
                        Integer.parseInt(
                                searchField.getText());

                Class.forName(
                        "com.mysql.cj.jdbc.Driver");

                Connection con =
                        DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/studentdb",
                                "root",
                                "root123");

                String query =
                        "SELECT * FROM students WHERE id=?";

                PreparedStatement pst =
                        con.prepareStatement(query);

                pst.setInt(1, id);

                ResultSet rs =
                        pst.executeQuery();

                if (rs.next()) {

                    String result =
                            "========== STUDENT DETAILS ==========\n\n" +

                            "ID          : "
                                    + rs.getInt("id")
                                    + "\n\n" +

                            "Name        : "
                                    + rs.getString("name")
                                    + "\n\n" +

                            "Department  : "
                                    + rs.getString("department")
                                    + "\n\n" +

                            "Age         : "
                                    + rs.getInt("age")
                                    + "\n\n" +

                            "===================================";

                    resultArea.setText(result);

                } else {

                    resultArea.setText(
                            "Student Not Found!");
                }

                con.close();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        ex.getMessage());
            }
        });

        // ADD COMPONENTS
        frame.add(title);

        frame.add(searchLabel);

        frame.add(searchField);

        frame.add(searchBtn);

        frame.add(backBtn);

        frame.add(resultArea);

        // FRAME SETTINGS
        frame.setSize(
                450,
                500);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);
    }
}
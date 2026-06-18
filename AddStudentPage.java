import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class AddStudentPage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Add Student");

        frame.getContentPane().setBackground(
                new Color(245, 245, 245));

        // TITLE
        JLabel title =
                new JLabel(
                        "ADD STUDENT");

        title.setBounds(120, 10, 200, 40);

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

        // ID
        JLabel idLabel =
                new JLabel("Student ID:");

        idLabel.setBounds(50, 70, 100, 30);

        JTextField idField =
                new JTextField();

        idField.setBounds(170, 70, 150, 30);

        // NAME
        JLabel nameLabel =
                new JLabel("Student Name:");

        nameLabel.setBounds(50, 120, 120, 30);

        JTextField nameField =
                new JTextField();

        nameField.setBounds(170, 120, 150, 30);

        // DEPARTMENT
        JLabel deptLabel =
                new JLabel("Department:");

        deptLabel.setBounds(50, 170, 120, 30);

        JTextField deptField =
                new JTextField();

        deptField.setBounds(170, 170, 150, 30);

        // AGE
        JLabel ageLabel =
                new JLabel("Age:");

        ageLabel.setBounds(50, 220, 120, 30);

        JTextField ageField =
                new JTextField();

        ageField.setBounds(170, 220, 150, 30);

        // ADD BUTTON
        JButton addBtn =
                new JButton("Add Student");

        addBtn.setBounds(70, 310, 130, 40);

        addBtn.setBackground(
                new Color(
                        0,
                        153,
                        76));

        addBtn.setForeground(
                Color.WHITE);

        // BACK BUTTON
        JButton backBtn =
                new JButton("Back");

        backBtn.setBounds(220, 310, 100, 40);

        backBtn.setBackground(
                Color.GRAY);

        backBtn.setForeground(
                Color.WHITE);

        // ADD ACTION
        addBtn.addActionListener(e -> {

            try {

                int id =
                        Integer.parseInt(
                                idField.getText());

                String name =
                        nameField.getText();

                String dept =
                        deptField.getText();

                int age =
                        Integer.parseInt(
                                ageField.getText());

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
                        "INSERT INTO students VALUES (?, ?, ?, ?)";

                PreparedStatement pst =
                        con.prepareStatement(query);

                pst.setInt(1, id);

                pst.setString(2, name);

                pst.setString(3, dept);

                pst.setInt(4, age);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(
                        frame,
                        "Student Added Successfully!");

                // CLEAR FIELDS
                idField.setText("");

                nameField.setText("");

                deptField.setText("");

                ageField.setText("");

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

        frame.add(nameLabel);
        frame.add(nameField);

        frame.add(deptLabel);
        frame.add(deptField);

        frame.add(ageLabel);
        frame.add(ageField);

        frame.add(addBtn);

        frame.add(backBtn);

        // FRAME SETTINGS
        frame.setSize(420, 430);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        frame.setResizable(false);

        frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);
    }
}
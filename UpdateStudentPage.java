import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class UpdateStudentPage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Update Student");

        frame.getContentPane().setBackground(
                new Color(245, 245, 245));

        // TITLE
        JLabel title =
                new JLabel("UPDATE STUDENT");

        title.setBounds(90, 20, 250, 40);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24));

        title.setForeground(
                new Color(
                        255,
                        153,
                        0));

        // ID
        JLabel idLabel =
                new JLabel("Student ID:");

        idLabel.setBounds(50, 80, 100, 30);

        JTextField idField =
                new JTextField();

        idField.setBounds(180, 80, 150, 30);

        // NAME
        JLabel nameLabel =
                new JLabel("New Name:");

        nameLabel.setBounds(50, 130, 100, 30);

        JTextField nameField =
                new JTextField();

        nameField.setBounds(180, 130, 150, 30);

        // DEPARTMENT
        JLabel deptLabel =
                new JLabel("Department:");

        deptLabel.setBounds(50, 180, 100, 30);

        JTextField deptField =
                new JTextField();

        deptField.setBounds(180, 180, 150, 30);

        // AGE
        JLabel ageLabel =
                new JLabel("New Age:");

        ageLabel.setBounds(50, 230, 100, 30);

        JTextField ageField =
                new JTextField();

        ageField.setBounds(180, 230, 150, 30);

        // UPDATE BUTTON
        JButton updateBtn =
                new JButton("Update");

        updateBtn.setBounds(70, 320, 120, 40);

        updateBtn.setBackground(
                new Color(
                        255,
                        153,
                        0));

        updateBtn.setForeground(
                Color.WHITE);

        // BACK BUTTON
        JButton backBtn =
                new JButton("Back");

        backBtn.setBounds(220, 320, 100, 40);

        backBtn.addActionListener(e -> {

            frame.dispose();
        });

        // UPDATE ACTION
        updateBtn.addActionListener(e -> {

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

                Class.forName(
                        "com.mysql.cj.jdbc.Driver");

                Connection con =
                        DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/studentdb",
                                "root",
                                "root123");

                String query =
                        "UPDATE students SET name=?, department=?, age=? WHERE id=?";

                PreparedStatement pst =
                        con.prepareStatement(query);

                pst.setString(1, name);

                pst.setString(2, dept);

                pst.setInt(3, age);

                pst.setInt(4, id);

                int rows =
                        pst.executeUpdate();

                if(rows > 0) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Student Updated Successfully!");

                } else {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Student ID Not Found!");
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

        frame.add(idLabel);
        frame.add(idField);

        frame.add(nameLabel);
        frame.add(nameField);

        frame.add(deptLabel);
        frame.add(deptField);

        frame.add(ageLabel);
        frame.add(ageField);

        frame.add(updateBtn);

        frame.add(backBtn);

        // FRAME SETTINGS
        frame.setSize(420, 450);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);
    }
}
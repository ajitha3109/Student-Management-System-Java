import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class DeleteStudentPage {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame("Delete Student");

        frame.getContentPane().setBackground(
                new Color(
                        245,
                        245,
                        245));

        // TITLE
        JLabel title =
                new JLabel(
                        "DELETE STUDENT");

        title.setBounds(
                90,
                30,
                250,
                40);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24));

        title.setForeground(
                Color.RED);

        // ID
        JLabel idLabel =
                new JLabel("Student ID:");

        idLabel.setBounds(
                50,
                110,
                100,
                30);

        JTextField idField =
                new JTextField();

        idField.setBounds(
                170,
                110,
                150,
                30);

        // DELETE BUTTON
        JButton deleteBtn =
                new JButton("Delete");

        deleteBtn.setBounds(
                70,
                220,
                120,
                40);

        deleteBtn.setBackground(
                Color.RED);

        deleteBtn.setForeground(
                Color.WHITE);

        // BACK BUTTON
        JButton backBtn =
                new JButton("Back");

        backBtn.setBounds(
                220,
                220,
                100,
                40);

        backBtn.addActionListener(e -> {

            frame.dispose();
        });

        // DELETE ACTION
        deleteBtn.addActionListener(e -> {

            try {

                int id =
                        Integer.parseInt(
                                idField.getText());

                Class.forName(
                        "com.mysql.cj.jdbc.Driver");

                Connection con =
                        DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/studentdb",
                                "root",
                                "root123");

                String query =
                        "DELETE FROM students WHERE id=?";

                PreparedStatement pst =
                        con.prepareStatement(query);

                pst.setInt(1, id);

                int rows =
                        pst.executeUpdate();

                if(rows > 0) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Student Deleted Successfully!");

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

        frame.add(deleteBtn);

        frame.add(backBtn);

        // FRAME SETTINGS
        frame.setSize(420, 350);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);
    }
}
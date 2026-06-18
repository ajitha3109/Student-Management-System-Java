import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MarksEntryPage {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame("Marks Entry");

        frame.getContentPane()
                .setBackground(
                        new Color(
                                245,
                                245,
                                245));

        // TITLE
        JLabel title =
                new JLabel(
                        "MARKS ENTRY");

        title.setBounds(
                120,
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
                40,
                90,
                120,
                30);

        JTextField idField =
                new JTextField();

        idField.setBounds(
                180,
                90,
                150,
                30);

        // INTERNAL 1
        JLabel i1Label =
                new JLabel("Internal 1:");

        i1Label.setBounds(
                40,
                140,
                120,
                30);

        JTextField i1Field =
                new JTextField();

        i1Field.setBounds(
                180,
                140,
                150,
                30);

        // INTERNAL 2
        JLabel i2Label =
                new JLabel("Internal 2:");

        i2Label.setBounds(
                40,
                190,
                120,
                30);

        JTextField i2Field =
                new JTextField();

        i2Field.setBounds(
                180,
                190,
                150,
                30);

        // ASSIGNMENT
        JLabel assignLabel =
                new JLabel("Assignment:");

        assignLabel.setBounds(
                40,
                240,
                120,
                30);

        JTextField assignField =
                new JTextField();

        assignField.setBounds(
                180,
                240,
                150,
                30);

        // MODEL MARK
        JLabel modelLabel =
                new JLabel("Model Mark:");

        modelLabel.setBounds(
                40,
                290,
                120,
                30);

        JTextField modelField =
                new JTextField();

        modelField.setBounds(
                180,
                290,
                150,
                30);

        // SAVE BUTTON
        JButton saveBtn =
                new JButton("Save Marks");

        saveBtn.setBounds(
                70,
                370,
                130,
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
                220,
                370,
                100,
                40);

        backBtn.addActionListener(e -> {

            frame.dispose();
        });

        // SAVE ACTION
        saveBtn.addActionListener(e -> {

            try {

                int studentId =
                        Integer.parseInt(
                                idField.getText());

                int internal1 =
                        Integer.parseInt(
                                i1Field.getText());

                int internal2 =
                        Integer.parseInt(
                                i2Field.getText());

                int assignment =
                        Integer.parseInt(
                                assignField.getText());

                int model =
                        Integer.parseInt(
                                modelField.getText());

                Class.forName(
                        "com.mysql.cj.jdbc.Driver");

                Connection con =
                        DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/studentdb",
                                "root",
                                "root123");

                String query =
                        "REPLACE INTO marks VALUES (?, ?, ?, ?, ?)";

                PreparedStatement pst =
                        con.prepareStatement(query);

                pst.setInt(1, studentId);
                pst.setInt(2, internal1);
                pst.setInt(3, internal2);
                pst.setInt(4, assignment);
                pst.setInt(5, model);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(
                        frame,
                        "Marks Saved Successfully!");

                con.close();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        ex.getMessage());
            }
        });

        frame.add(title);

        frame.add(idLabel);
        frame.add(idField);

        frame.add(i1Label);
        frame.add(i1Field);

        frame.add(i2Label);
        frame.add(i2Field);

        frame.add(assignLabel);
        frame.add(assignField);

        frame.add(modelLabel);
        frame.add(modelField);

        frame.add(saveBtn);

        frame.add(backBtn);

        frame.setSize(
                420,
                500);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);
    }
}
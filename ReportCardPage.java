import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ReportCardPage {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame("Student Report Card");

        frame.getContentPane()
                .setBackground(
                        new Color(
                                245,
                                245,
                                245));

        // TITLE
        JLabel title =
                new JLabel(
                        "STUDENT REPORT CARD");

        title.setBounds(
                80,
                20,
                350,
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
                100,
                30);

        JTextField idField =
                new JTextField();

        idField.setBounds(
                150,
                90,
                150,
                30);

        // GENERATE BUTTON
        JButton generateBtn =
                new JButton("Generate");

        generateBtn.setBounds(
                110,
                140,
                120,
                40);

        generateBtn.setBackground(
                new Color(
                        0,
                        153,
                        76));

        generateBtn.setForeground(
                Color.WHITE);

        // BACK BUTTON
        JButton backBtn =
                new JButton("Back");

        backBtn.setBounds(
                250,
                140,
                90,
                40);

        backBtn.addActionListener(e -> {

            frame.dispose();
        });

        // REPORT AREA
        JTextArea reportArea =
                new JTextArea();

        reportArea.setBounds(
                30,
                220,
                420,
                280);

        reportArea.setEditable(false);

        reportArea.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        14));

        // GENERATE ACTION
        generateBtn.addActionListener(e -> {

            try {

                int studentId =
                        Integer.parseInt(
                                idField.getText());

                Class.forName(
                        "com.mysql.cj.jdbc.Driver");

                Connection con =
                        DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/studentdb",
                                "root",
                                "root123");

                // MARKS QUERY
                String marksQuery =
                        "SELECT * FROM marks WHERE student_id=?";

                PreparedStatement marksPst =
                        con.prepareStatement(
                                marksQuery);

                marksPst.setInt(
                        1,
                        studentId);

                ResultSet marksRs =
                        marksPst.executeQuery();

                // ATTENDANCE QUERY
                String attendanceQuery =
                        "SELECT " +
                        "SUM(status='Present') AS present_days, " +
                        "COUNT(*) AS total_days " +
                        "FROM attendance " +
                        "WHERE student_id=?";

                PreparedStatement attendancePst =
                        con.prepareStatement(
                                attendanceQuery);

                attendancePst.setInt(
                        1,
                        studentId);

                ResultSet attendanceRs =
                        attendancePst.executeQuery();

                if(marksRs.next()) {

                    int i1 =
                            marksRs.getInt(
                                    "internal1");

                    int i2 =
                            marksRs.getInt(
                                    "internal2");

                    int assignment =
                            marksRs.getInt(
                                    "assignment_mark");

                    int model =
                            marksRs.getInt(
                                    "model_mark");

                    int total =
                            i1 + i2 +
                            assignment +
                            model;

                    double attendancePercentage = 0;

                    if(attendanceRs.next()) {

                        int present =
                                attendanceRs.getInt(
                                        "present_days");

                        int totalDays =
                                attendanceRs.getInt(
                                        "total_days");

                        if(totalDays > 0) {

                            attendancePercentage =
                                    ((double) present
                                            / totalDays)
                                            * 100;
                        }
                    }

                    String result =
                            total >= 50
                                    ? "PASS"
                                    : "FAIL";

                    String report =
                            "=========================\n\n" +

                            "STUDENT REPORT CARD\n\n" +

                            "=========================\n\n" +

                            "Student ID : "
                                    + studentId
                                    + "\n\n" +

                            "Internal 1 : "
                                    + i1
                                    + "\n\n" +

                            "Internal 2 : "
                                    + i2
                                    + "\n\n" +

                            "Assignment : "
                                    + assignment
                                    + "\n\n" +

                            "Model Mark : "
                                    + model
                                    + "\n\n" +

                            "Total Marks : "
                                    + total
                                    + "\n\n" +

                            "Attendance : "
                                    + String.format(
                                    "%.2f%%",
                                    attendancePercentage)
                                    + "\n\n" +

                            "Result : "
                                    + result
                                    + "\n\n" +

                            "=========================";

                    reportArea.setText(
                            report);

                } else {

                    reportArea.setText(
                            "No Marks Found!");
                }

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

        frame.add(generateBtn);

        frame.add(backBtn);

        frame.add(reportArea);

        frame.setSize(
                500,
                580);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);
    }
}
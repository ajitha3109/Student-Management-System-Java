import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StudentGUI {

    static String url = "jdbc:mysql://localhost:3306/studentdb";
    static String user = "root";
    static String password = "root123";

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Management System");

        // TITLE
        JLabel title = new JLabel("Student Management System");
        title.setBounds(100, 20, 250, 30);

        // LABELS
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 70, 100, 30);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 120, 100, 30);

        JLabel deptLabel = new JLabel("Department:");
        deptLabel.setBounds(50, 170, 100, 30);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 220, 100, 30);

        // TEXTFIELDS
        JTextField idField = new JTextField();
        idField.setBounds(150, 70, 150, 30);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 120, 150, 30);

        JTextField deptField = new JTextField();
        deptField.setBounds(150, 170, 150, 30);

        JTextField ageField = new JTextField();
        ageField.setBounds(150, 220, 150, 30);

        // BUTTON
        JButton addButton = new JButton("Add Student");
        addButton.setBounds(120, 290, 140, 40);

        // BUTTON ACTION
        addButton.addActionListener(e -> {

            try {

                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String dept = deptField.getText();
                int age = Integer.parseInt(ageField.getText());

                Connection con = DriverManager.getConnection(url, user, password);

                Statement st = con.createStatement();

                String query = "INSERT INTO students VALUES(" +
                        id + ",'" + name + "','" + dept + "'," + age + ")";

                st.executeUpdate(query);

                JOptionPane.showMessageDialog(frame,
                        "Student Added Successfully!");

                con.close();

                // CLEAR FIELDS
                idField.setText("");
                nameField.setText("");
                deptField.setText("");
                ageField.setText("");

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(frame,
                        ex);
            }
        });

        // ADD COMPONENTS
        frame.add(title);

        frame.add(idLabel);
        frame.add(nameLabel);
        frame.add(deptLabel);
        frame.add(ageLabel);

        frame.add(idField);
        frame.add(nameField);
        frame.add(deptField);
        frame.add(ageField);

        frame.add(addButton);

        // FRAME SETTINGS
        frame.setSize(400, 420);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
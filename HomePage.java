import javax.swing.*;
import java.awt.*;

public class HomePage {

    public static void main(String[] args) {

        // MAIN FRAME
        JFrame frame =
                new JFrame(
                        "College Management System");

        frame.getContentPane()
                .setBackground(
                        new Color(
                                240,
                                248,
                                255));

        // LOGO
        ImageIcon logo =
                new ImageIcon("logo.jpg");

        Image img =
                logo.getImage();

        Image scaledImg =
                img.getScaledInstance(
                        100,
                        100,
                        Image.SCALE_SMOOTH);

        ImageIcon scaledLogo =
                new ImageIcon(scaledImg);

        JLabel logoLabel =
                new JLabel(scaledLogo);

        logoLabel.setBounds(
                220,
                20,
                100,
                100);

        // COLLEGE NAME
        JLabel college =
                new JLabel(
                        "Dr. Sivanthi Aditanar College of Engineering",
                        SwingConstants.CENTER);

        college.setBounds(
                30,
                130,
                470,
                30);

        college.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22));

        college.setForeground(
                new Color(
                        0,
                        51,
                        102));

        // DEPARTMENT
        JLabel dept =
                new JLabel(
                        "Department of Artificial Intelligence and Data Science",
                        SwingConstants.CENTER);

        dept.setBounds(
                20,
                170,
                500,
                30);

        dept.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        16));

        dept.setForeground(
                new Color(
                        51,
                        51,
                        51));

        // TITLE
        JLabel title =
                new JLabel(
                        "STUDENT MANAGEMENT SYSTEM",
                        SwingConstants.CENTER);

        title.setBounds(
                50,
                240,
                430,
                40);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24));

        title.setForeground(
                new Color(
                        102,
                        0,
                        102));

        // ADMIN BUTTON
        JButton adminBtn =
                new JButton("Admin Login");

        adminBtn.setBounds(
                110,
                340,
                130,
                45);

        adminBtn.setBackground(
                new Color(
                        0,
                        102,
                        204));

        adminBtn.setForeground(
                Color.WHITE);

        // STAFF BUTTON
        JButton staffBtn =
                new JButton("Staff Login");

        staffBtn.setBounds(
                290,
                340,
                130,
                45);

        staffBtn.setBackground(
                new Color(
                        0,
                        153,
                        76));

        staffBtn.setForeground(
                Color.WHITE);

        // FOOTER
        JLabel footer =
                new JLabel(
                        "Developed by AI & DS Department",
                        SwingConstants.CENTER);

        footer.setBounds(
                120,
                430,
                300,
                30);

        // ================= ADMIN LOGIN =================

        adminBtn.addActionListener(e -> {

            JFrame loginFrame =
                    new JFrame("Admin Login");

            loginFrame.getContentPane()
                    .setBackground(
                            new Color(
                                    245,
                                    245,
                                    245));

            // USERNAME
            JLabel userLabel =
                    new JLabel("Username:");

            userLabel.setBounds(
                    40,
                    50,
                    100,
                    30);

            JTextField userField =
                    new JTextField();

            userField.setBounds(
                    140,
                    50,
                    140,
                    30);

            // PASSWORD
            JLabel passLabel =
                    new JLabel("Password:");

            passLabel.setBounds(
                    40,
                    110,
                    100,
                    30);

            JPasswordField passField =
                    new JPasswordField();

            passField.setBounds(
                    140,
                    110,
                    140,
                    30);

            // LOGIN BUTTON
            JButton loginBtn =
                    new JButton("Login");

            loginBtn.setBounds(
                    110,
                    180,
                    100,
                    35);

            loginBtn.setBackground(
                    new Color(
                            0,
                            102,
                            204));

            loginBtn.setForeground(
                    Color.WHITE);

            // LOGIN ACTION
            loginBtn.addActionListener(x -> {

                String username =
                        userField.getText();

                String password =
                        new String(
                                passField.getPassword());

                // ADMIN CHECK
                if(username.equals("admin")
                        &&
                        password.equals("1234")) {

                    JOptionPane.showMessageDialog(
                            loginFrame,
                            "Admin Login Successful!");

                    loginFrame.dispose();

                    // DASHBOARD
                    JFrame dashboard =
                            new JFrame(
                                    "Admin Dashboard");

                    dashboard.getContentPane()
                            .setBackground(
                                    new Color(
                                            245,
                                            245,
                                            245));

                    // TITLE
                    JLabel dashTitle =
                            new JLabel(
                                    "ADMIN DASHBOARD",
                                    SwingConstants.CENTER);

                    dashTitle.setBounds(
                            40,
                            30,
                            320,
                            40);

                    dashTitle.setFont(
                            new Font(
                                    "Arial",
                                    Font.BOLD,
                                    24));

                    dashTitle.setForeground(
                            new Color(
                                    0,
                                    51,
                                    102));

                    // BUTTONS
                    JButton addBtn =
                            new JButton("Add Student");

                    addBtn.setBounds(
                            60,
                            100,
                            140,
                            45);

                    addBtn.setBackground(
                            new Color(
                                    0,
                                    153,
                                    76));

                    addBtn.setForeground(
                            Color.WHITE);

                    JButton viewBtn =
                            new JButton("View Students");

                    viewBtn.setBounds(
                            220,
                            100,
                            140,
                            45);

                    viewBtn.setBackground(
                            new Color(
                                    0,
                                    102,
                                    204));

                    viewBtn.setForeground(
                            Color.WHITE);

                    JButton updateBtn =
                            new JButton("Update Student");

                    updateBtn.setBounds(
                            60,
                            170,
                            140,
                            45);

                    updateBtn.setBackground(
                            new Color(
                                    255,
                                    153,
                                    0));

                    updateBtn.setForeground(
                            Color.WHITE);

                    JButton deleteBtn =
                            new JButton("Delete Student");
                       deleteBtn.setBounds(
        220,
        170,
        140,
        45);    
        deleteBtn.setBackground(
        Color.RED);

deleteBtn.setForeground(
        Color.WHITE); 
                    JButton searchBtn = new JButton("Search Student");
searchBtn.setBounds(60, 240, 140, 45);
searchBtn.setBackground(
        new Color(
                128,
                0,
                128));

searchBtn.setForeground(
        Color.WHITE);

JButton attendanceBtn = new JButton("Attendance");
attendanceBtn.setBounds(220, 240, 140, 45);
attendanceBtn.setBackground(
        new Color(
                255,
                153,
                0));

attendanceBtn.setForeground(
        Color.WHITE);
JButton analyticsBtn = new JButton("Attendance Analytics");
analyticsBtn.setBounds(60, 310, 140, 45);
analyticsBtn.setBackground(
        new Color(
                0,
                153,
                153));

analyticsBtn.setForeground(
        Color.WHITE);
JButton marksBtn = new JButton("Marks Entry");
marksBtn.setBounds(220, 310, 140, 45);
marksBtn.setBackground(
        new Color(
                102,
                0,
                204));

marksBtn.setForeground(
        Color.WHITE);
JButton viewMarksBtn = new JButton("View Marks");
viewMarksBtn.setBounds(60, 380, 140, 45);
viewMarksBtn.setBackground(
        new Color(
                0,
                102,
                204));

viewMarksBtn.setForeground(
        Color.WHITE);
JButton reportBtn = new JButton("Report Card");
reportBtn.setBounds(220, 380, 140, 45);
reportBtn.setBackground(
        new Color(
                153,
                51,
                0));

reportBtn.setForeground(
        Color.WHITE);
JButton logoutBtn = new JButton("Logout");
logoutBtn.setBounds(140, 460, 140, 45);
logoutBtn.setBackground(
        Color.RED);

logoutBtn.setForeground(
        Color.WHITE);
                    

                    // BUTTON ACTIONS
                    addBtn.addActionListener(a -> {

                        AddStudentPage.main(null);
                    });

                    viewBtn.addActionListener(a -> {

                        ViewStudentsPage.main(null);
                    });

                    updateBtn.addActionListener(a -> {

                        UpdateStudentPage.main(null);
                    });

                    deleteBtn.addActionListener(a -> {

                        DeleteStudentPage.main(null);
                    });
                    searchBtn.addActionListener(a -> {
    SearchStudentPage.main(null);
});

attendanceBtn.addActionListener(a -> {
    SmartAttendancePage.main(null);
});

analyticsBtn.addActionListener(a -> {
    AttendancePercentagePage.main(null);
});

marksBtn.addActionListener(a -> {
    MarksEntryPage.main(null);
});

viewMarksBtn.addActionListener(a -> {
    ViewMarksPage.main(null);
});

reportBtn.addActionListener(a -> {
    ReportCardPage.main(null);
});

logoutBtn.addActionListener(a -> {
    dashboard.dispose();
});

                    // ADD COMPONENTS
                    dashboard.add(dashTitle);

                    dashboard.add(addBtn);

                    dashboard.add(viewBtn);

                    dashboard.add(updateBtn);

                    dashboard.add(deleteBtn);
                    dashboard.add(searchBtn);
                    dashboard.add(attendanceBtn);
                    dashboard.add(analyticsBtn);
                    dashboard.add(marksBtn);
                    dashboard.add(viewMarksBtn);
                    dashboard.add(reportBtn);
                    dashboard.add(logoutBtn);

                    // SETTINGS
                    dashboard.setSize(
                            450,
                            600);

                    dashboard.setLayout(null);

                    dashboard.setLocationRelativeTo(null);

                    dashboard.setVisible(true);

                    dashboard.setDefaultCloseOperation(
                            JFrame.DISPOSE_ON_CLOSE);

                } else {

                    JOptionPane.showMessageDialog(
                            loginFrame,
                            "Invalid Username or Password!");
                }
            });

            // ADD COMPONENTS
            loginFrame.add(userLabel);

            loginFrame.add(userField);

            loginFrame.add(passLabel);

            loginFrame.add(passField);

            loginFrame.add(loginBtn);

            // SETTINGS
            loginFrame.setSize(
                    350,
                    300);

            loginFrame.setLayout(null);

            loginFrame.setLocationRelativeTo(null);

            loginFrame.setVisible(true);

            loginFrame.setDefaultCloseOperation(
                    JFrame.DISPOSE_ON_CLOSE);
        });

        // ================= STAFF LOGIN =================

        staffBtn.addActionListener(e -> {

            JFrame staffLogin =
                    new JFrame("Staff Login");

            staffLogin.getContentPane()
                    .setBackground(
                            new Color(
                                    245,
                                    245,
                                    245));

            // USERNAME
            JLabel userLabel =
                    new JLabel("Username:");

            userLabel.setBounds(
                    40,
                    50,
                    100,
                    30);

            JTextField userField =
                    new JTextField();

            userField.setBounds(
                    140,
                    50,
                    140,
                    30);

            // PASSWORD
            JLabel passLabel =
                    new JLabel("Password:");

            passLabel.setBounds(
                    40,
                    110,
                    100,
                    30);

            JPasswordField passField =
                    new JPasswordField();

            passField.setBounds(
                    140,
                    110,
                    140,
                    30);

            // LOGIN BUTTON
            JButton loginBtn =
                    new JButton("Login");

            loginBtn.setBounds(
                    110,
                    180,
                    100,
                    35);

            loginBtn.setBackground(
                    new Color(
                            0,
                            153,
                            76));

            loginBtn.setForeground(
                    Color.WHITE);

            // LOGIN ACTION
            loginBtn.addActionListener(x -> {

                String username =
                        userField.getText();

                String password =
                        new String(
                                passField.getPassword());

                // STAFF LOGIN CHECK
                if(username.equals("staff")
                        &&
                        password.equals("123")) {

                    JOptionPane.showMessageDialog(
                            staffLogin,
                            "Staff Login Successful!");

                    staffLogin.dispose();

                    // STAFF DASHBOARD
                    JFrame staffDashboard =
                            new JFrame(
                                    "Staff Dashboard");

                    staffDashboard.getContentPane()
                            .setBackground(
                                    new Color(
                                            245,
                                            245,
                                            245));

                    // TITLE
                    JLabel staffTitle =
                            new JLabel(
                                    "STAFF DASHBOARD",
                                    SwingConstants.CENTER);

                    staffTitle.setBounds(
                            40,
                            30,
                            320,
                            40);

                    staffTitle.setFont(
                            new Font(
                                    "Arial",
                                    Font.BOLD,
                                    24));

                    staffTitle.setForeground(
                            new Color(
                                    0,
                                    153,
                                    76));

                    // VIEW BUTTON
                    JButton viewBtn =
                            new JButton(
                                    "View Students");

                    viewBtn.setBounds(
                            110,
                            120,
                            180,
                            45);

                    viewBtn.setBackground(
                            new Color(
                                    0,
                                    102,
                                    204));

                    viewBtn.setForeground(
                            Color.WHITE);

                    // ATTENDANCE BUTTON
                    JButton attendanceBtn =
                            new JButton(
                                    "Attendance");

                    attendanceBtn.setBounds(
                            110,
                            200,
                            180,
                            45);

                    attendanceBtn.setBackground(
                            new Color(
                                    255,
                                    153,
                                    0));

                    attendanceBtn.setForeground(
                            Color.WHITE);

                    // LOGOUT BUTTON
                    JButton logoutBtn =
                            new JButton(
                                    "Logout");

                    logoutBtn.setBounds(
                            110,
                            280,
                            180,
                            45);

                    logoutBtn.setBackground(
                            Color.RED);

                    logoutBtn.setForeground(
                            Color.WHITE);

                    // BUTTON ACTIONS
                    viewBtn.addActionListener(a -> {

                        ViewStudentsPage.main(null);
                    });

                    attendanceBtn.addActionListener(a -> {

                        JOptionPane.showMessageDialog(
                                staffDashboard,
                                "Attendance Module Coming Soon!");
                    });

                    logoutBtn.addActionListener(a -> {

                        staffDashboard.dispose();
                        HomePage.main(null);
                    });

                    // ADD COMPONENTS
                    staffDashboard.add(staffTitle);

                    staffDashboard.add(viewBtn);

                    staffDashboard.add(attendanceBtn);

                    staffDashboard.add(logoutBtn);

                    // SETTINGS
                    staffDashboard.setSize(
                            420,
                            450);

                    staffDashboard.setLayout(null);

                    staffDashboard.setLocationRelativeTo(null);

                    staffDashboard.setVisible(true);

                    staffDashboard.setDefaultCloseOperation(
                            JFrame.DISPOSE_ON_CLOSE);

                } else {

                    JOptionPane.showMessageDialog(
                            staffLogin,
                            "Invalid Username or Password!");
                }
            });

            // ADD COMPONENTS
            staffLogin.add(userLabel);

            staffLogin.add(userField);

            staffLogin.add(passLabel);

            staffLogin.add(passField);

            staffLogin.add(loginBtn);

            // SETTINGS
            staffLogin.setSize(
                    350,
                    300);

            staffLogin.setLayout(null);

            staffLogin.setLocationRelativeTo(null);

            staffLogin.setVisible(true);

            staffLogin.setDefaultCloseOperation(
                    JFrame.DISPOSE_ON_CLOSE);
        });

        // ADD MAIN COMPONENTS
        frame.add(logoLabel);

        frame.add(college);

        frame.add(dept);

        frame.add(title);

        frame.add(adminBtn);

        frame.add(staffBtn);

        frame.add(footer);

        // MAIN SETTINGS
        frame.setSize(
                550,
                520);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

        frame.setResizable(false);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
    }
}
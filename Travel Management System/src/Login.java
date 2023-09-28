import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login, signUp, password;
    JTextField tfusername, tfpassword;

    Login() {
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);

//        getContentPane().setBackground(Color.WHITE);


        // Left Side
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(0, 0, 400, 400);
        panel.setLayout(null);
        add(panel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        panel.add(image);

        // Right Side
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(400, 30, 450, 300);
        add(panel1);

        // Username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 20, 100, 25);
        lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        panel1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        panel1.add(tfusername);

        // Password
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 110, 100, 25);
        lblpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        panel1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(60, 150, 300, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        panel1.add(tfpassword);

        // Login Button
        login = new JButton("Login");
        login.setBounds(53, 200, 130, 30);
        login.setBackground(Color.BLUE);
        login.addActionListener(this);
        panel1.add(login);

        // SignUp
        signUp = new JButton("SignUp");
        signUp.setBounds(238, 200, 130, 30);
        signUp.setBackground(Color.BLUE);
        signUp.addActionListener(this);
        panel1.add(signUp);

        // Forget Password
        password = new JButton("Forget Password");
        password.setBounds(143, 250, 130, 30);
        password.setBackground(Color.BLUE);
        password.addActionListener(this);
        panel1.add(password);

        JLabel text = new JLabel("Trouble in login...");
        text.setBounds(300, 253, 150, 20);
        text.setForeground(Color.RED);
        panel1.add(text);

        setVisible(true);
    }

    public static void main(String[] args) {
        Login login = new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try {
                String username = tfusername.getText();
                String password1 = tfpassword.getText();

                String query = "select * from account where username = '"+username+"' AND password = '"+password1+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Loading(username);
                }else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username OR Password");
                }
            }catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == signUp) {
            setVisible(false);
            new SignUp();
        }else {
            setVisible(false);
            new ForgetPassword();
        }
    }
}

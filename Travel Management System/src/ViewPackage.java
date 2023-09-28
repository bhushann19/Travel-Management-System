import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewPackage extends JFrame implements ActionListener {

    JButton back;

    ViewPackage (String username) {

        setBounds(450, 200, 900, 625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(310, 0, 300, 20);
        add(text);

        JLabel lblusername = new JLabel("Username: ");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblpackage = new JLabel("Package: ");
        lblpackage.setBounds(30, 110, 150, 25);
        add(lblpackage);

        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220, 110, 150, 25);
        add(labelpackage);

        JLabel lblperson = new JLabel("Total Persons: ");
        lblperson.setBounds(30, 170, 150, 25);
        add(lblperson);

        JLabel labelperson = new JLabel();
        labelperson.setBounds(220, 170, 150, 25);
        add(labelperson);

        JLabel lblid = new JLabel("Id: ");
        lblid.setBounds(30, 230, 150, 25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220, 230, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number: ");
        lblnumber.setBounds(30, 290, 150, 25);
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 290, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone: ");
        lblphone.setBounds(30, 350, 150, 25);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(220, 350, 150, 25);
        add(labelphone);

        JLabel lbltotalprice = new JLabel("Total Price: ");
        lbltotalprice.setBounds(30, 410, 150, 25);
        add(lbltotalprice);

        JLabel labeltotalprice = new JLabel();
        labeltotalprice.setBounds(220, 410, 150, 25);
        add(labeltotalprice);

        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBounds(740, 550, 100, 25);
        back.addActionListener(this);
        add(back);

        try {
            Conn c = new Conn();
            String query = "select * from bookpackage where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("package"));
                labeltotalprice.setText(rs.getString("price"));
                labelperson.setText(rs.getString("person"));
                labelphone.setText(rs.getString("phone"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 510, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(375, 30, 500, 500);
        add(l11);



        setVisible(true);

    }

    public static void main(String[] args) {
        ViewPackage viewPackage = new ViewPackage("bhushan");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}

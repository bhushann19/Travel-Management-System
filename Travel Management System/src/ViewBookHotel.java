import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewBookHotel extends JFrame implements ActionListener {

    JButton back;

    ViewBookHotel(String username) {

        setBounds(450, 200, 1000, 625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(310, 0, 300, 20);
        add(text);

        JLabel lblusername = new JLabel("Username: ");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblhotelname = new JLabel("Hotel Name: ");
        lblhotelname.setBounds(30, 90, 150, 25);
        add(lblhotelname);

        JLabel labelhotelname = new JLabel();
        labelhotelname.setBounds(220, 90, 150, 25);
        add(labelhotelname);

        JLabel lblperson = new JLabel("Total Persons: ");
        lblperson.setBounds(30, 130, 150, 25);
        add(lblperson);

        JLabel labelperson = new JLabel();
        labelperson.setBounds(220, 130, 150, 25);
        add(labelperson);

        JLabel lbldays = new JLabel("Total Days: ");
        lbldays.setBounds(30, 170, 150, 25);
        add(lbldays);

        JLabel labeldays = new JLabel();
        labeldays.setBounds(220, 170, 150, 25);
        add(labeldays);

        JLabel lblac = new JLabel("AC/ Non-AC: ");
        lblac.setBounds(30, 210, 150, 25);
        add(lblac);

        JLabel labelac = new JLabel();
        labelac.setBounds(220, 210, 150, 25);
        add(labelac);

        JLabel lblfood = new JLabel("Food Included? ");
        lblfood.setBounds(30, 250, 150, 25);
        add(lblfood);

        JLabel labelfood = new JLabel();
        labelfood.setBounds(220, 250, 150, 25);
        add(labelfood);

        JLabel lblid = new JLabel("Id: ");
        lblid.setBounds(30, 290, 150, 25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220, 290, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number: ");
        lblnumber.setBounds(30, 330, 150, 25);
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 330, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone: ");
        lblphone.setBounds(30, 370, 150, 25);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(220, 370, 150, 25);
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
            String query = "select * from bookhotel where username = '" + username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelhotelname.setText(rs.getString("name"));
                labelperson.setText(rs.getString("persons"));
                labeldays.setText(rs.getString("days"));
                labelac.setText(rs.getString("ac"));
                labelfood.setText(rs.getString("food"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                labeltotalprice.setText(rs.getString("price"));
            }
        } catch (Exception e) {
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
        ViewBookHotel viewBookHotel = new ViewBookHotel("bhushan");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}


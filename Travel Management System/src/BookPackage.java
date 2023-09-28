import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {

    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labeltotalprice;
    JButton checkPrice, bookPackage, back;


    BookPackage (String username) {

        this.username = username;

        setBounds(350, 200, 1100, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username: ");
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblusername.setBounds(40, 70, 150, 20);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelusername.setBounds(250, 70, 150, 20);
        add(labelusername);

        JLabel lblpackage = new JLabel("Select Package: ");
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpackage.setBounds(40, 110, 150, 20);
        add(lblpackage);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250, 110, 150, 20);
        add(cpackage);

        JLabel lblperson = new JLabel("Total Person: ");
        lblperson.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblperson.setBounds(40, 150, 150, 20);
        add(lblperson);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 150, 20);
        add(tfpersons);

        JLabel lblid = new JLabel("Id: ");
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblid.setBounds(40, 190, 150, 20);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 190, 150, 20);
        add(labelid);

        JLabel lblnumber = new JLabel("Number: ");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnumber.setBounds(40, 230, 150, 20);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 230, 150, 20);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone: ");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblphone.setBounds(40, 270, 150, 20);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 270, 150, 20);
        add(labelphone);

        JLabel lbltotalprice = new JLabel("Total Price: ");
        lbltotalprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltotalprice.setBounds(40, 310, 150, 20);
        add(lbltotalprice);

        labeltotalprice = new JLabel();
        labeltotalprice.setBounds(250, 310, 150, 20);
        add(labeltotalprice);

        try {
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        checkPrice = new JButton("Check Price");
        checkPrice.setBounds(60, 380, 120, 25);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookPackage = new JButton("Book");
        bookPackage.setBounds(200, 380, 120, 25);
        bookPackage.addActionListener(this);
        add(bookPackage);

        back = new JButton("Back");
        back.setBounds(340, 380, 120, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(550, 80, 500, 300);
        add(l11);



        setVisible(true);
    }

    public static void main(String[] args) {
        BookPackage bookPackage = new BookPackage("bhushan");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkPrice) {
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if (pack.equals("Gold Package")){
                cost += 12000;
            } else if (pack.equals("Silver Package")) {
                cost += 24000;
            }else {
                cost += 32000;
            }

            /* There is bug here that is you can select negative number in person column*/
            int person = Integer.parseInt(tfpersons.getText());
            cost *= person;
            labeltotalprice.setText("Rs " + cost + "/-");

        } else if (e.getSource() == bookPackage) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"', '"+cpackage.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labeltotalprice.getText()+"')");

                JOptionPane.showMessageDialog(null, "Package Booked Successfully!");
                setVisible(false);
            }catch (Exception e1) {
                e1.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
}

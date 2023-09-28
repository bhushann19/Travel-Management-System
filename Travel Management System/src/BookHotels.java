import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookHotels extends JFrame implements ActionListener {

    Choice chotel, cac, cfood;
    JTextField tfpersons, tfdays;
    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labeltotalprice;
    JButton checkPrice, bookHotel, back;


    BookHotels(String username) {

        this.username = username;

        setBounds(350, 200, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK HOTEL");
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

        JLabel lblpackage = new JLabel("Select Hotel: ");
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpackage.setBounds(40, 110, 150, 20);
        add(lblpackage);

        chotel = new Choice();
        chotel.setBounds(250, 110, 200, 20);
        add(chotel);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while (rs.next()) {
                chotel.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblperson = new JLabel("Total Person: ");
        lblperson.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblperson.setBounds(40, 150, 150, 20);
        add(lblperson);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 150, 20);
        add(tfpersons);

        // Bug can select days in negative
        JLabel lbldays = new JLabel("No. of Days: ");
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbldays.setBounds(40, 190, 150, 20);
        add(lbldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 150, 20);
        add(tfdays);

        JLabel lblac = new JLabel("AC/ Non-AC: ");
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblac.setBounds(40, 230, 150, 20);
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 230, 200, 20);
        add(cac);

        JLabel lblfood = new JLabel("Include Food: ");
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblfood.setBounds(40, 270, 150, 20);
        add(lblfood);

        cfood = new Choice();
        cfood.add("YES");
        cfood.add("No");
        cfood.setBounds(250, 270, 200, 20);
        add(cfood);

        JLabel lblid = new JLabel("Id: ");
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblid.setBounds(40, 310, 150, 20);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 310, 150, 20);
        add(labelid);

        JLabel lblnumber = new JLabel("Number: ");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnumber.setBounds(40, 350, 150, 20);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 350, 150, 20);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone: ");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblphone.setBounds(40, 390, 150, 20);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 390, 150, 20);
        add(labelphone);

        JLabel lbltotalprice = new JLabel("Total Price: ");
        lbltotalprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltotalprice.setBounds(40, 430, 150, 20);
        add(lbltotalprice);

        labeltotalprice = new JLabel();
        labeltotalprice.setBounds(250, 430, 150, 20);
        add(labeltotalprice);

        try {
            Conn c = new Conn();
            String query = "select * from customer where username = '" + username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkPrice = new JButton("Check Price");
        checkPrice.setBounds(60, 500, 120, 25);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookHotel = new JButton("Book");
        bookHotel.setBounds(200, 500, 120, 25);
        bookHotel.addActionListener(this);
        add(bookHotel);

        back = new JButton("Back");
        back.setBounds(340, 500, 120, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(550, 80, 500, 300);
        add(l11);


        setVisible(true);
    }

    public static void main(String[] args) {
        BookHotels bookHotels = new BookHotels("bhushan");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkPrice) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '" + chotel.getSelectedItem() + "'");
                while (rs.next()) {
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodinluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));

                    int person = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());

                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();

                    if (person * ac > 0) {
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("YES") ? food : 0;
                        total += cost;
                        total = total * person * days;
                        labeltotalprice.setText("Rs " + total + "/-");
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number!");
                    }

                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        } else if (e.getSource() == bookHotel) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('" + labelusername.getText() + "', '" + chotel.getSelectedItem() + "', '" + tfpersons.getText() + "', '" + tfdays.getText() + "', '" + cac.getSelectedItem() + "', '" + cfood.getSelectedItem() + "', '" + labelid.getText() + "', '" + labelnumber.getText() + "', '" + labelphone.getText() + "', '" + labeltotalprice.getText() + "')");

                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully!");
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
}

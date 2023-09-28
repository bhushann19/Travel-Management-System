import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    String username;
    JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, checkPackages, bookPackages, viewPackages, viewHotels, destinations, bookHotels, viewBookedHotels, payments, deletePersonalDetails, calculate, notepad, about;

    Dashboard(String username) {

        this.username = username;

//        setBounds(0, 0, 1600, 1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(47, 79, 70));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(47, 79, 70));
        p2.setBounds(0, 65, 300, 900);
        add(p2);

        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0, 0, 304, 50);
        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addPersonalDetails.setMargin(new Insets(0, 0, 0, 65));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0, 50, 304, 50);
        updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        updatePersonalDetails.setMargin(new Insets(0, 0, 0, 36));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBounds(0, 100, 304, 50);
        viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPersonalDetails.setMargin(new Insets(0, 0, 0, 136));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        deletePersonalDetails = new JButton("Delete Account");
        deletePersonalDetails.setBounds(0, 150, 304, 50);
        deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deletePersonalDetails.setMargin(new Insets(0, 0, 0, 110));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        checkPackages = new JButton("Packages");
        checkPackages.setBounds(0, 200, 304, 50);
        checkPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkPackages.setMargin(new Insets(0, 0, 0, 164));
        checkPackages.addActionListener(this);
        p2.add(checkPackages);

        bookPackages = new JButton("Book Packages");
        bookPackages.setBounds(0, 250, 304, 50);
        bookPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookPackages.setMargin(new Insets(0, 0, 0, 115));
        bookPackages.addActionListener(this);
        p2.add(bookPackages);

        viewPackages = new JButton("View Packages");
        viewPackages.setBounds(0, 300, 304, 50);
        viewPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPackages.setMargin(new Insets(0, 0, 0, 115));
        viewPackages.addActionListener(this);
        p2.add(viewPackages);

        viewHotels = new JButton("Hotels");
        viewHotels.setBounds(0, 350, 304, 50);
        viewHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewHotels.setMargin(new Insets(0, 0, 0, 185));
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        bookHotels = new JButton("Book Hotels");
        bookHotels.setBounds(0, 400, 304, 50);
        bookHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookHotels.setMargin(new Insets(0, 0, 0, 135));
        bookHotels.addActionListener(this);
        p2.add(bookHotels);

        viewBookedHotels = new JButton("View Booked Hotels");
        viewBookedHotels.setBounds(0, 450, 304, 50);
        viewBookedHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewBookedHotels.setMargin(new Insets(0, 0, 0, 65));
        viewBookedHotels.addActionListener(this);
        p2.add(viewBookedHotels);

        destinations = new JButton("Destinations");
        destinations.setBounds(0, 500, 304, 50);
        destinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
        destinations.setMargin(new Insets(0, 0, 0, 130));
        destinations.addActionListener(this);
        p2.add(destinations);

        payments = new JButton("Payment");
        payments.setBounds(0, 550, 304, 50);
        payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
        payments.setMargin(new Insets(0, 0, 0, 162));
        payments.addActionListener(this);
        p2.add(payments);

        calculate = new JButton("Calculator");
        calculate.setBounds(0, 600, 304, 50);
        calculate.setFont(new Font("Tahoma", Font.PLAIN, 20));
        calculate.setMargin(new Insets(0, 0, 0, 153));
        calculate.addActionListener(this);
        p2.add(calculate);

        notepad = new JButton("Notepad");
        notepad.setBounds(0, 650, 304, 50);
        notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        notepad.setMargin(new Insets(0, 0, 0, 161));
        notepad.addActionListener(this);
        p2.add(notepad);

        about = new JButton("About");
        about.setBounds(0, 700, 304, 50);
        about.setFont(new Font("Tahoma", Font.PLAIN, 20));
        about.setMargin(new Insets(0, 0, 0, 185));
        about.addActionListener(this);
        p2.add(about);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1650, 1000);
        add(image);

        JLabel text = new JLabel("Travel And Tourism Management System");
        text.setBounds(400, 70, 1000, 70);
        text.setFont(new Font("raleway", Font.PLAIN, 50));
        image.add(text);


        setVisible(true);
    }

    public static void main(String[] args) {
        Dashboard dashboard = new Dashboard("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addPersonalDetails) {
            new AddCustomerDetails(username);
        } else if (e.getSource() == viewPersonalDetails) {
            new ViewCustomer(username);
        } else if (e.getSource() == updatePersonalDetails) {
            new UpdateCustomer(username);
        } else if (e.getSource() == checkPackages) {
            new CheckPackages();
        } else if (e.getSource() == bookPackages) {
            new BookPackage(username);
        } else if (e.getSource() == viewPackages) {
            new ViewPackage(username);
        } else if (e.getSource() == viewHotels) {
            new Hotels();
        } else if (e.getSource() == destinations) {
            new Destination();
        } else if (e.getSource() == bookHotels) {
            new BookHotels(username);
        } else if (e.getSource() == viewBookedHotels) {
            new ViewBookHotel(username);
        } else if (e.getSource() == payments) {
            new Payment();
        } else if (e.getSource() == calculate) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == notepad) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == about) {
            new About();
        } else if (e.getSource() == deletePersonalDetails) {
            new DeleteDetails(username);
        }
    }
}

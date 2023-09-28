import javax.swing.*;
import java.awt.*;

public class CheckPackages extends JFrame {

    CheckPackages () {

        setBounds(450, 200, 900, 600);

        String[] package1 = {"GOLD PACKAGE", "FACILITY:", "* 6 Days And 7 Nights", "* Airport Assistance", "* Half Day City Tour",
                "* Daily Buffet", "* Welcome Drinks On Arrival", "* Full Day 3 Island Cruise", "* Guide", "Rs 12000/-", "package1.jpg"};
        String[] package2 = {"SILVER PACKAGE", "FACILITY:", "* 5 Days And 6 Nights", "* Free Festival Tickets",
                "* Meet And Greet at Airport", "* Welcome Drinks on Arrival", "* Night Safari", "* Cruise with Dinner" , "* Guide", "Rs 24000/-", "package2.jpg"};
        String[] package3 = {"BRONZE PACKAGE", "FACILITY:", "* 6 Days And 5 Nights", "* Return Airfare", "* Free Clubbing, Horse Riding...",
                "* Hard Drinks Free", "* Daily Buffet" , "* BBQ Dinner", "* Guide", "Rs 32000/-", "package3.jpg"};

        JTabbedPane tab = new JTabbedPane();
        JPanel p1 = createPackage(package1);
        tab.addTab("Package 1", null, p1);

        JPanel p2 = createPackage(package2);
        tab.addTab("Package 2", null, p2);

        JPanel p3 = createPackage(package3);
        tab.addTab("Package 3", null, p3);

        add(tab);


        setVisible(true);

    }

    public JPanel createPackage (String[] pack) {

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);

        JLabel l1 =new JLabel(pack[0]);
        l1.setBounds(275, 15, 450, 50);
        l1.setForeground(new Color(255, 215, 0));
        l1.setFont(new Font("Tahoma", Font.BOLD, 40));
        p1.add(l1);

        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(30, 80, 300, 30);
        l2.setForeground(new Color(128, 0, 0));
        l2.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(l2);

        JLabel l3 =new JLabel(pack[2]);
        l3.setBounds(30, 115, 300, 30);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Tahoma", Font.BOLD, 18));
        p1.add(l3);

        JLabel l4 =new JLabel(pack[3]);
        l4.setBounds(30, 150, 300, 30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Tahoma", Font.BOLD, 18));
        p1.add(l4);

        JLabel l5 =new JLabel(pack[4]);
        l5.setBounds(30, 185, 300, 30);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Tahoma", Font.BOLD, 18));
        p1.add(l5);

        JLabel l6 =new JLabel(pack[5]);
        l6.setBounds(30, 220, 300, 30);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Tahoma", Font.BOLD, 18));
        p1.add(l6);

        JLabel l7 =new JLabel(pack[6]);
        l7.setBounds(30, 255, 300, 30);
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("Tahoma", Font.BOLD, 18));
        p1.add(l7);

        JLabel l8 =new JLabel(pack[7]);
        l8.setBounds(30, 290, 300, 30);
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("Tahoma", Font.BOLD, 18));
        p1.add(l8);

        JLabel l9 =new JLabel(pack[8]);
        l9.setBounds(30, 325, 300, 30);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("Tahoma", Font.BOLD, 18));
        p1.add(l9);

        JLabel l10 = new JLabel(pack[9]);
        l10.setBounds(350, 420, 300, 30);
        l10.setForeground(new Color(0, 0, 128));
        l10.setFont(new Font("Tahoma", Font.BOLD, 35));
        p1.add(l10);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/" + pack[10]));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(350, 80, 500, 300);
        p1.add(l11);

        return p1;

    }

    public static void main(String[] args) {
        CheckPackages checkPackages = new CheckPackages();
    }

}

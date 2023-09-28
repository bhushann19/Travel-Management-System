import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{

    Thread thread;
    Splash() {
        // To make frame.
        setSize(1200, 600);
        setLocation(150, 200);
        // To load splash.jpg
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/splash.jpg"));
        // To set image properly in Frame.
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        // Image i2 cannot be placed directly to JLabel so we have to convert i2 to ImageIcon to place it.
        ImageIcon i3 = new ImageIcon(i2);
        // To splash.jpg in Frame
        JLabel image = new JLabel(i3);
        add(image);
        // To make frame visible
        setVisible(true);

        thread = new Thread(this);
        thread.start(); // This start method calls run method internally.
        /* If we call run() method directly it will call the run() method but it will not behave as multithreaded function
          but as a normal function.
         */
        // run();
    }

    public void run() {
        try {
            Thread.sleep(3000);
            setVisible(false);
            new Login();
        }catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        Splash splash = new Splash();
    }

}

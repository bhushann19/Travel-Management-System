import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{

    Thread t;
    JProgressBar bar;
    String username;

    Loading (String username) {

        this.username = username;

        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Travel And Tourism Application");
        text.setBounds(40, 20, 600, 40);
        text.setForeground(new Color(102,51,0));
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(167, 100, 300, 35 );
        add(bar);

        JLabel loading = new JLabel("Loading...");
        loading.setBounds(267, 130, 150, 30);
        loading.setForeground(new Color(139,0,0));
        loading.setFont(new Font("Raleway", Font.BOLD, 16));
        add(loading);

        JLabel lblusername = new JLabel("Welcome " + username);
        lblusername.setBounds(20, 310, 400, 40);
        lblusername.setForeground(new Color(128,128,0));
        lblusername.setFont(new Font("Raleway", Font.BOLD, 16));
        add(lblusername);


        t = new Thread(this);
        t.start();


        setVisible(true);
    }

    public static void main(String[] args) {
        Loading loading = new Loading("");
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 101; i++) {
                int max = bar.getMaximum(); // 100
                int value = bar.getValue(); // current value

                if (value < max) {
                    bar.setValue(bar.getValue() + 1);
                }else {
                    setVisible(false);
                    new Dashboard(username);
                }

                Thread.sleep(30);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

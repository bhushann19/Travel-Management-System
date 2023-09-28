import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paytm extends JFrame implements ActionListener {

    Paytm () {
        setBounds(500, 200, 800, 600);


        /* Here we have to TextArea where we will load website.
        * To make TextArea we have two options (1) JTextArea and (2) JEditorPane
        * But if we use JTextArea their will be problem in adding scrollbar. */

        JEditorPane pane = new JEditorPane();
        /* It is easy to edit TextArea, so we have to disable editing.*/
        pane.setEditable(false);
        try {
            pane.setPage("https://tickets.paytm.com/flights/");
        }catch (Exception e) {
            pane.setContentType("text/html");
            pane.setText("<html>Could not load, Error 404</html>");
        }

        // To add scrollbar
        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);

        JButton back = new JButton("Back");
        back.setBounds(610, 20, 80, 40);
        back.addActionListener(this);
        pane.add(back);

        setVisible(true);


    }

    public static void main(String[] args) {
        Paytm paytm = new Paytm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Payment();
    }
}

import main.java.Controller;

import javax.accessibility.AccessibleContext;
import javax.swing.*;

public class View extends JFrame{
    public JPanel mainPanel;
    public JLabel tekst;



    public View(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

    }
    public JLabel getTekst() {
        return tekst;
    }

    public static void main(String[] args){

        JFrame frame = new View("Hej");
        AccessibleContext d = frame.getAccessibleContext();
        frame.setVisible(true);

        Controller controller = new Controller();



    }
}

package main.java;

import javax.accessibility.AccessibleContext;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyView extends JFrame {
    private JPanel mainPanel;
    public JLabel tekst;
    public JLabel currinput;
    private JTextField inputUser;


    public MyView(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();



        inputUser.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    Controller con = Controller.getInstance();
                    con.getUserWord(inputUser.getText());
                    inputUser.setText("");

                }

            }
        });

    }
    public JLabel getTekst() {
        return tekst;
    }

    public void setTekst(JLabel tekst) {
        this.tekst = tekst;
    }

    public static void main(String[] args){

        MyView frame = new MyView("Hej");


        frame.setVisible(true);

        Controller controller = Controller.getInstance();
        controller.setView(frame);
        controller.ini();


    }


}

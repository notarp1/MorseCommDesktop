package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainGUI extends JFrame {
    private JPanel panel1;
    public JLabel imgTest;
    private JTextField inputUser;
    public JLabel sentenceGUI;
    public JLabel currinput;


    public MainGUI(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        ImageIcon image = new ImageIcon(getClass().getResource("Icons/Mole.png"));
        imgTest.setIcon(image);

        this.getContentPane().setPreferredSize(new Dimension(1000,1000));
        imgTest.setPreferredSize(new Dimension(10,10));
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


    public static void main(String[] args){

        MainGUI frame = new MainGUI("MorzeCom");

        frame.setVisible(true);

        Controller controller = Controller.getInstance();
        controller.setView(frame);
        controller.ini();


    }
}
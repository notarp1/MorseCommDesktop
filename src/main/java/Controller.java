package main.java;

import com.studiohartman.jamepad.ControllerButton;
import com.studiohartman.jamepad.ControllerIndex;
import com.studiohartman.jamepad.ControllerManager;
import com.studiohartman.jamepad.ControllerUnpluggedException;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.Scanner;


public class Controller {

    ControllerManager controllers;
    StringBuilder morseLetter;
    ArrayList<Character> word;
    ControllerIndex currController;
    ArrayList<String> morseLetterSentence;
    Scanner sc;
    MyView view;

    public void setView(MyView view) {
        this.view = view;
    }

    private static Controller INSTANCE = null;
    private String info = "Initial info class";

    private Controller() {

    }

    public static Controller getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Controller();
        }

        return INSTANCE;
    }



    public void ini(){

        controllers = new ControllerManager();
        controllers.initSDLGamepad();
        morseLetter = new StringBuilder();
        word = new ArrayList<Character>();
        currController = controllers.getControllerIndex(0);
        morseLetterSentence = new ArrayList<>();
        sc = new Scanner(System.in);

        System.out.println("PRESS A FOR SHORT \nPRESS X FOR LONG \nPRESS Y TO ADD LETTER \nPRESS B TO SEND WORD");
        run();
    }



    private void run(){

        while (true) {
            while (true) {

                try {

                    if (currController.isButtonJustPressed(ControllerButton.A)) {
                        controllers.doVibration(0, 1, 1, 150);
                        morseLetter.append("S");

                    }
                    if (currController.isButtonJustPressed(ControllerButton.X)) {
                        controllers.doVibration(0, 1, 1, 400);
                        morseLetter.append("L");


                    }
                    if (currController.isButtonJustPressed(ControllerButton.B)) {

                        //PRINT ORD
                        StringBuilder f = new StringBuilder();
                        for (int j = 0; j < word.size(); j++) {
                            f.append(word.get(j));

                        }
                        String test = f.toString();

                        view.tekst.setText(test);
                        word = new ArrayList<>();
                        long timer = 0;

                        //ITERER OVER ORD OG GENSKAB I MORSE KODE
                        for (int j = 0; j < morseLetterSentence.size(); j++) {
                            System.out.println(morseLetterSentence.get(j));
                            String stringParse = morseLetterSentence.get(j);
                            if(j != 0) timer += 1000;
                            for (int k = 0; k < stringParse.length(); k++) {
                                timer += 1000;

                                if(stringParse.charAt(k) == 'S'){

                                    new java.util.Timer().schedule(
                                            new java.util.TimerTask() {
                                                @Override
                                                public void run() {
                                                    System.out.println("Short");
                                                    controllers.doVibration(0, 1, 1, 150);
                                                }
                                            },
                                            700 + timer
                                    );


                                } else if (stringParse.charAt(k) == 'L'){


                                    new java.util.Timer().schedule(
                                            new java.util.TimerTask() {
                                                @Override
                                                public void run() {

                                                    System.out.println("Long");
                                                    controllers.doVibration(0,1, 1, 400);
                                                }
                                            },
                                            500 + timer
                                    );
                                } else {
                                    System.out.println("SPACE");
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }

                        morseLetterSentence = new ArrayList<String>();



                    }
                    if (currController.isButtonJustPressed(ControllerButton.Y)) {

                        getWord();

                        break;

                    }

                } catch (ControllerUnpluggedException e) {
                    break;
                }
            }
        }
    }


    private void getWord() {
        String morseLetterCombination = morseLetter.toString();


        //PRINT OG TILFØJ BOGSTAV
        switch (morseLetterCombination){
            case "SL" :
                word.add('A');
                view.currinput.setText("A");
                System.out.print("A");
                break;
            case "LSSS" :
                word.add('B');
                view.currinput.setText("B");
                System.out.print("B");
                break;
            case "LSLS" :
                word.add('C');
                view.currinput.setText("C");
                System.out.print("C");
                break;
            case "LSS" :
                word.add('D');
                view.currinput.setText("D");
                System.out.print("D");
                break;
            case "S" :
                word.add('E');
                view.currinput.setText("E");
                System.out.print("E");
                break;
            case "SSLS" :
                word.add('F');
                view.currinput.setText("F");
                System.out.print("F");
                break;
            case "LLS" :
                word.add('G');
                view.currinput.setText("G");
                System.out.print("G");
                break;
            case "SSSS" :
                word.add('H');
                view.currinput.setText("H");
                System.out.print("H");
                break;
            case "SS" :
                word.add('I');
                view.currinput.setText("I");
                System.out.print("I");
                break;
            case "SLLL" :
                word.add('J');
                view.currinput.setText("J");
                System.out.print("J");
                break;
            case "LSL" :
                word.add('K');
                view.currinput.setText("K");
                System.out.print("K");
                break;
            case "SLSS" :
                word.add('L');
                view.currinput.setText("L");
                System.out.print("L");
                break;
            case "LL" :
                word.add('M');
                view.currinput.setText("M");
                System.out.print("M");
                break;
            case "LS" :
                word.add('N');
                view.currinput.setText("N");
                System.out.print("N");
                break;
            case "LLL" :
                word.add('O');
                view.currinput.setText("O");
                System.out.print("O");
                break;
            case "SLLS" :
                word.add('P');
                view.currinput.setText("P");
                System.out.print("P");
                break;
            case "LLSL" :
                word.add('Q');
                view.currinput.setText("Q");
                System.out.print("Q");
                break;
            case "SLS" :
                word.add('R');
                view.currinput.setText("R");
                System.out.print("R");
                break;
            case "SSS" :
                word.add('S');
                view.currinput.setText("S");
                System.out.print("S");
                break;
            case "L" :
                word.add('T');
                view.currinput.setText("T");
                System.out.print("T");
                break;
            case "SSL" :
                word.add('U');
                view.currinput.setText("U");
                System.out.print("U");
                break;
            case "SSSL" :
                word.add('V');
                view.currinput.setText("V");
                System.out.print("V");
                break;
            case "SLL" :
                word.add('W');
                view.currinput.setText("W");
                System.out.print("W");
                break;
            case "LSSL" :
                word.add('X');
                view.currinput.setText("X");
                System.out.print("X");
                break;
            case "LSLL" :
                word.add('Y');
                view.currinput.setText("Y");
                System.out.print("Y");
                break;
            case "LLSS" :
                word.add('Z');
                view.currinput.setText("Z");
                System.out.print("Z");
                break;
            default:
                morseLetterCombination = "";

        }

        //TILFØJ ORD OG NULSTIL ORD
        morseLetterSentence.add(morseLetterCombination);
        morseLetter.setLength(0);
    }

    public void getUserWord(String word){
        System.out.println(word);
        ArrayList<String> userWordPrint = new ArrayList<>();


        for (int i = 0; i < word.length(); i++) {
            Character s = word.charAt(i);
            switch (s){
                case ' ':
                    userWordPrint.add(".");
                    break;
                case 'a':
                    userWordPrint.add("SL");
                    break;
                case 'b':
                    userWordPrint.add("LSSS");
                    break;
                case 'c':
                    userWordPrint.add("LSLS");
                    break;
                case 'd':
                    userWordPrint.add("LSS");
                    break;
                case 'e':
                    userWordPrint.add("S");
                    break;
                case 'f':
                    userWordPrint.add("SSLS");
                    break;
                case 'g':
                    userWordPrint.add("LLS");
                    break;
                case 'h':
                    userWordPrint.add("SSSS");
                    break;
                case 'i':
                    userWordPrint.add("SS");
                    break;
                case 'j':
                    userWordPrint.add("SLLL");
                    break;
                case 'k':
                    userWordPrint.add("LSL");
                    break;

                case 'l':
                    userWordPrint.add("SLSS");
                    break;
                case 'm':
                    userWordPrint.add("LL");
                    break;
                case 'n':
                    userWordPrint.add("LS");
                    break;
                case 'o':
                    userWordPrint.add("LLL");
                    break;
                case 'p':
                    userWordPrint.add("SLLS");
                    break;
                case 'q':
                    userWordPrint.add("LLSL");
                    break;
                case 'r':
                    userWordPrint.add("SLS");
                    break;
                case 's':
                    userWordPrint.add("SSS");
                    break;
                case 't':
                    userWordPrint.add("L");
                    break;
                case 'u':
                    userWordPrint.add("SSL");
                    break;
                case 'v':
                    userWordPrint.add("SSSL");
                    break;
                case 'w':
                    userWordPrint.add("SLL");
                    break;
                case 'x':
                    userWordPrint.add("LSSL");
                    break;
                case 'y':
                    userWordPrint.add("LSLL");
                    break;
                case 'z':
                    userWordPrint.add("LLSS");
                    break;
            }

        }

        //Vibration
        long timer = 0;
        for (int i = 0; i < userWordPrint.size(); i++) {
            String decode = userWordPrint.get(i);
            if(i != 0) timer += 1000;
            //ITERER OVER ORD OG GENSKAB I MORSE KODE
            for (int j = 0; j < decode.length(); j++) {
                Character stringParse = decode.charAt(j);
                timer += 1000;

                if(stringParse == 'S'){
                    System.out.println("Short");
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    controllers.doVibration(0, 1, 1, 150);
                                }
                            },
                            500 + timer
                    );


                } else if (stringParse == 'L'){
                    System.out.println("Long");
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    controllers.doVibration(0,1, 1, 400);
                                }
                            },
                            500 + timer
                    );
                } else {
                    System.out.println("SPACE");
                    try {
                        Thread.sleep(1000);
                        timer -= 1000;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
    }
}

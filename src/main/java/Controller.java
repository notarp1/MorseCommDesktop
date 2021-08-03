package main.java;

import com.studiohartman.jamepad.ControllerButton;
import com.studiohartman.jamepad.ControllerIndex;
import com.studiohartman.jamepad.ControllerManager;
import com.studiohartman.jamepad.ControllerUnpluggedException;
import sun.plugin.com.JavaClass;

import javax.naming.Context;
import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Controller {

    ControllerManager controllers;
    StringBuilder word;
    ArrayList<Character> wordprint;
    ControllerIndex currController;
    ArrayList<String> fullword;
    Scanner sc;


    public Controller() {
        ini();

    }




    private void ini(){
        controllers = new ControllerManager();
        controllers.initSDLGamepad();
        word = new StringBuilder();
        wordprint = new ArrayList<Character>();
        currController = controllers.getControllerIndex(0);
        fullword = new ArrayList<>();
        sc = new Scanner(System.in);

        System.out.println("PRESS A FOR SHORT \nPRESS X FOR LONG \nPRESS Y TO ADD LETTER \nPRESS B TO SEND WORD");
        run();
    }

    private void run(){

        while (true) {
            while (true) {

                try {
                    if(currController.isButtonJustPressed(ControllerButton.DPAD_UP)){
                        System.out.println("Indtast besked");
                        String str = sc.nextLine();
                        System.out.println("Done");
                        getUserWord(str);


                    }
                    if (currController.isButtonJustPressed(ControllerButton.A)) {
                        controllers.doVibration(0, 1, 1, 150);
                        word.append("S");



                    }
                    if (currController.isButtonJustPressed(ControllerButton.X)) {
                        controllers.doVibration(0, 1, 1, 400);
                        word.append("L");


                    }
                    if (currController.isButtonJustPressed(ControllerButton.B)) {

                        //PRINT ORD
                        StringBuilder f = new StringBuilder();
                        for (int j = 0; j < wordprint.size(); j++) {
                            f.append(wordprint.get(j));
                        }
                        String test = f.toString();


                        wordprint = new ArrayList<>();
                        long timer = 0;

                        //ITERER OVER ORD OG GENSKAB I MORSE KODE
                        for (int j = 0; j < fullword.size(); j++) {
                            String stringParse = fullword.get(j);
                            timer += 1000;
                            for (int k = 0; k < stringParse.length(); k++) {


                                if(stringParse.charAt(k) == 'S'){
                                    new java.util.Timer().schedule(
                                            new java.util.TimerTask() {
                                                @Override
                                                public void run() {
                                                    controllers.doVibration(0, 1, 1, 150);
                                                }
                                            },
                                            500 + timer
                                    );


                                } else {

                                    new java.util.Timer().schedule(
                                            new java.util.TimerTask() {
                                                @Override
                                                public void run() {
                                                    controllers.doVibration(0,1, 1, 400);
                                                }
                                            },
                                            500 + timer
                                    );
                                }
                            }
                        }

                        fullword = new ArrayList<String>();



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
    private void getUserWord(String word){
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

        long timer = 0;
        for (int i = 0; i < userWordPrint.size(); i++) {
            String decode = userWordPrint.get(i);



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
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            timer += 1000;

        }
    }

    private void getWord() {
        String ord = word.toString();
        //PRINT OG TILFØJ BOGSTAV
        switch (ord){
            case "SL" :
                wordprint.add('A');
                System.out.print("A");
                break;
            case "LSSS" :
                wordprint.add('B');
                System.out.print("B");
                break;
            case "LSLS" :
                wordprint.add('C');
                System.out.print("C");
                break;
            case "LSS" :
                wordprint.add('D');
                System.out.print("D");
                break;
            case "S" :
                wordprint.add('E');
                System.out.print("E");
                break;
            case "SSLS" :
                wordprint.add('F');
                System.out.print("F");
                break;
            case "LLS" :
                wordprint.add('G');
                System.out.print("G");
                break;
            case "SSSS" :
                wordprint.add('H');
                System.out.print("H");
                break;
            case "SS" :
                wordprint.add('I');
                System.out.print("I");
                break;
            case "SLLL" :
                wordprint.add('J');
                System.out.print("J");
                break;
            case "LSL" :
                wordprint.add('K');
                System.out.print("K");
                break;
            case "SLSS" :
                wordprint.add('L');
                System.out.print("L");
                break;
            case "LL" :
                wordprint.add('M');
                System.out.print("M");
                break;
            case "LS" :
                wordprint.add('N');
                System.out.print("N");
                break;
            case "LLL" :
                wordprint.add('O');
                System.out.print("O");
                break;
            case "SLLS" :
                wordprint.add('P');
                System.out.print("P");
                break;
            case "LLSL" :
                wordprint.add('Q');
                System.out.print("Q");
                break;
            case "SLS" :
                wordprint.add('R');
                System.out.print("R");
                break;
            case "SSS" :
                wordprint.add('S');
                System.out.print("S");
                break;
            case "L" :
                wordprint.add('T');
                System.out.print("T");
                break;
            case "SSL" :
                wordprint.add('U');
                System.out.print("U");
                break;
            case "SSSL" :
                wordprint.add('V');
                System.out.print("V");
                break;
            case "SLL" :
                wordprint.add('W');
                System.out.print("W");
                break;
            case "LSSL" :
                wordprint.add('X');
                System.out.print("X");
                break;
            case "LSLL" :
                wordprint.add('Y');
                System.out.print("Y");
                break;
            case "LLSS" :
                wordprint.add('Z');
                System.out.print("Z");
                break;

        }

        //TILFØJ ORD OG NULSTIL ORD
        fullword.add(ord);
        word.setLength(0);
    }

}

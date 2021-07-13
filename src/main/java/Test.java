package main.java;


import com.studiohartman.jamepad.*;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) throws ControllerUnpluggedException {
        ControllerManager controllers = new ControllerManager();
        controllers.initSDLGamepad();




        StringBuilder word = new StringBuilder();
        ArrayList<Character> wordprint = new ArrayList<Character>();
        ControllerIndex currController = controllers.getControllerIndex(0);
        ArrayList<String> fullword = new ArrayList<>();


        System.out.println("PRESS A FOR SHORT \nPRESS X FOR LONG \nPRESS Y TO ADD LETTER \nPRESS B TO SEND WORD");
        while (true) {
            while (true) {

                try {
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
                        System.out.println();
                        for (int j = 0; j < wordprint.size(); j++) {
                            System.out.print(wordprint.get(j));

                        }
                        System.out.println();

                        wordprint = new ArrayList<Character>();

                        //ITERER OVER ORD OG GENSKAB I MORSE KODE
                        for (int j = 0; j < fullword.size(); j++) {
                            String stringParse = fullword.get(j);

                            for (int k = 0; k < stringParse.length(); k++) {

                                if(stringParse.charAt(k) == 'S'){
                                    //controllers.doVibration(0, 1, 1, 150);

                                } else {
                                    System.out.println("HA2HA");
                                    //controllers.doVibration(0,1, 1, 400);
                                }


                            }

                        }

                    fullword = new ArrayList<String>();



                    }
                    if (currController.isButtonJustPressed(ControllerButton.Y)) {

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

                        break;

                    }

                } catch (ControllerUnpluggedException e) {
                    break;
                }
            }
        }

    }



}

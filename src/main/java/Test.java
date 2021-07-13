package main.java;


import com.studiohartman.jamepad.*;

import java.util.ArrayList;

public class Test {


    public Test(){}




    public static void main(String[] args) throws ControllerUnpluggedException {
        ControllerManager controllers = new ControllerManager();
        controllers.initSDLGamepad();




        StringBuilder word = new StringBuilder();
        ArrayList<Character> wordprint = new ArrayList<Character>();
        ControllerIndex currController = controllers.getControllerIndex(0);
        Test test = new Test();
        int i = 0;

        while (true) {
            while (true) {

                try {
                    if (currController.isButtonJustPressed(ControllerButton.A)) {
                        controllers.doVibration(0, 1, 1, 200);
                        word.append("S");



                    }
                    if (currController.isButtonJustPressed(ControllerButton.X)) {
                        controllers.doVibration(0, 1, 1, 500);
                        word.append("L");


                    }

                    if (currController.isButtonJustPressed(ControllerButton.Y)) {

                        String ord = word.toString();

                        switch (ord){
                            case "SL" :
                                wordprint.add('A');
                                break;
                            case "LSSS" :
                                wordprint.add('B');
                                break;
                            case "LSLS" :
                                wordprint.add('C');
                                break;
                            case "LSS" :
                                wordprint.add('D');
                                break;
                            case "S" :
                                wordprint.add('E');
                                break;
                            case "SSLS" :
                                wordprint.add('F');
                                break;
                            case "LLS" :
                                wordprint.add('G');
                                break;
                            case "SSSS" :
                                wordprint.add('H');
                                break;
                            case "SS" :
                                wordprint.add('I');
                                break;
                            case "SLLL" :
                                wordprint.add('J');
                                break;
                            case "LSL" :
                                wordprint.add('K');
                                break;
                        }

                        word.setLength(0);

                        break;

                    }
                    if (currController.isButtonJustPressed(ControllerButton.B)) {

                        for (int j = 0; j < wordprint.size(); j++) {
                            System.out.print(wordprint.get(j));

                        }
                        wordprint = new ArrayList<Character>();


                    }
                } catch (ControllerUnpluggedException e) {
                    break;
                }
            }
        }






    }



}

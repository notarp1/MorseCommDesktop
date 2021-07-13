package main.java;


import com.studiohartman.jamepad.*;

import java.util.ArrayList;

public class Test {


    public Test(){}

    boolean lockc = true;

    public void setLockc(boolean lockc) {
        this.lockc = lockc;
    }

    public boolean getLockc(){
        return lockc;
    }



    public static void main(String[] args) throws ControllerUnpluggedException {
        ControllerManager controllers = new ControllerManager();
        controllers.initSDLGamepad();
        boolean locka = true;
        boolean lockb = true;



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
                    if (currController.isButtonJustPressed(ControllerButton.B)) {
                        for (int j = 0; j < wordprint.size(); j++) {
                            System.out.print(wordprint.get(j));

                        }
                        wordprint = new ArrayList<Character>();


                    }
                    if (currController.isButtonJustPressed(ControllerButton.Y)) {

                        if ("SL".contentEquals(word)) {
                            wordprint.add('A');
                            System.out.println("APPENDED CHARACTER A");
                        } else if ("S".contentEquals(word)) {
                            wordprint.add('E');
                            System.out.println("APPENDED CHARACTER E");
                        } else if ("L".contentEquals(word)) {
                            System.out.println("APPENDED CHARACTER T");
                            wordprint.add('T');
                        }
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

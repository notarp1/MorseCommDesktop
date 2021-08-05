package main.java;

import com.studiohartman.jamepad.ControllerButton;
import com.studiohartman.jamepad.ControllerIndex;
import com.studiohartman.jamepad.ControllerManager;
import com.studiohartman.jamepad.ControllerUnpluggedException;

import java.util.ArrayList;


public class Controller {

    private ControllerManager controllers;
    private StringBuilder morseLetter;
    private ArrayList<Character> word;
    private ControllerIndex currController;
    private ArrayList<String> morseLetterSentence;
    private Decoder decoder;
    private MyView view;

    private static Controller INSTANCE = null;


    private Controller() {}

    static Controller getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Controller();
        }

        return INSTANCE;
    }

    /** Method for setting the view from the MyView.java class */
    void setView(MyView view) {
        this.view = view;
    }

    /** Method for initiating value */
    void ini(){
        decoder = Decoder.getInstance();
        controllers = new ControllerManager();
        controllers.initSDLGamepad();
        morseLetter = new StringBuilder();
        word = new ArrayList<>();
        currController = controllers.getControllerIndex(0);
        morseLetterSentence = new ArrayList<>();

        System.out.println("PRESS A FOR SHORT \nPRESS X FOR LONG \nPRESS Y TO ADD LETTER \nPRESS B TO SEND WORD");
        run();
    }


    /**
     * Method that listens for key-events from the controller
     */
    private void run(){
        while (true) {
            while (true) {

                try {
                    /* If button A is pressed append S for short to the morse-letter */
                    if (currController.isButtonJustPressed(ControllerButton.A)) {
                        controllers.doVibration(0, 1, 1, 150);
                        morseLetter.append("S");

                    }
                    /* If button X is pressed append L for long to the morse-letter */
                    if (currController.isButtonJustPressed(ControllerButton.X)) {
                        controllers.doVibration(0, 1, 1, 400);
                        morseLetter.append("L");
                    }

                    /* If button Y is pressed add the letter to the total sentence with the method addLetter() */
                    if (currController.isButtonJustPressed(ControllerButton.Y)) {
                        addLetter();
                        break;
                    }
                    /* If button B is pressed display word to GUI, vibrate word to user */
                    if (currController.isButtonJustPressed(ControllerButton.B)) {

                        //Convert Character array to String
                        StringBuilder wordToDisplay = new StringBuilder();
                        for (Character character : word) wordToDisplay.append(character);
                        view.tekst.setText(wordToDisplay.toString());

                        //Reset word array, so a new word can be entered
                        word = new ArrayList<>();

                        //Set timer to zero, timer is used to output vibration in the correct order
                        long timer = 0;

                        //Iterate over the morse-letter sentence, to recreate the word as vibrations
                        for (int j = 0; j < morseLetterSentence.size(); j++) {
                            String morseToParse = morseLetterSentence.get(j);

                            //Add delay after each letter
                            if(j != 0) timer += 1000;

                            for (int k = 0; k < morseToParse.length(); k++) {
                                timer += 1000;

                                if(morseToParse.charAt(k) == 'S'){
                                    System.out.println("Short");
                                    vibrate(timer, 700, 150);

                                } else if (morseToParse.charAt(k) == 'L'){
                                    System.out.println("Long");
                                    vibrate(timer, 500, 400);
                                }
                            }
                        }
                        morseLetterSentence = new ArrayList<>();
                    }


                } catch (ControllerUnpluggedException e) {
                    break;
                }
            }
        }
    }


    /**
     * Method that handles controller vibration
     * @param timer what value to be added after each vibration iteration
     * @param inival start delay for vibration
     * @param duration how long the controller should vibrate
     */
    private void vibrate(long timer, long inival, int duration) {
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        controllers.doVibration(0, 1, 1, duration);
                    }
                },
                inival + timer
        );
    }

    /**
     * Method which adds one letter to a sentence, from the user.
     */

    private void addLetter() {

        //Convert StringBuilder to String
        String morseLetterCombination = morseLetter.toString();


        //Decode one morse-letter combination to an alphabet letter
        word = decoder.decodeMorse(morseLetterCombination, word, view);

        //Add the morse-letter combination to a String array, for future vibration feedback of the written word.
        morseLetterSentence.add(morseLetterCombination);

        //Reset the morse-letter, so a new one can be written
        morseLetter.setLength(0);
    }

    /**
     * Method which handles a sentence written from a keyboard to the program
     * @param sentenceInput the word which the user has entered
     */
    public void getUserWord(String sentenceInput){

        ArrayList<String> textToMorse = new ArrayList<>();

        //Decode the sentence and convert
        textToMorse = decoder.decodeText(sentenceInput, textToMorse);


        //Initialize timer
        long timer = 0;

        //Same process as in line 93
        for (int i = 0; i < textToMorse.size(); i++) {
            String decode = textToMorse.get(i);
            if(i != 0) timer += 1000;

            //ITERER OVER ORD OG GENSKAB I MORSE KODE
            for (int j = 0; j < decode.length(); j++) {
                Character stringParse = decode.charAt(j);
                timer += 1000;

                if(stringParse == 'S'){
                    System.out.println("Short");
                    vibrate(timer, 700, 150);

                } else if (stringParse == 'L'){
                    System.out.println("Long");
                    vibrate(timer, 500, 400);

                } else {  //If there is a space in the sentence, have a 1 second break
                    System.out.println("SPACE");
                    try {
                        Thread.sleep(1000);
                        //Compensate the 1 second wait, by detracting 1000ms from the timer
                        timer -= 1000;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

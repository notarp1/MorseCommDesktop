package main.java;

import java.util.ArrayList;

public class Decoder {
    private static Decoder INSTANCE = null;

    private Decoder() {
    }

    static Decoder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Decoder();
        }

        return INSTANCE;
    }


    /**
     * Method that converts morse-input to real letters
     * @param morseLetterCombination the combination of morse letter to decode.
     * @param word an array consisting of characters, which a letter is added to, to make out a word in the end.
     * @param view reference to the GUI, to update and display words.
     * @return returns the word array, which has been updated
     */
    ArrayList<Character> decodeMorse(String morseLetterCombination, ArrayList<Character> word, MainGUI view) {
        switch (morseLetterCombination) {
            case "SL":
                word.add('A');
                view.currinput.setText("A");
                System.out.print("A");
                break;
            case "LSSS":
                word.add('B');
                view.currinput.setText("B");
                System.out.print("B");
                break;
            case "LSLS":
                word.add('C');
                view.currinput.setText("C");
                System.out.print("C");
                break;
            case "LSS":
                word.add('D');
                view.currinput.setText("D");
                System.out.print("D");
                break;
            case "S":
                word.add('E');
                view.currinput.setText("E");
                System.out.print("E");
                break;
            case "SSLS":
                word.add('F');
                view.currinput.setText("F");
                System.out.print("F");
                break;
            case "LLS":
                word.add('G');
                view.currinput.setText("G");
                System.out.print("G");
                break;
            case "SSSS":
                word.add('H');
                view.currinput.setText("H");
                System.out.print("H");
                break;
            case "SS":
                word.add('I');
                view.currinput.setText("I");
                System.out.print("I");
                break;
            case "SLLL":
                word.add('J');
                view.currinput.setText("J");
                System.out.print("J");
                break;
            case "LSL":
                word.add('K');
                view.currinput.setText("K");
                System.out.print("K");
                break;
            case "SLSS":
                word.add('L');
                view.currinput.setText("L");
                System.out.print("L");
                break;
            case "LL":
                word.add('M');
                view.currinput.setText("M");
                System.out.print("M");
                break;
            case "LS":
                word.add('N');
                view.currinput.setText("N");
                System.out.print("N");
                break;
            case "LLL":
                word.add('O');
                view.currinput.setText("O");
                System.out.print("O");
                break;
            case "SLLS":
                word.add('P');
                view.currinput.setText("P");
                System.out.print("P");
                break;
            case "LLSL":
                word.add('Q');
                view.currinput.setText("Q");
                System.out.print("Q");
                break;
            case "SLS":
                word.add('R');
                view.currinput.setText("R");
                System.out.print("R");
                break;
            case "SSS":
                word.add('S');
                view.currinput.setText("S");
                System.out.print("S");
                break;
            case "L":
                word.add('T');
                view.currinput.setText("T");
                System.out.print("T");
                break;
            case "SSL":
                word.add('U');
                view.currinput.setText("U");
                System.out.print("U");
                break;
            case "SSSL":
                word.add('V');
                view.currinput.setText("V");
                System.out.print("V");
                break;
            case "SLL":
                word.add('W');
                view.currinput.setText("W");
                System.out.print("W");
                break;
            case "LSSL":
                word.add('X');
                view.currinput.setText("X");
                System.out.print("X");
                break;
            case "LSLL":
                word.add('Y');
                view.currinput.setText("Y");
                System.out.print("Y");
                break;
            case "LLSS":
                word.add('Z');
                view.currinput.setText("Z");
                System.out.print("Z");
                break;
            default:
                break;
        }
        return word;
    }

    /**
     * Method that converts real letters to morse-output
     * @param word is a String or sentence, which is decoded to morse-code in the for-loop.
     * @param userWordPrint is a String array, which inserts the morse-combinations for each letter in the array.
     * @return return the arraylist with the decoded morse code.
     */
    ArrayList<String> decodeText(String word, ArrayList<String> userWordPrint) {

        for (int i = 0; i < word.length(); i++) {
            Character s = word.charAt(i);
            switch (s) {
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
        return userWordPrint;

    }
}

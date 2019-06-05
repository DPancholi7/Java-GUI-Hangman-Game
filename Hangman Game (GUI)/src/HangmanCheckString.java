/*
Author: Dhvani Pancholi
Date: June 1st 2018
Description : This Class Controls The Programs Fundamental Function. This Class Stores, Updates And Clears Out Important
Information Needed To Run The Application Smoothly
 */
// Loading Directories/Packages
import javax.swing.*;
import java.util.Arrays;
import java.util.Random;



public class HangmanCheckString {

    // Global variables
    public  String[] hangmanWords = {""};
    public String hangmanTemp;
    public char[] hangmanBlank = {'-','-','-','-','-','-','-','-','-','-',
            '-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-',};
    public char[] hangmanLetters;
    public char[] usedLetterList = {'-','-','-','-','-','-','-','-','-','-',
            '-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-',};
    char[]  charArray;
    char[] charArrayTest;
    boolean winOrLoose;
    boolean wrongChoice;
    int wrongGuess;
    boolean usedLetter;
    Random r;

    public void chooseWord() {
        r = new Random(); // Used to Randomize Words

        JOptionPane dialog = new JOptionPane();  // Declares new JOptionPane
          JOptionPane.showMessageDialog(dialog, "Welcome To My Hangman Game!"); // Introduction Dialog Message

            JOptionPane.showMessageDialog(dialog, " INSTRUCTIONS\n " + // Instructions Dialog
                    " 1. Pick A Category, The Hidden Words Will Be Associated With The Category You Have Chosen\n" +
                    " 2. Click On The Letters Displayed On The Graphical User Interface To Choose Which Letter You Would Like To Guess\n " +
                    " 3. You Have 6 Attempts To Guess The Correct Word, You Have The Option To Play The Game Again If You Win/Lose The Game");


        String[] choices = { "Countries", "Animals", "Languages", "School Subjects", "Food", "Sports" }; // Categories To Choose From
        String input = (String) JOptionPane.showInputDialog(dialog, "Choose one of the following categories",
                "Categories", JOptionPane.PLAIN_MESSAGE, null, // Use
                choices, // Array of choices
                choices[0]); // Initial choice

        // If Statements are used here to separate the words depending on which category the user chooses
        if(input == "School Subjects") { // First Category Is School Subjects

             hangmanWords = new String[] {"mathematics", "physics","chemistry","biology",
                    "history","robotics","drama","psychology","geography"}; // Random School Subjects


        }
        if(input == "Animals") {

            hangmanWords = new String[]{"monkey", "lion", "snake", "wolf", "giraffe", "zebra", "turtle", "horse",
                    "armadillo", "eagle" // Random Animals

            };
        }
              if( input == "Languages") {

                hangmanWords = new String[] { "english","french","spanish","hindi","chinese","german","italian","arabic"
                }; // Random Languages

            }
            if(input == "Countries") {

                hangmanWords = new String[]{"canada", "kenya", "mexico", "jamaica", "brazil", "argentina", "chile", "india",
                        "zambia", "france", "germany", "italy", "australia", "spain", "chad" // Random Countries
                };


            }
            if(input == "Food") {

                hangmanWords = new String[] { "pasta","pizza","fries","burrito","spaghetti","taco","bagel","sandwich" // Random Food Items

                };
            }
            if(input == "Sports") {
                hangmanWords = new String[] { "basketball","soccer","cricket","frisbee","baseball","squash","croquet","football","golf" // Random Sports

                };
            }


        // choosse a word from the list of words
        hangmanTemp = hangmanWords[r.nextInt(hangmanWords.length)]; // Hangman Words Are Randomized
        charArrayTest = hangmanTemp.toCharArray();
        hangmanLetters = hangmanTemp.toCharArray();
        charArray = hangmanTemp.toCharArray();
        for(int i = 0;i < charArray.length;i++){ // Loop That States, The program Will Run Untill The Right Word Is Guessed
            charArrayTest[i]=hangmanBlank[i];
            hangmanLetters[i]=hangmanBlank[i]; // Transfers The Letters To The Blanks
        }


    }
    public void checkWord(char ch){
        // Declared Variables
        usedLetter= false;
        wrongChoice = false;
        char c = '-';
        int temp =0;
        for(int i = 0;i < charArray.length;i++){ // For Loop Used For Making Sure The Letters Fill In The Right Blanks
            if(charArray[i] == ch){
                hangmanLetters[i] = ch;
            }
        }
        for(int i = 0;i < usedLetterList.length;i++){ // Loop To Track The UsedLetters
            if(usedLetterList[i] == ch){
                usedLetter = true; // Makes Sure Used Letters Are Not Used Twice (as a guess)
            }
        }


        for(int i = 0;i < charArray.length;i++){ // Loop Used To Track The Wrong Choices
            if(charArray[i] == ch && wrongChoice == false){
                wrongChoice = true;
            }
        }
        if(usedLetter == false){ // Conditions If UsedLetters == false
            for(int i = 0;i < usedLetterList.length;i++){
                if(usedLetterList[i] == c){ // If The UsedLetters Variable = False, Than Clicking the Same Letter Would Result In Multiple Incorrect Guesses
                    temp = i;
                    break;
                }
            }
            usedLetterList[temp] = ch;
        }
        if(wrongChoice == false){
            wrongGuess = wrongGuess + 1;
            if(usedLetter == true){ // UsedLetters = True, Meaning The Same Letter Clicked Wont Result In Multiple Incorrect Guesses
                wrongGuess = wrongGuess - 1;
            }
        }
        winOrLoose = Arrays.equals(charArray,hangmanLetters); // This Makes Sure If The Word Fits The Blanks And The Correct Letters
    }

}
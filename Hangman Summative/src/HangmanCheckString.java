import javax.swing.*;
import java.util.Arrays;
import java.util.Random;



public class HangmanCheckString {

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
        r = new Random();
        JOptionPane intro = new JOptionPane();
        JOptionPane.showMessageDialog(intro, "Welcome To My Hangman Game!"); // Introduction Dialog Message
        String[] choices = { "Provinces And Territories", "Animals", "Languages", "Countries", "Movies", "Sports" };
        String input = (String) JOptionPane.showInputDialog(null, "Choose one of the following",
                "Categories", JOptionPane.QUESTION_MESSAGE, null, // Use
                // default
                // icon

                choices, // Array of choices
                choices[0]); // Initial choice
        System.out.println(input);
        if(input == "Provinces And Territories") {

             hangmanWords = new String[] {"british_columbia", "newfoundland and labrador","ontario","quebec",
                    "manitoba","alberta","nova scotia","new brunswick","prince edward island"};


        }
        if(input == "Animals") {

            hangmanWords = new String[]{"monkey", "lion", "snake", "wolf", "giraffe", "zebra", "turtle", "horse",
                    "armadillo", "eagle"

            };
        }
              if( input == "Languages") {

                hangmanWords = new String[] { "english","french","spanish","hindi","chinese","german","italian","arabic"
                };

            }
            if(input == "Countries") {

                hangmanWords = new String[]{"canada", "united states of america", "mexico", "jamaica", "brazil", "argentina", "chile", "india",
                        "zambia", "france", "germany", "italy", "australia", "spain", "chad"
                };


            }
            if(input == "Movies") {

                hangmanWords = new String[] { "titanic","jurassic world","harry potter","star wars","avatar","avengers","deadpool"

                };
            }
            if(input == "Sports") {
                hangmanWords = new String[] { "basketball","soccer","cricket","frisbee","baseball","squash","croquet","football","golf"

                };
            }


        // choose a word from the list of words
        hangmanTemp = hangmanWords[r.nextInt(hangmanWords.length)];
        charArrayTest = hangmanTemp.toCharArray();
        hangmanLetters = hangmanTemp.toCharArray();
        charArray = hangmanTemp.toCharArray();
        for(int i = 0;i < charArray.length;i++){
            charArrayTest[i]=hangmanBlank[i];
            hangmanLetters[i]=hangmanBlank[i];
        }


    }
    public void checkWord(char ch){
        usedLetter= false;
        wrongChoice = false;
        char c = '-';
        int temp =0;
        for(int i = 0;i < charArray.length;i++){
            if(charArray[i] == ch){
                hangmanLetters[i] = ch;
            }
        }
        for(int i = 0;i < usedLetterList.length;i++){
            if(usedLetterList[i] == ch){
                usedLetter = false;
            }
        }


        for(int i = 0;i < charArray.length;i++){
            if(charArray[i] == ch && wrongChoice == false){
                wrongChoice = true;
            }
        }
        if(usedLetter == false){
            for(int i = 0;i < usedLetterList.length;i++){
                if(usedLetterList[i] == c){
                    temp = i;
                    break;
                }
            }
            usedLetterList[temp] = ch;
        }
        if(wrongChoice == false){
            wrongGuess = wrongGuess + 1;
            if(usedLetter == true){
                wrongGuess = wrongGuess - 1;
            }
        }
        winOrLoose = Arrays.equals(charArray,hangmanLetters);
    }

}
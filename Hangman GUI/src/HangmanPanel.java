/*
Author : Dhvani Pancholi
Date : June 1st 2018
Description : This program is a replication of the famous Hangman game. This application will display blank spaces
which represent a missing letter, The application will take in the letters that the user guesses.
The user will try to guess the missing word which is displayed by the program.
 */
// Loading Directories/Packages
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class HangmanPanel extends JPanel implements MouseListener{  // HangmanPanel Class which will act as the main method for this class.


    private static final long serialVersionUID = 1L; // initializing serialization

    // Global Variables
    public Image img;
    public ImageIcon icon;
    public Image img2;
    public ImageIcon icon2;
    public Image img3;
    public ImageIcon icon3;
    public Image img4;
    public ImageIcon icon4;
    public Image img5;
    public ImageIcon icon5;
    public int wrong;
    public boolean Hanged = false;
    public boolean Win = false;

    HangmanCheckString chString;
    public HangmanPanel(){    // Constructor

        chString = new HangmanCheckString();
        chString.chooseWord(); // Chooses random word
        this.setSize(100,500);
        this.setVisible(true);
        this.setFocusable(true);

        // Loading all images used in the application
        icon = new ImageIcon("image/Hangman3.jpg");
        img = icon.getImage();
        icon2 = new ImageIcon("image/alphabet4.png");
        img2 = icon2.getImage();
        icon3 = new ImageIcon("image/Hanger.png");
        img3 = icon3.getImage();
        icon4 = new ImageIcon("image/youjustlost.jpg");
        img4 = icon4.getImage();
        icon5 = new ImageIcon("image/Winner.png");
        img5 = icon5.getImage();

        addMouseListener(this); // Adding MouseListener to listen for the clicks
        wrong = 0;

    }
    public void paint(Graphics g){
        // Paint Method where all the drawing happens
        g.drawImage(img,0,0,700,500,null); // Draws The Background For The Application
        g.drawImage(img2,350,100,250,250, null); // Draws The Alphabet
        g.drawImage(img3,65,110,150,300,null); // Draws The Hanger
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial",Font.ITALIC,60)); // Set Font
        g.drawChars(chString.hangmanLetters, 0, chString.charArray.length, 180, 450); // Draws The Blanks of The Missing Words
        g.drawString("Hangman Game",150,90);

         // Draws the Hangman When Each Guess Is Incorrect
        if(chString.wrongGuess == 1){
            g.drawOval(162, 150, 50, 50);  //head
        }
        if(chString.wrongGuess == 2){
            g.drawOval(162, 150, 50, 50);  //head
            g.drawLine(188, 200, 188, 275);//body
        }
        if(chString.wrongGuess == 3){
            g.drawOval(162, 150, 50, 50);  //head
            g.drawLine(188, 200, 188, 275);//body
            g.drawLine(148, 235, 188, 215);// left arm
        }
        if(chString.wrongGuess == 4){
            g.drawOval(162, 150, 50, 50);  //head
            g.drawLine(188, 200, 188, 275);//body
            g.drawLine(148, 235, 188, 215);// left arm
            g.drawLine(188, 215, 228, 235);// right arm
        }
        if(chString.wrongGuess == 5){
            g.drawOval(162, 150, 50, 50);  //head
            g.drawLine(188, 200, 188, 275);//body
            g.drawLine(148, 235, 188, 215);// left arm
            g.drawLine(188, 215, 228, 235);// right arm
            g.drawLine(188, 275, 228, 335);// right leg
        }
        if(chString.wrongGuess == 6){
            g.drawOval(162, 150, 50, 50);  //head
            g.drawLine(188, 200, 188, 275);//body
            g.drawLine(148, 235, 188, 215);// left arm
            g.drawLine(188, 215, 228, 235);// right arm
            g.drawLine(188, 275, 228, 335);// right leg
            g.drawLine(148, 335, 188, 275); // left leg

        }
            if(chString.winOrLoose == true){ // Conditions That Apply If The User Wins The Game
            Win = true;
            g.setColor(Color.white);
            g.fillRect(40, 418, 100, 50);
            g.setColor(Color.red);
            g.setFont(new Font("Arial",Font.ITALIC,18));
            g.drawString("New Game", 45, 450); // New Game Button


        }
        if(chString.wrongGuess == 6){ // Conditions That Apply If The User Loses The Game
            Hanged = true;
            g.setColor(Color.white);
            g.fillRect(40, 418, 100, 50);
            g.setColor(Color.red);
            g.setFont(new Font("Arial",Font.ITALIC,18));
            g.drawString("New Game", 45, 450); // New Game Button
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.ITALIC,30));
            g.fillRect(160,400,350,50);
            g.setColor(Color.BLACK);
            g.drawString("The word was "+ chString.hangmanTemp,170,430); // Replacing The Blanks With The Real Word (When Lost)



        }
        if(Hanged == true) {

            g.drawImage(img4,350,100,250,250, null); // Draws The "You Lost" Image

        }
        if (Win == true) {

            g.drawImage(img5,350,100,250,250,null); // Draws The "Winner" Image
        }
        if (chString.wrongGuess > 6) { // Dialog Appears If User Tries To Click Another Letter When They Lost The Game
            JOptionPane.showConfirmDialog(null,
                    "Sorry, You Ran Out Of Guesses\n Click The New Game Button To Play Again Or Close The Application To Quit"
                    , "ERROR", JOptionPane.DEFAULT_OPTION);
            chString.wrongGuess = 6;
        }

        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) { // MouseClicked Method

        // Declares Variables That Indicate The X and Y Coordinates Of The Mouse
        int mX = e.getX();
        int mY = e.getY();

        // the If statement below will be activated when the man is hanged or user wins
        if(mX > 40 && mX < 140 && mY > 418 && mY < 468 && (chString.wrongGuess == 6 || chString.winOrLoose == true)){ // New Game Button

            // Basically Resets The Game With Different Words
            chString.wrongGuess = 0;
            chString.chooseWord();
            chString.winOrLoose = false;
            for(int i = 0; i < 26; i++){
                chString.usedLetterList[i] = '-';
                Hanged = false;
                Win = false;
            }
        }

        // the if statements below is the areas of the letters to be clicked.

        // Top line A to G
        if(mX > 375 && mX < 406 && mY > 116 && mY < 142){
            char ch = 'a';
            chString.checkWord(ch);
        }
        if(mX > 416 && mX < 447 && mY > 116 && mY < 142){
            char ch = 'b';
            chString.checkWord(ch);
        }
        if(mX > 457 && mX < 486 && mY > 116 && mY < 142){
            char ch = 'c';
            chString.checkWord(ch);
        }
        if(mX > 500 && mX < 528 && mY > 116 && mY < 142){
            char ch = 'd';
            chString.checkWord(ch);
        }
        if(mX > 542 && mX < 571 && mY > 116 && mY < 142){
            char ch = 'e';
            chString.checkWord(ch);
        }
        if(mX > 375 && mX < 406 && mY > 162 && mY < 189){
            char ch = 'f';  // f being click
            chString.checkWord(ch);
        }
        if(mX > 416 && mX < 447 && mY > 162 && mY < 189){
            char ch = 'g';
            chString.checkWord(ch);
        }

        // Second line from top H to N

        if(mX > 457 && mX < 486 && mY > 162 && mY < 189) {
            char ch = 'h';
            chString.checkWord(ch);

        }
        if(mX > 500 && mX < 528 && mY > 162 && mY < 189){
            char ch = 'i';
            chString.checkWord(ch);
        }
            if (mX > 542 && mX < 571 && mY > 162 && mY < 189) {
                char ch = 'j';
                chString.checkWord(ch);
            }

        if(mX > 375 && mX < 406 && mY > 207 && mY < 238){
            char ch = 'k';
            chString.checkWord(ch);
        }
        if(mX > 416 && mX < 447 && mY > 207 && mY < 238){
            char ch = 'l';
            chString.checkWord(ch);
        }
        if(mX > 457 && mX < 486 && mY > 207 && mY < 238){
            char ch = 'm';
            chString.checkWord(ch);
        }
        if(mX > 500 && mX < 528 && mY > 207 && mY < 238){
            char ch = 'n';
            chString.checkWord(ch);
        }

        // Third line of letters O to U

        if(mX > 542 && mX < 571 && mY > 207 && mY < 238){
            char ch = 'o';
            chString.checkWord(ch);
        }
        if(mX > 355 && mX < 386 && mY > 257 && mY < 285){
            char ch = 'p';
            chString.checkWord(ch);
        }
        if(mX > 397 && mX < 427 && mY > 257 && mY < 285){
            char ch = 'q';
            chString.checkWord(ch);
        }
        if(mX > 439 && mX < 467 && mY > 257 && mY < 285){
            char ch = 'r';
            chString.checkWord(ch);
        }
        if(mX > 479 && mX < 510 && mY > 257 && mY < 285){
            char ch = 's';
            chString.checkWord(ch);
        }
        if(mX > 521 && mX < 551 && mY > 257 && mY < 285){
            char ch = 't';
            chString.checkWord(ch);
        }
        if(mX > 562 && mX < 593 && mY > 257 && mY < 285){
            char ch = 'u';
            chString.checkWord(ch);
        }

        // Bottom line V to Z

        if(mX > 375 && mX < 406 && mY > 303 && mY < 331){
            char ch = 'v';
            chString.checkWord(ch);
        }
        if(mX > 416 && mX < 447 && mY > 303 && mY < 331){
            char ch = 'w';
            chString.checkWord(ch);
        }
        if(mX > 457 && mX < 486 && mY > 303 && mY < 331){
            char ch = 'x';
            chString.checkWord(ch);
        }
        if(mX > 500 && mX < 528 && mY > 303 && mY < 331){
            char ch = 'y';
            chString.checkWord(ch);
        }
        if(mX > 542 && mX < 571 && mY > 303 && mY < 331){
            char ch = 'z';
            chString.checkWord(ch);


        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {


    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }

}
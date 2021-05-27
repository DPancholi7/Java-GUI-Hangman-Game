/*
Author: Dhvani Pancholi
Date: June 1st 2018
Description : This Class Is Responsible For The Applications Main JFrame
 */
import javax.swing.JFrame;


public class HangmanFrame {

    HangmanPanel panel; // Declaring A New Panel


    public HangmanFrame(){
        // Adding Necessary Properties To The JFrame
        panel = new HangmanPanel();
        JFrame jf = new JFrame(); // Declaring New JFrame
        jf.setTitle(" Dhvani's Hangman"); // Title
        jf.setSize(700,510); // Setting Size Of The JFrame
        jf.add(panel); // Adding The Panel To The JFrame
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Default Close Operation
        jf.setVisible(true); // JFrame Is Visible
        jf.setResizable(false); // JFrame Not Resizable



        }







    }







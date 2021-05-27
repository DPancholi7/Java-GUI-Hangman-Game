import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HangmanFrame {

    HangmanPanel panel;


    public HangmanFrame(){
        panel = new HangmanPanel();
        JFrame jf = new JFrame();
        jf.setTitle("Hangman");
        jf.setSize(700,510);
        jf.add(panel);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setResizable(false);



        }







    }







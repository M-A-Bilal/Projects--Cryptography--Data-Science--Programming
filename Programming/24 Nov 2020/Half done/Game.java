package RandomLetterGuessingGame;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;

public class Game {
    static JFrame masterFrame=new JFrame("Random Letter Guessing Game");
    static JFrame confirmationFrame1=new JFrame();
    static JFrame confirmationFrame2=new JFrame();
    static JFrame showWordFrame=new JFrame();
    static JPanel selectChoicePanel=new JPanel();
    static JPanel gameSelectionPanel=new JPanel();
    static JPanel gameStartPanel=new JPanel();
    static JPanel confirmationPanel1=new JPanel();
    static JPanel confirmationPanel2=new JPanel();
    static JPanel showWordPanel=new JPanel();
    static JLabel gameSelectionLabel=new JLabel("Select difficulty and game type");
    static JLabel gameStartLabel=new JLabel();
    static JLabel letterFoundLabel=new JLabel();
    static JLabel attemptsLeftLabel=new JLabel();
    static JLabel enterLetterLabel=new JLabel("Enter a letter please:");
    static JLabel surityLabel1=new JLabel("Are you sure you want to continue with this choice?");
    static JLabel surityLabel2=new JLabel("Are you sure you want to continue with this choice?");
    static JLabel showWord=new JLabel();
    static JLabel[] letterLabel;
    static JTextField letterEntryTF=new JTextField();
    static JSlider difficultySlider=new JSlider(0, 100, 50);
    static JButton startPlayingButton=new JButton("Start Playing!");
    static JButton reveal=new JButton("Reveal");
    static JButton clear=new JButton("Clear");
    static JButton giveUp=new JButton("I give up on this word!");
    static JButton mainMenu=new JButton("Go back to Main Menu");
    static JButton okButton1=new JButton("OK");
    static JButton okButton2=new JButton("OK");
    static JButton cancelButton1=new JButton("Cancel");
    static JButton cancelButton2=new JButton("Cancel");
    static JButton nextWordButton=new JButton("Next word");
    static ButtonGroup groupRadioButtons=new ButtonGroup();
    static JRadioButton fourWords=new JRadioButton("4 words (guess 2+ words to win)");
    static JRadioButton sixWords=new JRadioButton("6 words (guess 3+ words to win)");
    
    static String difficulty;
    static String[] wordFromFile=new String[439];
    static int moved=0;
    static int gameMode=0;
    static int totalWords=0;
    
        
    public static void main(String args[]){
        
        try {
            File myObj = new File("C:\\Users\\Ahmad\\Documents\\NetBeansProjects\\24Nov2020\\wordlist.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                wordFromFile[totalWords] = myReader.nextLine().trim();
                totalWords++;

                //System.out.println(data);
            }
            System.out.println(totalWords+" words in the file");
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred. "+e.getMessage());
            e.printStackTrace();
        }
    
        masterFrame.setVisible(true);
        masterFrame.setBounds(500,200,550,300);
        masterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        masterFrame.setContentPane(selectChoicePanel);
        
        //Choice selection panel 
        selectChoicePanel.setLayout(null);
        JButton newGame=new JButton("New game");
        JButton quit=new JButton("Quit");
        
        newGame.setBounds(225, 50, 100, 40);
        quit.setBounds(225, 110, 100, 40);
        selectChoicePanel.add(newGame);
        selectChoicePanel.add(quit);
        
        
        
        
        //Game and difficulty selection panel
        fourWords.setBounds(10, 150, 250, 25);
        fourWords.setActionCommand("Four words");
        sixWords.setBounds(10, 180, 250, 25);
        sixWords.setActionCommand("Six words");
        groupRadioButtons.add(fourWords);
        groupRadioButtons.add(sixWords);
        
        gameSelectionPanel.setLayout(null);
        gameSelectionLabel.setBounds(90, 5, 180, 25);
        gameSelectionPanel.add(gameSelectionLabel);
        
        startPlayingButton.setBounds(300, 170, 150, 30);
        gameSelectionPanel.add(startPlayingButton);
        
        difficultySlider.setPaintTrack(true); 
        difficultySlider.setPaintTicks(true); 
        difficultySlider.setPaintLabels(true); 
  
        // set spacing 
        difficultySlider.setMajorTickSpacing(50);
        difficultySlider.setBounds(50, 40, 400, 40);
        Hashtable<Integer, JLabel> labelTable = 
        new Hashtable<Integer, JLabel>();
        labelTable.put(new Integer( 0 ),
        new JLabel("Easy") );
        labelTable.put(new Integer( 50 ),
        new JLabel("Normal") );
        labelTable.put(new Integer( 100 ),
        new JLabel("Hard") );
        difficultySlider.setLabelTable(labelTable);
        difficultySlider.setPaintLabels(true); 
        
        
        gameSelectionPanel.add(fourWords);
        gameSelectionPanel.add(sixWords);
        
        gameSelectionPanel.add(difficultySlider);
        
        
        
        //functionality of newGame button 
        newGame.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                selectChoicePanel.setVisible(false);
                gameSelectionPanel.setVisible(true);
                masterFrame.setContentPane(gameSelectionPanel);
                masterFrame.repaint();
                
                difficultySlider.addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent ce) {
                        int value;
                        
                         difficultySlider = (JSlider) ce.getSource();
                         if (!difficultySlider.getValueIsAdjusting()) {
                             moved=1;
                             value = difficultySlider.getValue();
                             System.out.println(value);
                             if(value>=0 && value<=25){
                                 difficulty="Easy";
                                 System.out.println("Easy");
                             }else if(value>25 && value<=75){
                                 difficulty="Normal";
                                 System.out.println("Normal");
                             }else{
                                 difficulty="Hard";
                                 System.out.println("Hard");
                             }
                         }
                    }
                });
                 if(moved==0){
                     difficulty="Normal";
                     System.out.println("Slider not moved, value = 50");
                 }
                
                 gameStartPanel.setLayout(null);
                gameStartLabel.setBounds(50, 10, 420, 30);
                gameStartPanel.add(gameStartLabel);
                enterLetterLabel.setBounds(5, 180, 125, 25);
                gameStartPanel.add(enterLetterLabel);
                letterEntryTF.setBounds(135, 180, 30, 25);
                letterEntryTF.setHorizontalAlignment(JTextField.CENTER);
                gameStartPanel.add(letterEntryTF);
                reveal.setBounds(170, 180, 80, 25);
                gameStartPanel.add(reveal);
                clear.setBounds(255, 180, 80, 25);
                gameStartPanel.add(clear);
                giveUp.setBounds(170, 210, 165, 25);
                gameStartPanel.add(giveUp);
                mainMenu.setBounds(350, 190, 165, 25);
                gameStartPanel.add(mainMenu);
                letterFoundLabel.setBounds(10, 210, 140, 25);
                    
        
                
        
                //functionality of startPlayingButton button 
                startPlayingButton.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        
                        
                        
                        String choice = groupRadioButtons.getSelection().getActionCommand();
                        System.out.println(choice);
                        gameStartLabel.setOpaque(true);
                        gameStartLabel.setBackground(Color.GRAY);
                        gameStartLabel.setForeground(Color.WHITE);
                        if(choice.equals("Four words")){
                            
                            gameStartLabel.setText("Guess the word by typing a letter - You are playing 4 words guess mode");
                            gameMode=4;
                            
                        
                         }else if(choice.equals("Six words")){
                             gameStartLabel.setText("Guess the word by typing a letter - You are playing 6 words guess mode");
                             gameMode=6;
                         }
                        
                         wordLabelfunc(choice);
                            
                        
                        
                        
                        
                    }
                }
                ); 
                
                
                
            }
        }
        ); 
        
        //functionality of quit button 
        quit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {

                System.exit(0);
                
            }
        }
        );
        
    }
    
    public static void wordLabelfunc(String choice){
        if(gameMode>0){
            Random rand = new Random();
            int random_integer = rand.nextInt(totalWords);
            System.out.println(random_integer);
            String randomWord=wordFromFile[random_integer-1];
            System.out.println(randomWord);
            // Creating array of string length 
            char[] ch = new char[randomWord.length()]; 

            // Copy character by character into array 
            for (int j = 0; j < randomWord.length(); j++) { 
                ch[j] = randomWord.charAt(j); 
            } 

            // Printing content of array 
            int place=0;
            letterLabel=new JLabel[randomWord.length()];
            
            for (char c : ch) { 
                
                letterLabel[place]=new JLabel("?",SwingConstants.CENTER);

                letterLabel[place].setBounds(10+(place*35), 60, 30, 25);

                Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
                letterLabel[place].setBorder(border);
                letterLabel[place].setOpaque(true);
                letterLabel[place].setBackground(Color.WHITE);
                letterLabel[place].setForeground(Color.BLACK);
                gameStartPanel.add(letterLabel[place]);
                gameStartPanel.add(letterFoundLabel);
                System.out.println(c); 
                place++;
            } 
            revealfunc(ch);
            gameMode--;


        }
    }
    
    
    public static void revealfunc(char[] ch){
        reveal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String letter=letterEntryTF.getText();
                    if(letter.length()>1){
                        throw new InputMismatchException("Input must only contain a letter");
                    }else{
                        //char enteredLetter = letter.charAt(0);
                        int place=0;
                        for(char c : ch){
                            
                            if(letter.equalsIgnoreCase(String.valueOf(c))){
                                
                                letterLabel[place].setText(String.valueOf(Character.toLowerCase(c)));
                                letterFoundLabel.setText(letter+" is found successfully");
                             
                            }
                            place++;
                        }
                    }
                    
                }catch(Exception ex){
                    System.out.println("Please give a single letter input");
                }
            }                        
        });
        
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letterEntryTF.setText("");
                letterFoundLabel.setText("");
            }
        });
        
        gameSelectionPanel.setVisible(false);
        gameStartPanel.setVisible(true);
        masterFrame.setContentPane(gameStartPanel);
        masterFrame.repaint();
                                
        
        confirmationFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        confirmationFrame1.setBounds(550,250,450,200);
        confirmationPanel1.setLayout(null);
        surityLabel1.setBounds(50, 10, 420, 30);
        confirmationPanel1.add(surityLabel1);
        okButton1.setBounds(130, 100, 90, 25);
        confirmationPanel1.add(okButton1);
        cancelButton1.setBounds(230, 100, 90, 25);
        confirmationPanel1.add(cancelButton1);
        
        mainMenu.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                confirmationFrame1.setVisible(true); 
                confirmationFrame1.setContentPane(confirmationPanel1);
                confirmationPanel1.setVisible(true);
                
                okButton1.addActionListener(new ActionListener(){
                    
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        confirmationFrame1.setVisible(false);
                        confirmationPanel1.setVisible(false);
                        selectChoicePanel.setVisible(true);
                        masterFrame.setContentPane(selectChoicePanel);
                        
                        masterFrame.repaint();
                        
                        
                    }
                }
                );
                
                cancelButton1.addActionListener(new ActionListener(){
                    
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        confirmationFrame1.setVisible(false);
                        
                        
                    }
                }
                );
                
                
            }
        }
        );
        
        
        confirmationFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        confirmationFrame2.setBounds(550,250,450,200);
        confirmationPanel2.setLayout(null);
        surityLabel2.setBounds(50, 10, 420, 30);
        confirmationPanel2.add(surityLabel2);
        okButton2.setBounds(130, 100, 90, 25);
        confirmationPanel2.add(okButton2);
        cancelButton2.setBounds(230, 100, 90, 25);
        confirmationPanel2.add(cancelButton2);
        
        
        
        showWordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showWordFrame.setBounds(550,250,450,200);
        showWordFrame.setContentPane(showWordPanel);
        showWordPanel.setLayout(null);
        showWord.setBounds(150, 50, 150, 25);
        showWordPanel.add(showWord);
        nextWordButton.setBounds(150, 100, 150, 25);
        showWordPanel.add(nextWordButton);
        
        
        giveUp.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                confirmationFrame2.setVisible(true); 
                confirmationFrame2.setContentPane(confirmationPanel2);
                confirmationPanel2.setVisible(true);
                
                okButton2.addActionListener(new ActionListener(){
                    
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        confirmationFrame2.setVisible(false);
                        confirmationPanel2.setVisible(false);
                        showWordFrame.setVisible(true);
                        showWord.setText(new String(ch));
                        
                        nextWordButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                showWordFrame.setVisible(false);
                                gameStartPanel.setVisible(true);
                                masterFrame.setContentPane(gameStartPanel);
                                masterFrame.repaint();
                            }
                        });
                        
                        
                    }
                }
                );
                
                cancelButton2.addActionListener(new ActionListener(){
                    
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        confirmationFrame2.setVisible(false);
                        
                        
                    }
                }
                );
                
                
            }
        }
        );
    }
    
}
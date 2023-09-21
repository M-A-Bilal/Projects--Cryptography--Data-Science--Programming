package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by clara on 10/21/19.
 */
public class WishListGUI extends JFrame {
    
    JPanel mainPanel=new JPanel();
    DefaultListModel<String> modelWishList = new DefaultListModel<>();
    JList<String> wishList=new JList<>(modelWishList);
    DefaultListModel<String> modelVisitedList = new DefaultListModel<>();
    JList<String> visitedList=new JList<>(modelVisitedList);
    JTextField newPlaceNameTextField=new JTextField();
    JButton addButton=new JButton("Add place");
    JButton saveQuitButton=new JButton("Save and Quit");
    JButton wishListButton=new JButton("WishList place");
    JButton visitedButton=new JButton("Visited place");
    
    public WishListGUI(List<String> wishListPlaces, List<String> visitedPlaces) {
        
        for(int i=0;i<wishListPlaces.size();i++)
            modelWishList.addElement(wishListPlaces.get(i));
        for(int i=0;i<visitedPlaces.size();i++)
            modelVisitedList.addElement(visitedPlaces.get(i));
        
        setTitle("Travel Wish List Application");
        setBounds(500,200,500,300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        mainPanel.setLayout(null);
        newPlaceNameTextField.setBounds(50, 50, 100, 30);
        mainPanel.add(newPlaceNameTextField);
        addButton.setBounds(50, 100, 100, 30);
        mainPanel.add(addButton);
        
        wishListButton.setBounds(320, 50, 130, 30);
        mainPanel.add(wishListButton);
        visitedButton.setBounds(320, 100, 130, 30);
        mainPanel.add(visitedButton);
        
        saveQuitButton.setBounds(180, 200, 130, 30);
        mainPanel.add(saveQuitButton);
        
        addbuttonListener();
        wishListButtonListener();
        visitedButtonListener();
        saveAndQuitButtonListener();
       
    }
    
    void addbuttonListener(){
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredPlace = newPlaceNameTextField.getText();
                int stringExists=0;
                if(!enteredPlace.isBlank()){
                    for(int i = 0; i < wishList.getModel().getSize(); i++)
                        if(wishList.getModel().getElementAt(i).equalsIgnoreCase(enteredPlace.trim())){
                            showMessageDialog("Name already exists");
                            stringExists=1;
                            break;
                        }
                    if(stringExists==0) 
                        modelWishList.addElement(enteredPlace.trim());
                    newPlaceNameTextField.setText("");
                }
            }
        });
    }
    
    void wishListButtonListener(){
        wishListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel wishListPanel=new JPanel();
                JButton back=new JButton("Back");
                mainPanel.setVisible(false);
                wishListPanel.setVisible(true);
                setContentPane(wishListPanel);
                repaint();
                wishListPanel.setLayout(null);
                
                JScrollPane scrollPane = new JScrollPane(wishList);
                
                wishList.setMinimumSize(new Dimension(150,100));
                wishListPanel.add(wishList);
                wishListPanel.add(scrollPane);
                scrollPane.getViewport().add(wishList);

                scrollPane.setBounds (165, 15, 150, 200);
                wishList.setBounds (165, 15, 150, 100);
                
                JPopupMenu popup = new JPopupMenu();
                JMenuItem visitedOption = new JMenuItem("Visited!");
                JMenuItem deleteOption = new JMenuItem("Delete");
                popup.add(visitedOption);
                popup.add(deleteOption);
               
                wishList.setComponentPopupMenu(popup);
                
                back.setBounds(400, 230, 80, 30);
                wishListPanel.add(back);
                
                visitedOptionListener(visitedOption);
                deleteOptionWishlistListener(deleteOption);
                backButtonListener(wishListPanel, back);
            }
        });
    }
    
    void visitedOptionListener(JMenuItem visited){
        visited.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String place=wishList.getSelectedValue();
                int index=0;
                for(; index < modelWishList.getSize(); index++)
                    if(modelWishList.getElementAt(index).equals(place)){
                        modelWishList.remove(index);
                        modelVisitedList.addElement(place);
                    }
            }
        });
    }
    
    void deleteOptionWishlistListener(JMenuItem delete){
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String place=wishList.getSelectedValue();
                int index=0;
                for(; index < modelWishList.getSize(); index++) 
                    if(modelWishList.getElementAt(index).equals(place))
                        modelWishList.remove(index);
                    
                
            }
        });
    }
    
    void visitedButtonListener(){
        visitedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel visitedPanel=new JPanel();
                JButton back=new JButton("Back");
                mainPanel.setVisible(false);
                visitedPanel.setVisible(true);
                setContentPane(visitedPanel);
                repaint();
                visitedPanel.setLayout(null);
                
                JScrollPane scrollPane = new JScrollPane(visitedList);
                
                visitedList.setMinimumSize(new Dimension(150,100));
                visitedPanel.add(visitedList);
                visitedPanel.add(scrollPane);
                scrollPane.getViewport().add(visitedList);
                scrollPane.setBounds (165, 15, 150, 200);
                visitedList.setBounds (165, 15, 150, 100);
                
                JPopupMenu popup = new JPopupMenu();
                JMenuItem deleteOption = new JMenuItem("Delete");
                popup.add(deleteOption);
               
                visitedList.setComponentPopupMenu(popup);
                
                back.setBounds(400, 230, 80, 30);
                visitedPanel.add(back);
                
                deleteOptionVisitedListener(deleteOption);
                backButtonListener(visitedPanel, back);
            }
        });
    }
    
    void deleteOptionVisitedListener(JMenuItem delete){
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String place=visitedList.getSelectedValue();
                int index=0;
                for(; index < modelVisitedList.getSize(); index++) {
                    if(modelVisitedList.getElementAt(index).equals(place)){
                        modelVisitedList.remove(index);
                    }
                }
            }
        });
    }
    
    void backButtonListener(JPanel panel, JButton button){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                mainPanel.setVisible(true);
                setContentPane(mainPanel);
                repaint();
            }
        });
    }
    
    
    void saveAndQuitButtonListener(){
        saveQuitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> wishListSelectedElements =new ArrayList<String>();               
                for(int index=0; index < modelWishList.getSize(); index++)                     
                    wishListSelectedElements.add(modelWishList.getElementAt(index));               
                List<String> visitedSelectedElements =new ArrayList<String>();
                for(int index=0; index < modelVisitedList.getSize(); index++)
                    visitedSelectedElements.add(modelVisitedList.getElementAt(index));
                Main.quit(wishListSelectedElements, visitedSelectedElements);
                dispose();
            }
        });
    }
    
    // Use this method to show message dialogs displaying the message given.
    // Otherwise tests for code that shows alert dialogs will time out and fail.
    // Don't modify this method.
    protected void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(this, message);
    }    
}
/* File: Project4.java
 * Date: 09 May 2020
 * Author: Tyler D Clark
 * Description: Provides a JFileChooser for the user to select a file to be read in. A graph is then constructed from
 * the provided file. The graph is then depth first search and printed as a parenthesized list and as a hierarchy
 * the program will continue to prompt for files until the user chooses "No" or "Cancel" */

package wk8.project4;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Project4 {
    // Main here
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        int userChoice = JOptionPane.showConfirmDialog(null, "Would you like to select a file?",
                "Project 4", JOptionPane.YES_NO_CANCEL_OPTION);
        while (userChoice == 0) {
            //JFileChooser showDialog was giving me issues on OSX, so this allowed it to execute in the right thread
            EventQueue.invokeAndWait(Project4::fromFile);
            userChoice = JOptionPane.showConfirmDialog(null, "Would you like to select a file?",
                    "Project 4", JOptionPane.YES_NO_CANCEL_OPTION);
        }
    }

    //===============================================================================================
    //  fromFile - using JFileChooser, loads a graph from file and displays it
    //===============================================================================================

    public static <E> void fromFile() {
        //Create JFileChooser
        JFileChooser chooser = new JFileChooser();
        //Show both directories and files
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //use current directory for ease
        chooser.setCurrentDirectory(new File("."));
        int response = chooser.showOpenDialog(chooser.getParent());
        if (response == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                Scanner fileIn = new Scanner(file);
                //Instantiate graph
                DirectedGraph<String> graph = new DirectedGraph<>();
                //create graph
                while (fileIn.hasNextLine()) {
                    parseVertexString(fileIn.nextLine(), graph);
                }
                //instantiate DFSActions objects
                DFSActions<String> parenthesizedList = new ParenthesizedList<>();
                DFSActions<String> hierarchy = new Hierarchy<>();
                //do the DFS
                graph.performDFS(parenthesizedList);
                graph.performDFS(hierarchy);
                //and print them
                System.out.println(parenthesizedList + "\n");
                System.out.println(hierarchy);
                graph.unreachable();
                System.out.println("\n" + graph);

            } catch (NoSuchElementException nse) {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "File is empty!");
            } catch (FileNotFoundException fne) {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "File is not found!");
            }
        }
    }
    //===============================================================================================
    //  parseVertexString - creates an edges from a String, where the first token is the Vertex
    //===============================================================================================

    private static void parseVertexString(String fileLine, DirectedGraph<String> graph) {
        String[] toArray = fileLine.split(" ");
        for (int i = 1; i < toArray.length; i++) {
            graph.createEdge(toArray[0], toArray[i]);
        }
    }
}
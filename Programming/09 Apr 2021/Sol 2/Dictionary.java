
import javax.swing.*;

class WordMeaningNode {
    WordMeaningNode wordMeaningNode;
    WordMeaning wordMeaning;
    WordMeaningNode(WordMeaning word_meaning) {
        wordMeaningNode = null;
        wordMeaning = word_meaning;
    }    
    public WordMeaning get_meaning(){ 
        return wordMeaning; 
    }
}

class GetData{
    static String getString(String input){
        String value = JOptionPane.showInputDialog(input);
        return value;
    }
    static int get_integer_value(String input){
        int value = Integer.parseInt(getString(input));
        return value;
    }
}

public class Dictionary {
    public static void main(String[] args) {
        WordList this_word_list = new WordList();
        WordMeaning word_meaning;
        WordList del_word_list = new WordList();
        boolean end = false;
        int input = 0;
        String options =  "1. Add a word and meaning\n"
                            + "2. Delete a word\n"
                            + "3. Show all words\n"
                            + "4. Show deleted words\n"
                            + "5. Exit\n\n "
                            + "Enter your choice";
        do {
            input = GetData.get_integer_value(options);
            switch (input) {
                case 1:
                    String word = GetData.getString("Enter word: ");
                    String meaning = GetData.getString("Enter meaning : ");
                    meaning = " -\t" + meaning;
                    word_meaning = new WordMeaning(word, meaning);
                    this_word_list.add(word_meaning);
                    JOptionPane.showMessageDialog(null, word + " included.", "Word Added", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    word = GetData.getString("Which word you want to delete? ");
                    if (this_word_list.Remove_Word(word)) {
                        del_word_list.add(new WordMeaning(word, " "));
                        JOptionPane.showMessageDialog(null, word + " successfully removed!", "Word Deleted", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, word + "does not exists in dictionary", "Word Not Deleted", JOptionPane.INFORMATION_MESSAGE);
                    }                    
                    break;
                case 3:
                    JTextArea text_area = new JTextArea(this_word_list.toString(), 10, 40);
                    JScrollPane scroll_pane = new JScrollPane(text_area);
                    JOptionPane.showMessageDialog(null, scroll_pane, "Dictionary Contents", JOptionPane.INFORMATION_MESSAGE);
                    break;


                case 4:
                    text_area = new JTextArea(del_word_list.toString(), 10, 40);
                    scroll_pane = new JScrollPane(text_area);
                    JOptionPane.showMessageDialog(null, scroll_pane, "Deleted Dictionary Words", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 5:
                    System.exit(0);
                default:
                    end = true;
            }
        } while (!end);
    }
}

class WordMeaning {
    String mean;
    String wd;
    WordMeaning(String wd, String mng) {
        this.wd = wd;
        mean = mng;
    }
    String getWord() { 
        return wd;
    }
    String getMeaning() { 
        return mean;
    }
}

class WordList {
    WordMeaningNode word_mean_node;
    WordList() { word_mean_node = null;}
    void add(WordMeaning word_mean){
        WordMeaningNode temp_word_mean_node = new WordMeaningNode(word_mean);
        if (word_mean_node == null)
            word_mean_node = temp_word_mean_node;
        else{
            WordMeaningNode next_word_mean_node = word_mean_node;
            WordMeaningNode prev_word_mean_node = null;
            boolean flag = false;
            while(next_word_mean_node != null && !flag)
                if( temp_word_mean_node.get_meaning().getWord().compareTo(next_word_mean_node.get_meaning().getWord()) < 0 )
                    flag = true;
                else{
                    prev_word_mean_node = next_word_mean_node;
                    next_word_mean_node = next_word_mean_node.wordMeaningNode;
                }
            temp_word_mean_node.wordMeaningNode = next_word_mean_node;
            if (prev_word_mean_node == null){
                word_mean_node = temp_word_mean_node;
            }
            else{
                prev_word_mean_node.wordMeaningNode = temp_word_mean_node;
            }
        }
    }

    boolean List_Empty() {
        boolean check_list_empty;
        if (word_mean_node == null){
            check_list_empty = true;
        }
        else{
            check_list_empty = false;
        }
        return check_list_empty;
    }
    
    public String toString(){
        WordMeaningNode current_word_mean_node = word_mean_node;
        int total_words = 0;
        String text = "";
        while (current_word_mean_node != null){
            text += current_word_mean_node.get_meaning().getWord() + "\t" + current_word_mean_node.get_meaning().getMeaning() + "\n";
            current_word_mean_node = current_word_mean_node.wordMeaningNode;
            total_words++;            
        }
        return text + "\nNumber of words = " + total_words;
    }
    
    boolean Remove_Word(String word) {
        WordMeaningNode next_word_mean_node = word_mean_node;
        WordMeaningNode prev_word_mean_node = null;
        if (word_mean_node == null){
            return false;
        }
        do {
            if (next_word_mean_node.get_meaning().wd.equals(word)) {
                if (prev_word_mean_node != null){
                    prev_word_mean_node.wordMeaningNode = next_word_mean_node.wordMeaningNode;
                }
                else{
                    word_mean_node = word_mean_node.wordMeaningNode;
                }            
                return true;
            }
            prev_word_mean_node = next_word_mean_node;
            next_word_mean_node = next_word_mean_node.wordMeaningNode;
        } while (next_word_mean_node != null);  
        return false;
    }
}
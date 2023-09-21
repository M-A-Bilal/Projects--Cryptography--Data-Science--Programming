
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

class WordMeaning {
    String word;
    String meaning;
    WordMeaning(String wd, String mng) {
        word = wd;
        meaning = mng;
    }
    String getWord() { return word;}
    String getMeaning() { return meaning;}
}

class WordMeaningNode {
    WordMeaning WM;
    WordMeaningNode nextNode;
    WordMeaningNode(WordMeaning wm) {
        WM = wm;
        nextNode = null;
    }    
    public WordMeaning getMeaning(){ return WM; }
}

class WordList {
    WordMeaningNode wordsList;
    WordList() { wordsList = null;}
    void add(WordMeaning wm){
        WordMeaningNode wmn_temp = new WordMeaningNode(wm);
        if (wordsList == null)
            wordsList = wmn_temp;
        else{
            WordMeaningNode next = wordsList;
            WordMeaningNode prev = null;
            boolean isThere = false;
            while(next != null && !isThere)
                if( wmn_temp.getMeaning().getWord().compareTo(next.getMeaning().getWord()) < 0 )
                    isThere = true;
                else{
                    prev = next;
                    next = next.nextNode;
                }
            wmn_temp.nextNode = next;
            if (prev == null) wordsList = wmn_temp;
            else prev.nextNode = wmn_temp;
        }
    }

    boolean EmptyList() {
        boolean result;
        if (wordsList == null) result = true;
         else result = false;
        return result;
    }
    
    public String toString(){
        String text = "";
        int noOfWords = 0;
        WordMeaningNode curr = wordsList;
        while (curr != null){
            noOfWords++;
            text += curr.getMeaning().getWord() + "\t" + curr.getMeaning().getMeaning() + "\n";
            curr = curr.nextNode;
        }
        return text + "\nTotal words = " + noOfWords;
    }
    
    boolean delete(String wd) {
        if (wordsList == null) return false;
        WordMeaningNode wmnNext = wordsList;
        WordMeaningNode wmnPrev = null;
        do {
            if (wmnNext.getMeaning().word.equals(wd)) {
                if (wmnPrev != null) wmnPrev.nextNode = wmnNext.nextNode;
                else wordsList = wordsList.nextNode;            
                return true;
            }
            wmnPrev = wmnNext;
            wmnNext = wmnNext.nextNode;
        } while (wmnNext != null);  
        return false;
    }
}

public class Dictionary {
    public static void main(String[] args) {
        WordMeaning newWord;
        WordList currWordsList = new WordList();
        WordList obsoleteWordsList = new WordList();
        boolean exit = false;
        int choice = 0;
        String menu =  "1. Enter a word and its definition\n"
                            + "2. Remove a word\n"
                            + "3. Display all words and meanings\n"
                            + "4. Display Removed words\n\n "
                            + "Enter the Menu Option (1,2,3, or 4--Any other key exits the program)";
        do {
            choice = GetData.getInt(menu);
            switch (choice) {
                case 1:
                    String wd = GetData.getString("Enter a word: ");
                    String mg = GetData.getString("Enter meaning of "+ wd + " : ");
                    mg = " -\t" + mg;
                    newWord = new WordMeaning(wd, mg);
                    currWordsList.add(newWord);
                    JOptionPane.showMessageDialog(null, wd + " added.", "New Word", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    wd = GetData.getString("Enter word to delete: ");
                    if (currWordsList.delete(wd)) {
                        obsoleteWordsList.add(new WordMeaning(wd, " "));
                        JOptionPane.showMessageDialog(null, wd + " deleted!", "Word Removal", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, wd + "does not exists", "Word Removal", JOptionPane.INFORMATION_MESSAGE);
                    }                    
                    break;
                case 3:
                    JTextArea JTA = new JTextArea(currWordsList.toString(), 10, 40);
                    System.out.println(currWordsList);
                    JScrollPane JSP = new JScrollPane(JTA);
                    JOptionPane.showMessageDialog(null, JSP, "Dictionary", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 4:
                    JTA = new JTextArea(obsoleteWordsList.toString(), 10, 40);
                    JSP = new JScrollPane(JTA);
                    JOptionPane.showMessageDialog(null, JSP, "Deleted Words", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    exit = true;
            }
        } while (!exit);
    }
}

class GetData{
    static int getInt(String msg){return Integer.parseInt(getString(msg));}	
    static String getString(String msg){return JOptionPane.showInputDialog(msg);}
}
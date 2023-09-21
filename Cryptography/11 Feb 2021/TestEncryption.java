package feb2021;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

abstract class Cipher implements Constants{
    private String message;
    StringBuffer encrypted_message, decrypted_message;
    public Cipher(String text){
        message = text;
    }

    public final void encrypt(){
        encrypted_message = new StringBuffer("");
        StringTokenizer words = new StringTokenizer(message);
        while (words.hasMoreTokens()){
            String s = words.nextToken();
            s = encode(s) + " ";
            encrypted_message.append(s);
        }
    }
    
    public final void decrypt(String message){
        StringTokenizer words = new StringTokenizer(message);
        decrypted_message = new StringBuffer("");
        while (words.hasMoreTokens()){
            String s = words.nextToken();
            s = decode(s) + " ";
            decrypted_message.append(s);
        }
    }
    
    String getEncodedMessage(){
        return encrypted_message.toString();
    }
    
    String getDecodedMessage(){
        return decrypted_message.toString();
    }

    @Override
    public abstract String encode(String s);
    @Override
    public abstract String decode(String s);
}

class Caesar extends Cipher{
    public Caesar(String s){
        super(s);
    }

    @Override
    public String encode(String word){
        return code(word,Constants.ENCODE_SHIFT );
    }

    @Override
    public String decode(String word){
        return code(word,Constants.DECODE_SHIFT );
    }
    
    String code(String word, int SHIFT){
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            ch = determineCharacter(ch, SHIFT);
            result.append(ch);
        }
        return result.toString();
    }

    public char determineCharacter(char ch, int shift){
        if(Character.isUpperCase(ch))
            ch = (char)('A' + (ch - 'A' + shift) % Constants.WRAP_AROUND);
        else if (Character.isLowerCase(ch))
            ch = (char)('a' + (ch - 'a' + shift) % Constants.WRAP_AROUND);
        return ch;
    }

}

class Transpose extends Cipher{
    String reverseWord;
    Transpose(String s){
        super(s);
    }
    @Override
    public String encode(String word){
        StringBuffer sb = new StringBuffer(word);
        sb = sb.reverse();
        return sb.toString();
    }
    @Override
    public String decode(String word){
        return encode(word);
    }
}

class Reverser extends Transpose{
    Reverser(String s){
        super(s);
    }
    String reverseText(String word){
        StringBuffer rev_str = new StringBuffer();
        int str_length = word.length();
        str_length--;
        for (int i = str_length; i > -1; i--){
            char letter = word.charAt(i);
            rev_str.append(letter);
        }
        return rev_str.toString();
    }
}

interface Constants{
    int WRAP_AROUND = 26;
    int ENCODE_SHIFT = 3;
    int DECODE_SHIFT = 23;
    public abstract String encode(String s);
    public abstract String decode(String s);
}

public class TestEncryption{
    public static void main(String[] args) {
        String code, output = "";
        String text = JOptionPane.showInputDialog("Enter message");
        output += "The original message is \n" + text + "\n";
        
        Cipher c = new Caesar(text);
        c.encrypt();
        code = c.getEncodedMessage();
        output += "\nCeasar Cipher\nThe encrypted message is \n" + code + "\n";
        c.decrypt(code);
        code = c.getDecodedMessage();
        output += "The decrypted message is \n" + code + "\n";
        
        c = new Transpose(text);
        c.encrypt();
        code = c.getEncodedMessage();
        output += "\nTranspose\nThe encrypted Transpose message is \n" + code + "\n";
        c.decrypt(code);
        code = c.getDecodedMessage();
        output += "The decrypted Transpose message is \n" + code + "\n";
        
        Reverser r = new Reverser(text);
        r.encrypt();
        code = r.reverseText(text);
        output += "\nReverser\nThe encrypted Reverse message is \n" + code + "\n";
        code = r.decode(code);
        output += "The decrypted Reverse message is \n" + code;
        display(output);
        
    }
    
    static void display(String s){
        JOptionPane.showMessageDialog(null, s, "Encrypt/decrypt", JOptionPane.INFORMATION_MESSAGE);
    }
}

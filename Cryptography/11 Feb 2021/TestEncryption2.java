import java.util.StringTokenizer;
import javax.swing.JOptionPane;
abstract class Cipher
{
private String message;
StringBuffer encrypted_message, decrypted_message;
public Cipher(String text)
{
// Complete the constructor definition
message = text;
}
public final void encrypt()
{
/* The message string is tokenized into individual words,
* and each word is encoded by calling the encode method
*/
encrypted_message = new StringBuffer();
StringTokenizer words = new StringTokenizer(message);
while(words.hasMoreTokens())
{
String s = words.nextToken();
s = encode(s) + " ";
encrypted_message.append(s);
}
}
public final void decrypt(String message)
{
/* The encoded message string is tokenized into individual words,
* and each word is encoded by calling the decode method
*/
// Supply the code that will decrypt the encrypted string
decrypted_message = new StringBuffer();
StringTokenizer words = new StringTokenizer(message);
while(words.hasMoreTokens())
{
String s = words.nextToken();
s = decode(s) + " ";
decrypted_message.append(s);
}
}

public String getEncodedMessage()
{
return encrypted_message.toString();
}
public String getDecodedMessage()
{
return decrypted_message.toString();
}
public abstract String encode(String s);
public abstract String decode(String s);
}

class Caeser extends Cipher
{
public Caeser(String s)
{
super(s);
}
public String encode(String word)
{
return code(word,Constants.ENCODE_SHIFT );
}
public String decode(String word)
{
// Complete this method so that it decodes the encoded string
return code(word,Constants.DECODE_SHIFT );
}
String code(String word, int SHIFT)
{
StringBuffer result = new StringBuffer();
for (int i = 0; i < word.length(); i++)
{
char ch = word.charAt(i);
ch = determineCharacter(ch, SHIFT);
result.append(ch);
}
return result.toString();
}
public char determineCharacter(char ch, final int shift)
{
if(Character.isUpperCase(ch))
ch = (char)('A' + (ch - 'A' + shift) % Constants.WRAP_AROUND);
// Complete the if/else so that lower case letters are accounted for
else if (Character.isLowerCase(ch))
ch = (char)('a' + (ch - 'a' + shift) % Constants.WRAP_AROUND);
return ch;
}
}

class Transpose extends Cipher
{
Transpose(String s)
{
super(s);
}
public String encode(String word)
{
StringBuffer result = new StringBuffer(word);
result.reverse();
return result.toString();
}
public String decode(String word)
{
// Complete this method so that it reverses the encoded string;
return encode(word);
}
}

class Reverser extends Transpose
{
public Reverser(String s)
{
// Complete the constructor
    super(s);
}
public String reverseText(String word)
{
// Complete this method so that it reverses the original string
StringBuffer reverse = new StringBuffer();
for (int i = word.length()-1; i > -1; i--) 
{
reverse.append(word.charAt(i));
}
return reverse.toString();
}

//public String decode(String word) No need to implement this method 
//{ The inherited method will be used as such
// Complete this method so that it reverses the reversed string
//}
}

interface Constants{
int WRAP_AROUND = 26;
int ENCODE_SHIFT = 3;
int DECODE_SHIFT = 23;
public abstract String encode(String s);
public abstract String decode(String s);
}

public class TestEncryption {
    public static void main(String arg[])
{
String code, output = "";
String text = JOptionPane.showInputDialog("Enter message");
output += "The original message is \n" + text + "\n";
Cipher c = new Caeser(text);
c.encrypt();
code = c.getEncodedMessage();
output += "\nCeasar Cipher\nThe encrypted message is \n" + code + "\n";
c.decrypt(code);
code = c.getDecodedMessage();
output +="The decrypted message is \n" + code + "\n";
c = new Transpose(text);
c.encrypt();
code = c.getEncodedMessage();
output += "\nTranspose\nThe encrypted Transpose message is \n" + code + "\n";
c.decrypt(code);
code = c.getDecodedMessage();
output +="The decripted Transpose message is \n" + code + "\n";
Reverser r = new Reverser(text);
r.encrypt();
//code = c.getEncodedMessage();
code =r.reverseText(code);
output += "\nReverser\nThe encrypted Reverse message is \n" + code+ "\n";
code = r.decode(code);
output+="The decrypted Reverse message is \n" + code;
display(output);
}
static void display(String s)
{
JOptionPane.showMessageDialog(null, s, "Encrypt/decrypt",
JOptionPane.INFORMATION_MESSAGE);
}
}

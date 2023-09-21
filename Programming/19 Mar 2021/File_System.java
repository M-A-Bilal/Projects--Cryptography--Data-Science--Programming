import javax.swing.*;
import java.io.IOException;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class BasicFile {
    File file;
    public BasicFile() {
        JFileChooser jf_choose = new JFileChooser("");
        int file_scenario = jf_choose.showOpenDialog(null);
        try {
            if (file_scenario != JFileChooser.APPROVE_OPTION) throw new IOException();
            file = jf_choose.getSelectedFile();
            if (!file.exists()) throw new FileNotFoundException();
        } catch (Exception e) {
            display(e.toString());
        }
    }
    File Read_File() {return file;}
    private void display(String msg) {JOptionPane.showMessageDialog(null, msg, null, JOptionPane.ERROR_MESSAGE);}
    void listRecursive(ArrayList<String> text) throws IOException {listRecursive(file.getParentFile(),text);}
    void listRecursive(File directory, ArrayList<String> text) throws IOException {
        if (directory.isDirectory()) {
            File[] file_array = directory.listFiles();
            System.out.println(file_array.length);
            for (File file : file_array) {
                if (file.isFile()) {
                    String msg = file.getAbsolutePath()+": Size = " + file.length() / 1024 + "  KiloBytes\n";
                    msg += Read_File_Lines(file);
                    text.add(msg);
                }
                else {
                    text.add(" Directory:  " + file.getName());
                    listRecursive(file, text);
                }
            }
        }
    }
    void Overwrite_File() throws IOException {
        System.out.println(" Enter input: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        FileWriter file_writer = null;
        BufferedWriter buffered_writer = null;
        try {
            file_writer = new FileWriter(file);
            buffered_writer = new BufferedWriter(file_writer);
            buffered_writer.write("Overwriting ");
            buffered_writer.write(input);
            buffered_writer.newLine();
            buffered_writer.close();
            System.out.println("Input saved ");
        } catch (Exception e) {
            System.out.println(" Operation failed");
        }
    }
    void Append_Text_To_File() throws IOException {
        System.out.println("Enter input: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        FileWriter file_writer = null;
        BufferedWriter buffered_writer = null;
        try {
            file_writer = new FileWriter(file, true);
            buffered_writer = new BufferedWriter(file_writer);
            buffered_writer.write(input);
            buffered_writer.newLine();
            buffered_writer.close();
            System.out.println("Input saved  ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    void Save_File() throws IOException {
        if(file.getName().contains(".txt")) {
            String get_path = file.getAbsolutePath();
            String create_file_name = get_path.substring(0,get_path.length()-4)+"_copy.txt";
            BufferedWriter buffered_writer = new BufferedWriter(new FileWriter(new File(create_file_name)));
            LineNumberReader line_number_reader = new LineNumberReader(new FileReader(Read_File()));
            String text = "";
            while ((text = line_number_reader.readLine()) != null) {
                buffered_writer.write(text, 0, text.length());
                buffered_writer.newLine();
            }
            buffered_writer.flush();
            buffered_writer.close();
        }
        else {
            FileInputStream file_input_stream = new FileInputStream(Read_File());
            String file_path = file.getAbsolutePath();
            int index = file_path.lastIndexOf(".");
            String extension = file_path.substring(index);
            String create_file_name = file_path.substring(0,index)+"_copy"+extension;
            FileOutputStream file_output_stream = new FileOutputStream(new File(create_file_name));
            byte[] buffer = new byte[1024];
            int i;
            while((i = file_input_stream.read(buffer)) > 0) {
                file_output_stream.write(buffer,0,i);
            }
            file_input_stream.close();
            file_output_stream.close();
        }
    }
    String Read_File_Lines(File file)throws IOException{
        BufferedReader buffered_reader = new BufferedReader(new FileReader(file));
        LineNumberReader line_number_reader = new LineNumberReader( buffered_reader);
        String text =" ",complete_line=" ";
        while ((text = line_number_reader.readLine()) != null) complete_line = complete_line + " line " + line_number_reader.getLineNumber()+ ": " + text + "\n";
        return complete_line;
    }
    void Text_Init(ArrayList<String> text){
        JTextArea jt_area = new JTextArea();
        JScrollPane js_pane = new JScrollPane(jt_area);
        for(int i = 0; i < text.size(); i++) jt_area.append(text.get(i));
        jt_area.setLineWrap(true);
        jt_area.setWrapStyleWord(true);
        js_pane.setPreferredSize( new Dimension( 200, 400 ) );
        JOptionPane.showMessageDialog(null, js_pane, "Contents:", JOptionPane.PLAIN_MESSAGE);
    }
    void File_Display( ) throws IOException {
        BufferedReader buffered_reader = new BufferedReader(new FileReader(file));
        ArrayList<String> text = new ArrayList<String>();
        String str;
        while((str= buffered_reader.readLine()) !=null) text.add(str+"\n");
        Text_Init(text);
    }
    void Search_Word() throws IOException {
        String str = "Enter word: ";
        String search_word = JOptionPane.showInputDialog(str);
        if(search_word != null) {
            BufferedReader buffered_reader = new BufferedReader(new FileReader(file));
            LineNumberReader line_number_reader = new LineNumberReader( buffered_reader);
            ArrayList<String> text = new ArrayList<String>();
            String line;
            while((line= line_number_reader.readLine()) !=null) {
                if(line.contains(search_word)) {
                    text.add("line "+line_number_reader.getLineNumber()+": "+line+"\n");
                }
            }
            Text_Init(text);
        }
    }
    void Tokenize() throws IOException {  
        FileReader file_reader = new FileReader(file);
        StreamTokenizer stream_tokenizer = new StreamTokenizer(file_reader);
        stream_tokenizer.eolIsSignificant(true);
        stream_tokenizer.wordChars('@','@');
        stream_tokenizer.wordChars('@','@');
        stream_tokenizer.wordChars(',',',');
        stream_tokenizer.wordChars('!','!');
        stream_tokenizer.lowerCaseMode(true);
        while(  stream_tokenizer.nextToken() !=StreamTokenizer.TT_EOF) {
            switch (stream_tokenizer.ttype){
                case StreamTokenizer.TT_WORD:
                    System.out.println(stream_tokenizer.sval);
                    break;
                case StreamTokenizer.TT_NUMBER:
                    System.out.println(stream_tokenizer.nval);
                    break;
                case StreamTokenizer.TT_EOL:
                    break;
                default:
                    System.out.println((char) stream_tokenizer.ttype + " __> not recognized");
            }
        }
    }
}

public class File_System {
    public static void main(String[] args) {
        boolean done =true;
        BasicFile basic_file = new BasicFile();
        while(done){
            String options = "Choose an option \n1.     Copy \n2.     Append \n3.     Overwrite \n4.     Attributes \n5.     Display \n6.     Search \n7.     Tokenize\n8.     Quit";
            String s = JOptionPane.showInputDialog(options);
            try{
                int i = Integer.parseInt(s);
                switch (i){
                    case 1:
                        basic_file.Save_File();
                        break;
                    case 2:
                        basic_file.Append_Text_To_File();
                        break;
                    case 3:
                        basic_file.Overwrite_File();
                        break;
                    case 4:
                        ArrayList<String> complete_lines = new ArrayList<String>();
                        basic_file.listRecursive(complete_lines);
                        basic_file.Text_Init(complete_lines);
                        break;
                    case 5:
                        basic_file.File_Display();
                        break;
                    case 6:
                        basic_file.Search_Word();
                        break;
                    case 7:
                        basic_file.Tokenize();
                        break;
                    case 8:
                        done=false;
                        break;
                    default:
                        System.out.println("Enter valid choice! ");
                        break;
                }
            } catch ( Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
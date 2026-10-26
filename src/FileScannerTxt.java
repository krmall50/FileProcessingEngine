import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FileScannerTxt implements Scannable {
    public List<String> scanFile(String path){
        if (!checkFormat(path)) return null;

        String text = "";
        ArrayList<String> result;

        try(FileInputStream file = new FileInputStream(path)){
                int i;
                while((i = file.read()) != -1){
                    text = text + (char) i;
                }
        }catch (IOException e){
            System.out.println("Enter correct file path.");
            return null;
        }

        result = new ArrayList<>(Arrays.asList(removeSpecialSymbols(text).split(" ")));
        return result.stream().filter(s -> !s.isBlank()).toList();
    }

    public String removeSpecialSymbols(String text){
        char[] chars = text.toCharArray();
        String result;
        
        for(int i = 0; i < chars.length; i++){
            if(isSpecial(chars[i])){
                chars[i] = ' ';
            }
        }
        result = new String(chars);
        return result;
    }
    public boolean isSpecial(char ch){
        if(ch == '.' || ch == ',' || ch == '/' || ch == '\n' || ch == '\\' || ch == '(' || ch == ')' || ch == '*' || ch == '|' || ch == '#' || ch == ':'){
            return true;
        }
        return false;
    }

    public boolean checkFormat(String path){
        if(path.endsWith(".pdf")){
            System.out.println("PDF format is not supported");
            return false;
        } else if(path.endsWith(".docx")){
            System.out.println("PDF format is not supported");
            return false;
        } else if(!path.endsWith(".txt")){
            System.out.println("Format is not supported");
            return false;
        }
        return true;
    }
}

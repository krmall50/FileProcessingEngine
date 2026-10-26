import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ProcessingService {
    public int countWords(String file){
        if(file.equals("")) return 0;
        
        file = file.replaceAll("[^A-Za-z0-9']", " ");
        file = file.replace("[\n]", " ");

        List<String> words = new ArrayList<>(Arrays.asList(file.split(" "))).stream().filter(s -> !s.equals("")).toList();
        System.out.println(words);
        
        return words.size();
    }

    public int countLines(String file){
        char[] charFile= file.toCharArray();
        int count = 0;
        for(char ch: charFile){
            if (ch == '\n'){
                count++;
            }
        }

        if(countWords(file) == 1 && count == 0) return 1;
        if(countWords(file) == 0 && count == 0) return 0;
        return count + 1;
    }
}

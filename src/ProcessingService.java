import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ProcessingService {
    public int countWords(String file){
        if(file.equals("")) return 0;

        List<String> words = getWords(file);        
        return words.size();
    }

    public int countUniqueWords(String file){
        if(countWords(file) == 0) return 0;
        return (int) getWords(file).stream().distinct().count();

    }
    public List<String> getWords(String file) {
        file = file.replaceAll("[^A-Za-z0-9']", " ").replace("[\n]", " ");
        return new ArrayList<>(Arrays.asList(file.split(" "))).stream().filter(s -> !s.equals("")).toList();
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

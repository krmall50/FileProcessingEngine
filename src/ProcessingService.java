import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ProcessingService {
    public int countWords(String file){
        if(file.equals("")) return 0;

        List<String> words = getWords(file);        
        return words.size();
    }

    public HashMap<String, Integer> mostFrequentWords(List<String> files){
        List<String> done = new ArrayList<>();
        List<String> words = new ArrayList<>();
        HashMap<String, Integer> wordCounts = new HashMap<>();
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();

        for(String file: files){
            words.addAll(getWords(file));
        }
        for (String word: words){
            if(done.contains(word)) continue;

            Integer count = (int) words.stream().filter((w) -> w.equals(word)).count();
            done.add(word);

            wordCounts.put(word, count);
        }
        for(int i = 0; i<4; i++){
            HashMap<String, Integer> max = maxCount(wordCounts);
            result.putAll(max);
            wordCounts.remove(max.keySet().toArray()[0]);
        }

        return result;
    }

    public HashMap<String, Integer> maxCount(HashMap<String, Integer> wordCounts) {
        HashMap<String, Integer> maxWordCounts = new HashMap<>();
        int max = 0;
        String fword = "";
        for(String word: wordCounts.keySet()){
            if(wordCounts.get(word) > max){
                max = wordCounts.get(word);
                fword = word;
            }
        }
        maxWordCounts.put(fword, max);
        return maxWordCounts;
    }
    public int countUniqueWords(String file){
        if(countWords(file) == 0) return 0;
        return (int) getWords(file).stream().distinct().count();

    }
    public int countUniqueWords(List<String> files){
        List<String> words = new ArrayList<>();
        for(String file: files){
            words.addAll(getWords(file));
        }
        return (int) words.stream().distinct().count();
    }
    
    public List<String> getWords(String file) {
        file = file.replaceAll("[^A-Za-z0-9']", " ").replace("[\n]", " ").toLowerCase();
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

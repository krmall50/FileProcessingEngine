import java.util.List;

public class FileStatistics {
    private List<String> fileContents;
    private int numberOfWords;
    private int numberOfLines;

    public FileStatistics(List<String> fileContents, int numberOfWords, int numberOfLines){
        this.fileContents = fileContents;
        this.numberOfWords = numberOfWords;
        this.numberOfLines = numberOfLines;
    }

    public void setFileContents(List<String> fileContents){
        this.fileContents = fileContents;
    }
    public void setNumberOfWords(int num){
        if(num >= 0) this.numberOfWords = num;
    }
    public void setNumberOfLines(int num){
        if(num >= 0) this.numberOfLines = num;
    }
    public List<String> getFileContents(){
        return fileContents;
    }
    public int getNumberOfWords(){
        return numberOfWords;
    }
    public int getNumberOfLines(){
        return numberOfLines;
    }
}

public class FileStatistics implements Comparable<FileStatistics> {
    private String fileContents;
    private int numberOfWords;
    private int numberOfLines;
    private int numberOfUniqueWords;

    public FileStatistics(String fileContents, int numberOfWords, int numberOfLines, int numberOfUniqueWords){
        this.fileContents = fileContents;
        this.numberOfWords = numberOfWords;
        this.numberOfLines = numberOfLines;
        this.numberOfUniqueWords = numberOfUniqueWords;
    }

    public void setFileContents(String fileContents){
        this.fileContents = fileContents;
    }
    public void setNumberOfWords(int num){
        if(num >= 0) this.numberOfWords = num;
    }
    public void setNumberOfUniqueWords(int num){
        if(num >= 0) this.numberOfUniqueWords = num;
    }
    public void setNumberOfLines(int num){
        if(num >= 0) this.numberOfLines = num;
    }
    public String getFileContents(){
        return fileContents;
    }
    public int getNumberOfWords(){
        return numberOfWords;
    }
    public int getNumberOfUniqueWords(){
        return numberOfUniqueWords;
    }
    public int getNumberOfLines(){
        return numberOfLines;
    }

    @Override 
    public int compareTo(FileStatistics stats){
        return getNumberOfWords() - stats.getNumberOfWords();
    }
}

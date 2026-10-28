public class FileStatistics implements Comparable<FileStatistics> {
    private String title;
    private String fileContents;
    private int numberOfWords;
    private int numberOfLines;
    private int numberOfUniqueWords;

    public FileStatistics(String title, String fileContents, int numberOfWords, int numberOfLines, int numberOfUniqueWords){
        this.title = title;
        this.fileContents = fileContents;
        this.numberOfWords = numberOfWords;
        this.numberOfLines = numberOfLines;
        this.numberOfUniqueWords = numberOfUniqueWords;
    }

    public void setFileContents(String fileContents){
        this.fileContents = fileContents;
    }
    public void setTitle(String title){
        this.title = title;
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
    public String getTitle(){
        return title;
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

    public void getDesc(){
        System.out.println("Title: "+getTitle() + "\n");
        System.out.println("Contents: "+getFileContents() + "\n");
        System.out.println("Words: "+getNumberOfWords() + "\n");
        System.out.println("Unique words: "+getNumberOfUniqueWords() + "\n");
        System.out.println("Lines: "+getNumberOfLines() + "\n-----------------------");
    }
    @Override 
    public int compareTo(FileStatistics stats){
        return getNumberOfWords() - stats.getNumberOfWords();
    }
}

public class FileProcesser {
    public FileStatistics processFile(String file){
        ProcessingService process = new ProcessingService();
        return new FileStatistics(file, process.countWords(file), process.countLines(file), process.countUniqueWords(file));
    }
}

import java.util.List;

public class FileProcesser {
    public FileStatistics processFile(List<String> file){
        ProcessingService process = new ProcessingService();
        return new FileStatistics(file, process.countWords(file), process.countLines(file));
    }
}

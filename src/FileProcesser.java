import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileProcesser {
    public synchronized FileStatistics processFile(FileStatistics file){
        ProcessingService process = new ProcessingService();
        file.setNumberOfWords(process.countWords(file.getFileContents()));
        file.setNumberOfUniqueWords(process.countUniqueWords(file.getFileContents()));
        file.setNumberOfLines(process.countLines(file.getFileContents()));
        return file;
    }

    public List<FileStatistics> processFiles(List<FileStatistics> files){
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<FileStatistics> stats = new ArrayList<>();

        Future<?> future = executor.submit(() -> {
            for(int i = 0; i< files.size(); i+=2){
                stats.add(processFile(files.get(i)));
            }
        });
        Future<?> future1 = executor.submit(() -> {
            for(int i = 1; i< files.size(); i+=2){
                stats.add(processFile(files.get(i)));
            }
        });
        
        try {
            future.get();
            future1.get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        executor.shutdown();
        return stats;
    }
}

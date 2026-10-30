import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileProcesser {
    public FileStatistics processFile(FileStatistics file){
        ProcessingService process = new ProcessingService();
        file.setNumberOfWords(process.countWords(file.getFileContents()));
        file.setNumberOfUniqueWords(process.countUniqueWords(file.getFileContents()));
        file.setNumberOfLines(process.countLines(file.getFileContents()));
        return file;
    }

    public List<FileStatistics> processFiles(List<FileStatistics> files){
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<FileStatistics> stats = new ArrayList<>();

        Future<List<FileStatistics>> future = executor.submit(() -> {
            List<FileStatistics> fstats = new ArrayList<>();

            for(int i = 0; i< files.size(); i+=2){         
                fstats.add(processFile(files.get(i)));
            }
            return fstats;
        });
        Future<List<FileStatistics>> future1 = executor.submit(() -> {
            List<FileStatistics> fstats = new ArrayList<>();

            for(int i = 1; i< files.size(); i+=2){
                fstats.add(processFile(files.get(i)));
            }
            return fstats;
        });
        
        try {
            stats.addAll(future.get());
            stats.addAll(future1.get());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(e.getMessage());
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        } finally{
            executor.shutdown();
        }

        executor.shutdown();
        return stats;
    }

}

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {
    public static void start() {
        FileScannerTxt fc = new FileScannerTxt();
        FileProcesser process = new FileProcesser();
        ProcessingService ps = new ProcessingService();
        ReportGenerator rg = new ReportGenerator();
        List<String> filesNames = new ArrayList<>();

        try {
            filesNames = getFileNames("input");
        } catch (NullPointerException e) {
            System.out.println("Couldn't find directory input\\");
            return;
        }
  
        List<FileStatistics> files = fc.scanFiles(filesNames);

        if(files.size() == 0) {
            System.out.println("No valid files found in directory input\\");
            return;
        }

        List<FileStatistics> stats = process.processFiles(files);
        HashMap<String, Integer> mfw = ps.mostFrequentWords(files);
        Integer globalUniqueWords = ps.countUniqueWords(files);
        Integer globalWords = ps.countWords(files);
        Integer globalLines = ps.countLines(files);

        Integer fileCount = filesNames.size();
        rg.generateReport(stats, mfw, globalUniqueWords, globalWords, globalLines, fileCount);       
        
    }
    public static List<String> getFileNames(String path){
        File folder = new File(path);
        List<String> files = new ArrayList<>();
        for(File file: folder.listFiles()){
            files.add(file.toString());
        }
        return files;
    }
}

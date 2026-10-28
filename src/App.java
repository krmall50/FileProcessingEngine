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

        List<String> filesNames = getFileNames("input");
        List<FileStatistics> files = fc.scanFiles(filesNames);

        List<FileStatistics> stats = process.processFiles(files);
        HashMap<String, Integer> mfw = ps.mostFrequentWords(files);
        int globalUniqueWords = ps.countUniqueWords(files);
        rg.generateReport(stats, mfw, globalUniqueWords);       
        
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

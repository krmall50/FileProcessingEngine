import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void start() {
        FileScannerTxt fc = new FileScannerTxt();
        FileProcesser process = new FileProcesser();
        ProcessingService ps = new ProcessingService();

        List<String> filesNames = getFileNames("input");
        List<String> files = fc.scanFiles(filesNames);
        System.out.println(ps.mostFrequentWords(files));
        
        //List<FileStatistics> stats = process.processFiles(files);

        
        
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

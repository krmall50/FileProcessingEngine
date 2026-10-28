import java.util.HashMap;
import java.util.List;

public class ReportGenerator {
    public void generateReport(List<FileStatistics> stats, HashMap<String, Integer> mfw, int globalUniqueWords){
        for(FileStatistics stat: stats){
            stat.getDesc();
        }
        System.out.println("------");
        System.out.println(mfw);
        System.out.println("------");
        System.out.println(globalUniqueWords);
    }
}

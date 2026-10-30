import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

public class ReportGenerator {
    public void generateReport(List<FileStatistics> stats, HashMap<String, Integer> mfw, Integer globalUniqueWords, Integer globalWords, Integer globalLines, Integer fileCount){
        if(stats.size() == 0){
            System.out.println("No valid files found.");
            return;
        }

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_hh-mm-ss");
        String formattedDate = dateTime.format(formatter);
        String filename = "";
        final Integer failedCount = fileCount - (Integer)stats.size();
        final Integer processedFileCount = (Integer)stats.size();

        try {
            File file = new File("output/output-" + formattedDate + ".txt");
            filename = "output/" + file.getName();
            if(file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.write("========== PROCESSING REPORT ==========");
            bw.newLine();
            bw.write("Files discovered: ");
            bw.write(fileCount.toString());

            bw.newLine();
            bw.write("Files processed successfully: ");
            bw.write(processedFileCount.toString());

            bw.newLine();
            bw.write("Files failed: ");
            bw.write(failedCount.toString());

            bw.write("\n\nTOTAL STATISTICS\n");
            bw.write("Lines: " + globalLines.toString() + "\n");
            bw.write("Words: " + globalWords.toString() + "\n");
            bw.write("Unique Words: " + globalUniqueWords.toString());

            bw.write("\n\nMOST FREQUENT WORDS\n");
            for (String word: mfw.keySet()){
                bw.write(word + ": " + mfw.get(word) + "\n");
            }

            bw.write("\nFILE STATISTICS\n");
            for(FileStatistics stat: stats){
                bw.write(stat.getTitle() + "\n");
                bw.write("  Lines: " + stat.getNumberOfLines() + "\n");
                bw.write("  Words: " + stat.getNumberOfWords() + "\n");
                bw.write("  Unique words: " + stat.getNumberOfUniqueWords() + "\n\n");
            }

            bw.write("File with most words: " + stats.stream().sorted().toList().getLast().getTitle());
        } catch (IOException e) {
            e.getStackTrace();
        }
        System.out.println("Report saved to: " + filename);
    }
    
}

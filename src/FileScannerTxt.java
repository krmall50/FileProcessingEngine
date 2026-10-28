import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileScannerTxt implements Scannable {

    @Override 
    public FileStatistics scanFile(String path){
        if (!checkFormat(path)) return null;

        String text = "";
        try(FileInputStream file = new FileInputStream(path)){
                int i;
                while((i = file.read()) != -1){
                    text = text + (char) i;
                }
        }catch (IOException e){
            System.out.println("Enter correct file path.");
            return null;
        }
        FileStatistics stat = new FileStatistics(path, text, 0, 0, 0);
        return stat;
    }
    public List<FileStatistics> scanFiles(List<String> paths){
        List<FileStatistics> files = new ArrayList<>();
        for(String path: paths){
            if(scanFile(path) != null) files.add(scanFile(path));
        }
        return files;
    }

    public boolean checkFormat(String path){
        if(path.endsWith(".pdf")){
            System.out.println("PDF format is not supported");
            return false;
        } else if(path.endsWith(".docx")){
            System.out.println("DOCX format is not supported");
            return false;
        } else if(!path.endsWith(".txt")){
            System.out.println("Format is not supported: " + path);
            return false;
        }
        return true;
    }
}

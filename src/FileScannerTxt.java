import java.io.FileInputStream;
import java.io.IOException;

public class FileScannerTxt implements Scannable {
    public String scanFile(String path){
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
        //result = new ArrayList<>(Arrays.asList(text.split(" ")));
        //return result.stream().filter(s -> !s.isBlank()).toList();
        return text;
    }


    public boolean checkFormat(String path){
        if(path.endsWith(".pdf")){
            System.out.println("PDF format is not supported");
            return false;
        } else if(path.endsWith(".docx")){
            System.out.println("DOCX format is not supported");
            return false;
        } else if(!path.endsWith(".txt")){
            System.out.println("Format is not supported");
            return false;
        }
        return true;
    }
}

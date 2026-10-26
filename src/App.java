import java.util.List;

public class App {
    public static void start() {
        System.out.println("starting app...");

        FileScannerTxt fc = new FileScannerTxt();
        List<String> res = fc.scanFile("input/text.txt");
        if (res == null){
            return;
        }
        res.stream().forEach(s -> System.out.println(s));
    }
}

import java.util.List;

public class App {
    public static void start() {
        System.out.println("starting app...");

        FileScanner fc = new FileScanner();
        List<String> res = fc.scanFile("input/text.txt");
        res.stream().forEach(s -> System.out.println(s));
    }
}

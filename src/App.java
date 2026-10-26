import java.util.List;

public class App {
    public static void start() {
        System.out.println("starting app...");

        FileScanner fc = new FileScanner();
        List<String> res = fc.scanFile("input/text3.pdf");
        if (res == null){
            System.out.println("Something went wrong.");
            return;
        }
        res.stream().forEach(s -> System.out.println(s));
    }
}

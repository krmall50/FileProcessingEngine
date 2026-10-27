public class App {
    public static void start() {
        System.out.println("starting app...");

        FileScannerTxt fc = new FileScannerTxt();
        String res = fc.scanFile("input/text.txt");
        if (res == null){
            return;
        }
        FileProcesser process = new FileProcesser();
        FileStatistics stats = process.processFile(res);
        System.out.println("Lines: " + stats.getNumberOfLines());
        System.out.println("Words: " + stats.getNumberOfWords());
        System.out.println("Unique words: " + stats.getNumberOfUniqueWords());
        // System.out.println("File: ");
        // res.stream().forEach(System.out::println);
    }
}

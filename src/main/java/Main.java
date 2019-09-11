import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FilePartReader myReader = new FilePartReader("Reader01");
        String path = "/home/john/Codecool/GIT/filepartreader-testing-with-junit-JanosKrizsan/src/main/resources/shakespeare.txt";
        myReader.setup(path, 1, 20);
        myReader.read();
        myReader.readLines();

        FileWordAnalyzer myAnalizator = new FileWordAnalyzer(myReader);

        System.out.println(myAnalizator.getWordsWhichPalindromes());
        System.out.println(myAnalizator.getWordsContainingSubString("o"));
        System.out.println(myAnalizator.getWordsOrderedAlphabetically());

    }
}

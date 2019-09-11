import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {

    private final FilePartReader filePartReader;
    private List<String> readFile;

    public FileWordAnalyzer(FilePartReader filePartReader) throws IOException {
        this.filePartReader = filePartReader;
        this.readFile = Arrays.asList(filePartReader.readLines().split(" "));
    }

    public List getWordsOrderedAlphabetically() {
        return readFile.stream().sorted().collect(Collectors.toList());
    }

    public List getWordsContainingSubString(String subString) {
        return readFile.stream().filter(word -> word.contains(subString)).collect(Collectors.toList());
    }

    private boolean isWordPalindrome(String word) {
        String checkedWord = word.replaceAll("\\s+", "").toLowerCase();
        StringBuffer normal = new StringBuffer(checkedWord);
        StringBuffer reverse = normal.reverse();
        return reverse.reverse().toString().equals(checkedWord);
    }

    public List getWordsWhichPalindromes() {
        return readFile.stream().filter(this::isWordPalindrome).collect(Collectors.toList());
    }

}

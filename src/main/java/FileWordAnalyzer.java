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

    /**
     * Cleans a word for better visibility.
     * Call by adding .(map::cleanWord).filter(word -> !word.equals("")) to the stream
     *
     * @param word, the word which you wish to clean
     * @return cleaned of white spaces and special characters
     */
    private String cleanWord(String word) {
        return word.replaceAll("[^a-zA-Z]+", "").trim();
    }

    public List getWordsOrderedAlphabetically() {
        return readFile.stream().map(this::cleanWord).filter(word -> !word.equals("")).sorted().collect(Collectors.toList());
    }

    public List getWordsContainingSubString(String subString) {
        return readFile.stream().map(this::cleanWord).filter(word -> !word.equals("")).filter(word -> word.contains(subString)).collect(Collectors.toList());
    }

    private boolean isWordPalindrome(String word) {
        String checkedWord = word.replaceAll("\\s+", "").toLowerCase();
        StringBuffer normal = new StringBuffer(checkedWord);
        StringBuffer reverse = normal.reverse();
        return reverse.reverse().toString().equals(checkedWord);
    }

    public List getWordsWhichPalindromes() {
        return readFile.stream().map(this::cleanWord).filter(word -> !word.equals("")).filter(this::isWordPalindrome).collect(Collectors.toList());
    }

}

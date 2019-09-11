import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Analyzer Tests")
class FileWordAnalyzerTest {

    private String path = "/home/john/Codecool/GIT/filepartreader-testing-with-junit-JanosKrizsan/src/main/resources/test.txt";
    private FileWordAnalyzer fw;


    @Test
    public void testGetWordsInAplhabeticalOrder() throws IOException {
        String testCase = "[alpha, beta, delta, gamma, gog, omega]";
        FilePartReader fp = new FilePartReader("Test01");
        fp.setup(path, 1, 20);
        fw = new FileWordAnalyzer(fp);
        String result = fw.getWordsOrderedAlphabetically().toString();
        assertEquals(testCase, result);
    }


    @Test
    public void testGetWordsContainingSubstring() throws IOException {
        String testCase = "[alpha]";
        FilePartReader fp = new FilePartReader("Test02");
        fp.setup(path, 1, 20);
        fw = new FileWordAnalyzer(fp);
        String result = fw.getWordsContainingSubString("alpha").toString();
        assertEquals(testCase, result);
    }

    @Test
    public void testGetWordsWithPalindromes() throws IOException {
        String testCase = "[gog]";
        FilePartReader fp = new FilePartReader("Test02");
        fp.setup(path, 1, 20);
        fw = new FileWordAnalyzer(fp);
        String result = fw.getWordsWhichPalindromes().toString();
        assertEquals(testCase, result);
    }
}
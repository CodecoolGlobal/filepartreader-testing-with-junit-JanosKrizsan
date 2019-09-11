import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("File Reader Tests")
class FilePartReaderTest {

    private String path = "/home/john/Codecool/GIT/filepartreader-testing-with-junit-JanosKrizsan/src/main/resources/test.txt";


    @Test
    public void testIsNameValidThrowsInvalidException(){
        assertThrows(InvalidParameterException.class, () -> new FilePartReader("Invalid"));
    }

    @Test
    public void testAreParametersValidThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            FilePartReader fp = new FilePartReader("Valid");
            fp.setup(path, -2, -4);
        });
    }

    @Test
    public void testReadFile() throws IOException {
        String testCase = "[alpha, gamma, beta, delta, omega, gog]";
        FilePartReader fp = new FilePartReader("TestRead");
        fp.setup(path, 1, 20);
        String result = fp.read();
        assertEquals(testCase, result);
    }

    @Test
    public void testReadLine() throws IOException {
        String testCase = "[alpha]";
        FilePartReader fp = new FilePartReader("TestRead");
        fp.setup(path, 1, 1);
        String result = fp.readLines();
    }
}
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilePartReader {

    private String name;
    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader(String name) {
        if (name.equals("Invalid")) {
            throw new InvalidParameterException("Invalid is invalid");
        }
        this.name = name;
    }

    public void setup(String filePath, int fromLine, int toLine) {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException("To line should be larger or from line greater.");
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;

    }

    public String read() throws IOException {
        List<String> readFile = Files.readAllLines(Paths.get(filePath));
        return readFile.toString();
    }

    public String readLines() throws IOException {
        String readFile = read().trim();
        List<String> lines = Arrays.asList(readFile.split("\\r?[^a-zA-Z]+"));
        if (fromLine == 1 && toLine == 1) {
            return lines.get(0);
        }
        List<String> result = new ArrayList<>();
        int lineCounter = 1;
        for (String line : lines) {
            if (lineCounter > fromLine && lineCounter < toLine) {
                result.add(line);
            }
            lineCounter++;
        }
        return result.toString();
    }
}

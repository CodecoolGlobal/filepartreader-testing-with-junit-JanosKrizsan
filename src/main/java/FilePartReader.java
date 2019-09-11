import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilePartReader {

    private String name;
    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader(String name) {
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
        FileReader readFile = new FileReader(filePath);
        return readFile.toString();
    }

    public String readLines() throws IOException {
        String readFile = read();
        List<String> lines = Arrays.asList(readFile.split("\\r?\\n"));
        if (fromLine == 1 && toLine ==1) {
            return lines.get(0);
        }
        List<String> result = new ArrayList<>();
        int lineCounter = 1;
        while (lineCounter != toLine) {
            for (String line : lines) {
                if (lineCounter > fromLine) {
                    result.add(line);
                }
                lineCounter++;
            }
        }
        return result.toString();
    }
}

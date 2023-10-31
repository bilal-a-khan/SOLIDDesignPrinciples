package fileHandler;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {

    private String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    public String readFile() throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }


}

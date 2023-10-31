package fileHandler;

import java.io.IOException;

public class FileWriter {

    private String fileName;

    public FileWriter(String fileName) {
        this.fileName = fileName;
    }

    public void writeFile(String content) throws IOException {
        try (java.io.FileWriter writer = new java.io.FileWriter(fileName)) {
            writer.write(content);
        }
    }

}

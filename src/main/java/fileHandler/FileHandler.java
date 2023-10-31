package fileHandler;

import java.io.BufferedReader;
import java.io.IOException;


import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.util.Iterator;

public class FileHandler {

//    private String filename;
//
//    public FileHandler(String filename) {
//        this.filename = filename;
//    }


    public static void main(String[] args) {
        String fileName = "src/main/resources/sample.txt";

        boolean writeFile = false;

        try {
            FileReader fileReader = new FileReader(fileName);
            String content = fileReader.readFile();

            System.out.println(content);

            if (content.isBlank()) {
                writeFile = true;
            } else {
                System.out.println("File is not blank. Writing operation will not occur");
            }

            while (writeFile) {
                String jsonContent = "{\"name\": \"John\", \"age\": 30}";

                ContentFormatter contentFormatter = new ContentFormatter();
                String xmlContent = contentFormatter.jsonToXml(jsonContent);

                FileWriter fileWriter = new FileWriter(fileName);
                fileWriter.writeFile(xmlContent);
                System.out.println(xmlContent);

                writeFile = false;
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


//        try {
//            FileHandler handler = new FileHandler("src/main/resources/sample.txt");
//            String content = handler.readFile();
//            System.out.println(content);
//
//            String jsonContent = "{\"name\": \"John\", \"age\": 30}";
//            String xmlContent = handler.jsonToXml(jsonContent);
//
//            handler.writeFile(xmlContent);
//            System.out.println(xmlContent);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}

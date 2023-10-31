package fileHandler;

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

public class ContentFormatter {

    public String jsonToXml(String jsonContent) throws Exception {
        // Using org.json for JSON parsing.
        JSONObject json = new JSONObject(jsonContent);
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("root");
        doc.appendChild(rootElement);

        Iterator<String> keys = json.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Element keyElement = doc.createElement(key);
            keyElement.appendChild(doc.createTextNode(json.get(key).toString()));
            rootElement.appendChild(keyElement);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);

        java.io.StringWriter writer = new java.io.StringWriter();
        StreamResult result = new StreamResult(writer);

        transformer.transform(source, result);
        return writer.toString();
    }


}

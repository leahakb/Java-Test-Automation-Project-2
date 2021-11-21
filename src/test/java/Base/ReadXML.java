package Base;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;



public class ReadXML {

    public static String getData(String keyName) throws Exception {
        ClassLoader classLoader = DriverSingleton.class.getClassLoader();
        String file_path = "C:\\Users\\Yelena\\IdeaProjects\\Automation Java Project 2 - Buyme site\\src\\main\\resources\\data.xml";
        File fXmlFile = new File(file_path);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();

        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
}
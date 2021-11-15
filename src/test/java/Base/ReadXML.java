package Base;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class ReadXML {
    public static void main(String argv[]) {
    }

    public void read() {
        File file = new File("C:\\Users\\Yelena\\IdeaProjects\\Automation Java Project 2 - Buyme site\\src\\test\\java\\Extras\\data");
        DocumentBuilderFactory data = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = data.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList browserList = doc.getElementsByTagName("browser");
            System.out.println(browserList);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
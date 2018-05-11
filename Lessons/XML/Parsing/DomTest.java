package by.lesson20;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DomTest {
    public static void main(String [] args){
        try (FileInputStream fis = new FileInputStream("d:/librarium2.xml")) {

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(fis);
            Node node =  document.getElementsByTagName("library").item(0);
            System.out.println(node.getAttributes().item(0));
            System.out.println(document.getDocumentElement().getTagName());
            System.out.println(document.getDocumentElement().getAttribute("owner"));
            System.out.println(document.getDocumentElement().getFirstChild().getNodeName());
            System.out.println(document.getDocumentElement().getFirstChild().getFirstChild().getNodeName());

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }


    }
}

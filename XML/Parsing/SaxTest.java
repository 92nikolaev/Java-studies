package by.lesson22;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SaxTest {

    public static void main (String[] args){

        try (FileInputStream fis = new FileInputStream("d:/librarium2.xml")) {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyContentHandler());
            InputSource inputSource = new InputSource(fis);
            reader.parse(inputSource);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler extends DefaultHandler{
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
       // System.out.println(" LocalName "+localName+" qName "+qName);  //all
        for(int i=0; i<attributes.getLength();i++) {
            if (attributes.getLocalName(i).equalsIgnoreCase("author")) {
                System.out.println("\t" + attributes.getLocalName(i) + ":" + attributes.getValue(i)); //!!!!! author only
            }
        }
    }
}

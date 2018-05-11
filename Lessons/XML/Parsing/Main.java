package com.gmail.slshukevitch.homework15.task11;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream("d:/task7.xml"));
        String unit = null;
        boolean isX = false;
        boolean isY = false;
        while (reader.hasNext()) {
            int res = reader.next();
            if (res == reader.START_ELEMENT) {
                if (reader.getLocalName().equals("x")) {
                    isX = true;
                }
                if (reader.getLocalName().equals("y")) {
                    isY = true;
                } else if ("point".equals(reader.getLocalName())) {
                    unit = reader.getAttributeValue(null, "unit").replaceAll("[^a-zA-Z ]", "").toLowerCase();
                    //System.out.println(unit);
                }
            } else if (res == reader.CHARACTERS) {
                if (isX) {
                    System.out.print(reader.getText().replaceAll("[^0-9 ]", "") + " " + unit + ", ");
                    isX = false;
                }

                if (isY) {
                    System.out.print(reader.getText().replaceAll("[^0-9 ]", "") + " " + unit + "\n");
                    isY = false;
                }

            }
        }
    }
}


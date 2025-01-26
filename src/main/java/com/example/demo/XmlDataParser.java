package com.example.demo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlDataParser {

    public static void main(String[] args) {
        // Path to the XML file
        String xmlFilePath = "src/main/resources/testdata/testdata.xml";

        // ---------------------------------------------------------
        // Parse XML Data (testdata.xml)
        // ---------------------------------------------------------
        try {
            File xmlFile = new File(xmlFilePath);

            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file into a DOM Document
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            // Get the root element
            Element root = document.getDocumentElement();
            System.out.println("Root element: " + root.getNodeName());

            // Extract values from the XML file
            String loginUrl = root.getElementsByTagName("loginUrl").item(0).getTextContent();
            String invalidUsername = root.getElementsByTagName("invalidUsername").item(0).getTextContent();
            String invalidPassword = root.getElementsByTagName("invalidPassword").item(0).getTextContent();

            // Print extracted values
            System.out.println("XML loginUrl:  " + loginUrl);
            System.out.println("XML username:  " + invalidUsername);
            System.out.println("XML password:  " + invalidPassword);
        } catch (Exception e) {
            System.err.println("Error parsing XML file: " + e.getMessage());
        }
    }
}

package groszewicz.me.unsheet;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Format {
    public static Document format (String[][] data) {
        Document document = create();
        if (document == null) {
            return null;
        }
        
        String rootName = Query.ask("Enter root element name:");
        Element root = document.createElement(rootName);
        document.appendChild(root);
        
        for (int i = 1; i < data.length; i++) {
            Element rowElement = document.createElement(data[0][0]);
            root.appendChild(rowElement);
            
            for (int j = 0; j < data[0].length; j++) {
                Element columnElement =
                        document.createElement(data[0][j]);
                columnElement.appendChild(document.createTextNode(data[i][j]));
                rowElement.appendChild(columnElement);
            }
        }
        
        return document;
    }
    
    private static Document create() {
        try {
            DocumentBuilderFactory documentFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder =
                    documentFactory.newDocumentBuilder();
            return documentBuilder.newDocument();
        } catch (ParserConfigurationException e) {
            return null;
        }
    }
}

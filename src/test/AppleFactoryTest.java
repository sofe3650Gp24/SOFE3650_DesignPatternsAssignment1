package test;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class AppleFactoryTest{

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder insert = factory.newDocumentBuilder();

            Document doc = insert.parse(new File("C:\\Users\\Faraaz\\Desktop\\SOFD\\Assignment1\\src\\applestoredata.xml"));

            NodeList productList = doc.getElementsByTagName("product");

            System.out.println("Apple Inventory:" + "\n");

            for(int x = 0; x < productList.getLength(); x++) {

                Node product = productList.item(x);

                if(product.getNodeType() == Node.ELEMENT_NODE) {

                    Element productElement = (Element) product;
                    System.out.println("Product: " + productElement.getAttribute("name"));

                NodeList productPrice = product.getChildNodes();
                for(int z = 0; z < productPrice.getLength(); z++) {
                    Node price = productPrice.item(z);

                    if(price.getNodeType() == Node.ELEMENT_NODE) {
                        Element priceElement = (Element) price;
                        System.out.println("Price: $" + priceElement.getAttribute("value"));
                    }
                }

                }
            }

        } catch (ParserConfigurationException | IOException | SAXException q) {
            q.printStackTrace();
        }

    }
}

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class JaxpReadExample {
    public static void main(String[] args) {
        try {
            // Load XML file
            File inputFile = new File("example.xml");

            // Create a new instance of DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a new instance of DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file and normalize
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Print the id attribute of the root element
            System.out.println("\nLớp: " +  doc.getDocumentElement().getAttribute("id"));
            System.out.println("--------------------------------------------------------\n");

            // Get all lecturer elements
            NodeList teacherList = doc.getElementsByTagName("lecturer");
            for (int i = 0; i < teacherList.getLength(); i++) {
                Node nNode = teacherList.item(i);
                // If the node is an Element node
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Tên: " 
                       + eElement
                       .getElementsByTagName("name")
                       .item(0)
                       .getTextContent());
                    System.out.println("Chức vụ: giảng viên (" + nNode.getNodeName() + ")\n");
                }
            }
            System.out.println("--------------------------------------------------------\n");
            // Get all student elements
            NodeList nList = doc.getElementsByTagName("student");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                // If the node is an Element node
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Tên: " 
                       + eElement
                       .getElementsByTagName("name")
                       .item(0)
                       .getTextContent());
                    System.out.println("MSSV: " 
                       + eElement
                       .getElementsByTagName("id")
                       .item(0)
                       .getTextContent());
                    System.out.println("Nhóm: " 
                       + eElement.getAttribute("group"));
                    System.out.println("Chức vụ: sinh viên (" + nNode.getNodeName() + ")\n");
                }
            }
        } catch (Exception e) {
            // Print stack trace for any exceptions
            e.printStackTrace();
        }
    }
}
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class JaxpWriteExample {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element classElement = doc.createElement("class");
            classElement.setAttribute("id", "Ngôn ngữ lập trình Java - SE330.O21.PMCL");
            doc.appendChild(classElement);

            // lecturer element
            Element lecturer = doc.createElement("lecturer");
            Element lecturerName = doc.createElement("name");
            lecturerName.appendChild(doc.createTextNode("Nguyễn Duy Khánh"));
            lecturer.appendChild(lecturerName);
            classElement.appendChild(lecturer);

            // student element
            Element student1 = doc.createElement("student");
            student1.setAttribute("group", "6");
            Element student1Name = doc.createElement("name");
            student1Name.appendChild(doc.createTextNode("Phan Quốc Tuấn"));
            student1.appendChild(student1Name);
            Element student1Id = doc.createElement("id");
            student1Id.appendChild(doc.createTextNode("21521637"));
            student1.appendChild(student1Id);
            classElement.appendChild(student1);

            Element student2 = doc.createElement("student");
            student2.setAttribute("group", "6");
            Element student2Name = doc.createElement("name");
            student2Name.appendChild(doc.createTextNode("Trần Tiến Đạt"));
            student2.appendChild(student2Name);
            Element student2Id = doc.createElement("id");
            student2Id.appendChild(doc.createTextNode("21521951"));
            student2.appendChild(student2Id);
            classElement.appendChild(student2);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("exampleWrite.xml"));

            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package in.sts.excelutility.files;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXMLFile {
	final Logger log = Logger.getLogger(ReadXMLFile.class);

	public void readXML() {

		Scanner fileInput = null;

		try {

			fileInput = new Scanner(System.in);
			System.out.println("Enter the filename: ");
			String fileName = fileInput.nextLine();

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse("C:\\Users\\kalyani.patil\\eclipse-workspace\\ExcelUtility\\" + fileName + ".xml");
			NodeList list = document.getElementsByTagName("student");
			HashSet<StudentDetails> uniqueSet = new HashSet<StudentDetails>();

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				Element element = (Element) node;

				StudentDetails studentDetails = new StudentDetails();
				studentDetails.setFirstName(element.getElementsByTagName("firstName").item(0).getTextContent());
				studentDetails.setMiddleName(element.getElementsByTagName("middleName").item(0).getTextContent());
				studentDetails.setLastName(element.getElementsByTagName("lastName").item(0).getTextContent());
				studentDetails.setBranch(element.getElementsByTagName("branch").item(0).getTextContent());
				
				uniqueSet.add(studentDetails);
			}
			log.info("Unique data from XML file: ");
			for (StudentDetails students : uniqueSet) {
				log.info(students);
			}
		}

		catch (SAXException exception) {
			System.out.println("Error in parsin.." + exception.getMessage());

		} catch (IOException exception) {
			System.out.println("Data Not Found..!");

			readXML();

		} catch (ParserConfigurationException exception) {
			System.out.println("Parsing error.." + exception.getMessage());
		}

		finally {
			if (fileInput != null)
				fileInput.close();

		}

	}

}

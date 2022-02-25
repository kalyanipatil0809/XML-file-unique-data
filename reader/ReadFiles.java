package in.sts.excelutilty.reader;

import java.util.Scanner;
import org.apache.log4j.Logger;

import in.sts.excelutility.files.ReadExcelFile;
import in.sts.excelutility.files.ReadExcelTable;
import in.sts.excelutility.files.ReadText;
import in.sts.excelutility.files.ReadTextTable;
import in.sts.excelutility.files.ReadXMLFile;

public class ReadFiles {
	final Logger log = Logger.getLogger(ReadFiles.class);

	public void readUniqueData() {

		Scanner selectcase = new Scanner(System.in);
		System.out.println("Select 1 to read the Text file");
		System.out.println("Select 2 to read the Excel file");
		System.out.println("Select 3 to read the XML file");
		System.out.println("select 4 for read table from Text file");
		System.out.println("select 5 for read table from Excel file");

		int select = selectcase.nextInt();

		switch (select) {
		case 1:

			ReadText readText = new ReadText();
			readText.readText();

			break;

		case 2:
			ReadExcelFile readExcelFile = new ReadExcelFile();
			readExcelFile.readExcel();

			break;

		case 3:
			ReadXMLFile readeXmlFile = new ReadXMLFile();
			readeXmlFile.readXML();
		

			break;
			
		case 4:
			ReadTextTable readTextTable = new ReadTextTable();
			readTextTable.readTable();

			break;
			
		case 5:
			ReadExcelTable readExcelTable  = new ReadExcelTable();
			readExcelTable.readExcel();

			break;

		}
		selectcase.close();

	}

}

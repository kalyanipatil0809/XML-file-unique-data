package in.sts.excelutility.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelTable {
	final Logger log = Logger.getLogger(ReadExcelTable.class);

	public void readExcel() {

		Scanner fileInput = null;
		StudentDetails studentDetails = new StudentDetails();
		ArrayList<StudentDetails> arrayList = new ArrayList<StudentDetails>();
		HashSet<StudentDetails> uniqueSet = new HashSet<StudentDetails>();

		try {
			fileInput = new Scanner(System.in);
			System.out.println("Enter the filename: ");
			String fileName = fileInput.nextLine();
			FileInputStream inputStream = new FileInputStream("F:\\" + fileName + ".xlsx"); 

			Workbook workBook = new XSSFWorkbook(inputStream);
			DataFormatter dataFormatter = new DataFormatter();
			Iterator<Sheet> sheet1 = workBook.sheetIterator();

			while (sheet1.hasNext()) {
				Sheet sh = sheet1.next();
				System.out.println("Sheet Name is: " + sh.getSheetName());

				Iterator<Row> iterator = sh.iterator();
				while (iterator.hasNext()) {
					Row row = iterator.next();
					Iterator<Cell> cellIterator = row.iterator();

					int count = 1;

					String firstName = null;
					String middleName = null;
					String lastName = null;
					String branch = null;

					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (count) {

						case 1:

							firstName = dataFormatter.formatCellValue(cell);
							studentDetails.setFirstName(firstName);
							count++;
							break;

						case 2:

							middleName = dataFormatter.formatCellValue(cell);
							studentDetails.setMiddleName(middleName);
							count++;
							break;

						case 3:

							lastName = dataFormatter.formatCellValue(cell);
							studentDetails.setLastName(lastName);
							count++;

							break;

						case 4:

							branch = dataFormatter.formatCellValue(cell);
							studentDetails.setBranch(branch);
							count++;
							break;
						}

						firstName = studentDetails.getFirstName();
						middleName = studentDetails.getMiddleName();
						lastName = studentDetails.getLastName();
						branch = studentDetails.getBranch();

					}
					StudentDetails studentName = new StudentDetails(firstName,middleName,lastName,branch); 
					arrayList.add(studentName);

				}
			}

			for (StudentDetails students : arrayList) {

				uniqueSet.add(students);

			}
			for (StudentDetails studentList : uniqueSet) {

				studentList.getFirstName();
				studentList.getMiddleName();
				studentList.getLastName();
				studentList.getBranch();
				System.out.println(studentList);

			}
			workBook.close();

		} catch (FileNotFoundException exception) {
			System.out.println("Please enter the correct file name..!");

			readExcel();
		} catch (IOException exception) {
			System.out.println("Data Not Found");
		} finally {
			if (fileInput != null)
				fileInput.close();

		}

	}
}
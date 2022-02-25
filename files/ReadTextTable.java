package in.sts.excelutility.files;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class ReadTextTable {
	final Logger log = Logger.getLogger(ReadTextTable.class);

	public void readTable() {
		Scanner fileInput = null;
		Scanner scanner = null;

		HashSet<StudentDetails> uniqueSet = new HashSet<StudentDetails>();

		try {
			fileInput = new Scanner(System.in);
			System.out.println("Enter the filename: ");

			String fileName = fileInput.nextLine();
			File file = new File("F:\\" + fileName + ".txt"); 
			FileReader fileReader = new FileReader(file);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {

				StudentDetails studentDetails = new StudentDetails();

				String s[] = line.split("\t\t");

				studentDetails.setFirstName(s[0]);
				studentDetails.setMiddleName(s[1]);
				studentDetails.setLastName(s[2]);
				studentDetails.setBranch(s[3] + "\n");

				uniqueSet.add(studentDetails);

			}
			System.out.print(uniqueSet);
			fileReader.close();

		} catch (IOException e) {
			System.out.println("Data Not Found..!");
		} finally {
			if (fileInput != null)
				fileInput.close();

			if (scanner != null)
				scanner.close();

		}
	}

}

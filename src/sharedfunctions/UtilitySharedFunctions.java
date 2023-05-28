package sharedfunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilitySharedFunctions {
	public static void evidencefilecreator(String filename, String requestbody, String responsebody) throws IOException
	{
		File newfile = new File("D:\\Neha\\Personal\\MSSquare\\REST Assured\\Evidence files"+filename+".txt");
		System.out.println("A new text file created to record request and response of the API : " +newfile.getName());
		
		FileWriter datawrite = new FileWriter(newfile);
		datawrite.write("Request body :" +requestbody+"/n/n" ); 
		datawrite.write("Response body :" +responsebody);
		datawrite.close();
		System.out.println("Request body and Response body are saved in :" +newfile.getName() );	
	}
	
	public static ArrayList<String> readdataexcel(String sheetname, String testcasename) throws IOException
	{
		ArrayList<String> arrayData=new ArrayList<String>();
		
		//Step 1 : Create the object of file input stream
		FileInputStream fis = new FileInputStream("D:\\Neha\\Personal\\MSSquare\\REST Assured\\Post_TC.xlsx");
		
		//Step 2:Access the excel file
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		//Step 3: Access the sheet name
		int countofsheet = workbook.getNumberOfSheets();
		for(int i=0; i<countofsheet; i++)
		{String filesheetname=workbook.getSheetName(i);
		if(filesheetname.equalsIgnoreCase(sheetname));
		{
			//Step 4 : Access the row from where the data is to be fetched
			XSSFSheet sheet =workbook.getSheetAt(i);
			Iterator<Row> rows = sheet.iterator();
			//Row r=rows.next();
			while(rows.hasNext())
			{
				Row r1 = rows.next();
			
				if(r1.getCell(0).getStringCellValue().equalsIgnoreCase(testcasename))
				{
					Iterator<Cell> cellvalues= r1.cellIterator();
					while(cellvalues.hasNext())
					{
						String testdata = cellvalues.next().getStringCellValue();
						arrayData.add(testdata);
					}
				}
			}
			
		}
		}
		workbook.close();
		return arrayData;		
	}
}

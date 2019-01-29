package org.testing.Runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Runner {
	
	public static void main(String[] args) throws IOException {
		
		XmlSuite suite = new XmlSuite();	//Suite object
		suite.setName("Suite1");		//Set name
		
		XmlTest test = new XmlTest(suite);	//Test object
		
		File file = new File("E:/STUDY_STUFF/SQA/SELENIUM_TESTING/Gurgaon_Class/Selenium/TestCases.xlsx");
		FileInputStream fs = new FileInputStream(file);
		
		XSSFWorkbook wk = new XSSFWorkbook(fs);
		XSSFSheet sheet = wk.getSheet("Sheet1");
		int numOfRow = sheet.getPhysicalNumberOfRows();
		
		ArrayList<XmlClass> classlist = new ArrayList<XmlClass>();
		
		for(int i=1;i<numOfRow;i++){
			
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell = row.getCell(4);
			System.out.println(cell);
			if(cell.getStringCellValue().equals("Y")){
				
				String packageName=row.getCell(2).getStringCellValue();
				System.out.println(packageName);
				String className=row.getCell(3).getStringCellValue();
				String packClassName=packageName+"."+className;
				
				
				XmlClass testClass = new XmlClass(packClassName);	//xmlClass
				classlist.add(testClass);				
			}
		}
		System.out.println(classlist);
		
		test.setClasses(classlist);
		
		ArrayList<XmlTest> testlist = new ArrayList<XmlTest>();
		testlist.add(test);
		
		suite.setTests(testlist);
		
		ArrayList<XmlSuite> suitelist = new ArrayList<XmlSuite>();
		suitelist.add(suite);
		
		TestNG testNG = new TestNG();
		testNG.setXmlSuites(suitelist);
		testNG.run();
	}
}

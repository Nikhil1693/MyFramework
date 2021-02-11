package com.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	
	private static Workbook book;
	private static Sheet sheet;
	private static String Test_data_path="C:\\Users\\50024558\\eclipse-workspace\\MyFramework\\src\\main\\java\\com\\testdata\\testdata.xlsx";
	
	
	public static Object[][] getTestData(String sheetName){
		
		Object data[][]=null;
		
		FileInputStream ip;
		try {
			ip = new FileInputStream(Test_data_path);
		
			book=WorkbookFactory.create(ip);
		    sheet=book.getSheet(sheetName);
		    
		    data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		    
		    for(int i=0;i<sheet.getLastRowNum();i++) {
		    	for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
		    		data[i][j]=sheet.getRow(i+1).getCell(j).toString();
		    	}
		    }
		
		
		}catch(Exception e) {
			 
		}
		
		return data;
		
	}

}

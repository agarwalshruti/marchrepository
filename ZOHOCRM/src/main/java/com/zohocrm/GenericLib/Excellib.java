package com.zohocrm.GenericLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excellib {
	String path = "./src/test/resources/CRMTestData.xlsx";
//For getting the data from the excel sheet.
	public String getExcelData(String sheetName, int rowNum, int columnNum)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream fileinputstream = new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fileinputstream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		String data = row.getCell(columnNum).getStringCellValue();
		return data;

	}
//For setting the data in the excel sheet.
	public void setExcelData(int rownum, int cellnum, String value)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		File src = new File(path);
		FileInputStream fis = new FileInputStream(src);
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		wb.getSheet("ExcelReportStatus").getRow(rownum).createCell(cellnum).setCellValue(value);
		FileOutputStream fout = new FileOutputStream(new File(path));
		wb.write(fout);
		fout.close();
	}
//For temporary purpose settExcelData method is added here.
	public void settExcelData(String Sheetname, int rownum, int cellnum, String value)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		if (value instanceof String) {
			File src = new File(path);
			FileInputStream fis = new FileInputStream(src);
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			wb.getSheet(Sheetname).getRow(rownum).createCell(cellnum).setCellValue(value);
			FileOutputStream fout = new FileOutputStream(new File(path));
			wb.write(fout);
			fout.close();
		} else {
			String newvalue = "'" + value;
			File src = new File(path);
			FileInputStream fis = new FileInputStream(src);
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			wb.getSheet("ExcelReportStatus").getRow(rownum).createCell(cellnum).setCellValue(newvalue);
			FileOutputStream fout = new FileOutputStream(new File(path));
			wb.write(fout);
			fout.close();
		}

	}

}

package com.actitime.genericlib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author UMESH.S
 *
 */
public class FileDataUtils 
{
	String excelPath = "./Data/testData.xlsx";
	String propPath = "./Data/cd.properties";
	/**
	 * This method will return the string data from excel based on the input parameters
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return String Data
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName,int rowNum,int colNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(colNum).getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * This method will return the LastRowIndex
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return
	 * @throws Throwable
	 */
	public int getExcelRowNum(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRowNum=sh.getLastRowNum();
		return lastRowNum;
	}
	/**
	 * This method will return the property object
	 * @return property object
	 * @throws Throwable
	 */
	public Properties getPropertyObj() throws Throwable
	{
		FileInputStream fis = new FileInputStream(propPath);
		
		Properties pobj = new Properties();
		pobj.load(fis);
		
		return pobj;

	}
	/**
	 * This method will write datain excel depending upon the input parameters
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @param data
	 * @throws Throwable
	 */
	public void setExcelData(String sheetName,int rowNum,int colNum,String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(colNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(excelPath);
		wb.write(fos);
		wb.close();

	}

}

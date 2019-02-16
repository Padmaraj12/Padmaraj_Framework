package com.training.dataproviders;

import org.testng.annotations.DataProvider;

import com.training.readexcel.ApachePOIExcelRead;

public class RegisterDataProviders {

	@DataProvider(name = "RETD_001")
	public Object[][] getExcelData() {
		String fileName = "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium Traning Test Cases\\RETC_061.xlsx";
		String sheetName = "RETD_001";
		return new ApachePOIExcelRead().getExcelContent(fileName, sheetName);

	}
	
	@DataProvider(name = "RETD_002")
	public Object[][] getExcelData1() {
		String fileName = "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium Traning Test Cases\\RETC_063.xlsx";
		String sheetName = "RETD_002";
		return new ApachePOIExcelRead().getExcelContent(fileName, sheetName);

	}
	
	@DataProvider(name = "RETD_003")
	public Object[][] getExcelData2() {
		String fileName = "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium Traning Test Cases\\RETC_064.xlsx";
		String sheetName = "RETD_003";
		return new ApachePOIExcelRead().getExcelContent(fileName, sheetName);

	}
}

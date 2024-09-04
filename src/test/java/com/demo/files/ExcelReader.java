package com.demo.files;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static String[][] getData() throws IOException {
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\keerthar\\eclipse-workspace1\\NoBrokerPrjt\\src\\test\\resources\\data\\InvalidCredentials.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet s1 = wb.getSheetAt(0);
			XSSFRow r = s1.getRow(0);
			int row = s1.getLastRowNum();
			int col = r.getLastCellNum();
			System.out.println("Row: " + row + "\nCol: " + col);
			String data[][] = new String[row + 1][col];
			for (int ri = 0; ri <= row; ri++) {
				XSSFRow rowData = s1.getRow(ri);
				for (int ci = 0; ci < col; ci++) {
					XSSFCell cell = rowData.getCell(ci);
					if (cell != null) {
						if (cell.getCellType() == CellType.STRING) {
							data[ri][ci] = cell.getStringCellValue().toString();
						} else if (cell.getCellType() == CellType.NUMERIC) {
							data[ri][ci] = String.valueOf((long) cell.getNumericCellValue());
						} else {
							data[ri][ci] = "";
						}
					} else {
						data[ri][ci] = "";
					}
				}
			}
			return data;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
}

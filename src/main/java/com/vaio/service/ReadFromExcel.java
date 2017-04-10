/**
 * 
 */
package com.vaio.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.gson.JsonObject;

/**
 * @author nambv
 *
 * Mar 31, 2017
 */
public class ReadFromExcel {
	public static void main(String args[]) {
		getContents("C:/Users/09042017/action-page0/content1.xlsx");
	}
	
	public static List<String> getField(Row row) {
		List<String> attrs = new ArrayList<String>();
		Iterator<Cell> cellIterator = row.iterator();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			attrs.add(cell.getStringCellValue());
		}
		return attrs;
	}
	
	public static List<JsonObject> getContents(String path) {
		List<JsonObject> contents = new ArrayList<JsonObject>();
		JsonObject c;
		List<String> attrs = new ArrayList<String>();
		try {
			FileInputStream file = new FileInputStream(new File(path));
			XSSFWorkbook workBook = new XSSFWorkbook(file);
			XSSFSheet sheet = workBook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if(row.getRowNum() == 0) {
					attrs = getField(row);
					continue;
				}
				Iterator<Cell> cellIterator = row.iterator();
				c = new JsonObject();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					for(int i = 0; i < attrs.size(); i++) {
						if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
							if (cell.getColumnIndex() == i) c.addProperty(attrs.get(i), cell.getStringCellValue());
						} else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
							if (cell.getColumnIndex() == i) c.addProperty(attrs.get(i), (int)cell.getNumericCellValue());
						}
					}
				}
				contents.add(c);
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contents;
	}
	
}

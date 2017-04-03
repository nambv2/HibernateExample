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

import com.vaio.common.Content;

/**
 * @author nambv
 *
 * Mar 31, 2017
 */
public class ReadFromExcel {
	public static void main(String args[]) {
		getContents("C:\\Users\\03042017\\action-page0\\content.xlsx");
	}
	public static List<Content> getContents(String path) {
		List<Content> contents = new ArrayList<Content>();
		Content content;
		try {
			FileInputStream file = new FileInputStream(new File(path));
			XSSFWorkbook workBook = new XSSFWorkbook(file);
			XSSFSheet sheet = workBook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if(row.getRowNum() == 0) continue;
				Iterator<Cell> cellIterator = row.iterator();
				content = new Content();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						if (cell.getColumnIndex() == 0) {
							content.setId(String.valueOf(cell.getNumericCellValue()));
						}
					case Cell.CELL_TYPE_STRING:
						if (cell.getColumnIndex() == 1) content.setTitle(cell.getStringCellValue().trim());
						if (cell.getColumnIndex() == 2) content.setImg(cell.getStringCellValue());
						if (cell.getColumnIndex() == 3) content.setSwf(cell.getStringCellValue());
						if (cell.getColumnIndex() == 4) content.setDes(cell.getStringCellValue());
						
					}
				}
				contents.add(content);
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contents;
	}
}

package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility1 {
public static void writeResultToXL(String path,String sheet ,int pass,int fail) {
	try {
		Workbook w= WorkbookFactory.create(new FileInputStream(path));
		w.getSheet(sheet).getRow(1).getCell(0).setCellValue(pass);
		w.getSheet(sheet).getRow(1).getCell(1).setCellValue(fail);
		w.write(new FileOutputStream(path));
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
}
}

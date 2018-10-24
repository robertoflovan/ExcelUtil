package exceltest;

import java.util.ArrayList;
import java.util.HashMap;

public class TestExcel {

	public static void main(String[] args) {
		
		UtilExcel u = new UtilExcel("C:\\Users\\RF43496\\Documents\\Roberto Flores\\lib\\Excel\\test.xlsx");
		
		HashMap<String, ArrayList<String>> datos = u.getRows(0);
		

		
		
		System.out.println(datos);
		datos.size();
		
		
		System.out.println("tst");
		
		
		
	}
	
}

package exceltest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UtilExcel {

	String ruta;
	private Workbook workbook;
	
	public UtilExcel(String ruta) {
		this.ruta = ruta;
	}
	
	private void open(){
		try {
			FileInputStream inputStream = new FileInputStream(new File(ruta));
            workbook = WorkbookFactory.create(inputStream);
			//workbook = WorkbookFactory.create(new File(ruta));
		} catch (EncryptedDocumentException e) {
			JOptionPane.showMessageDialog(null, "Error en cargar el archivo, encriptado");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error en cargar el archivo " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void close(){
		try {
			workbook.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "error al cerrar el archivo");
			e.printStackTrace();
		}
		workbook = null;
	}
	
	
	public void setCell(String hoja, int fila, int columna, String dato){
		open();
		
		Sheet sheet = workbook.getSheet(hoja);
		Row row = sheet.createRow(fila);
		Cell cell = row.createCell(columna);
		cell.setCellValue(dato);
		

		
        try {
        	FileOutputStream outputStream = new FileOutputStream(ruta);
			workbook.write(outputStream);
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		
		close();
	}
	
	public  HashMap<String, ArrayList<String>> getRows(String hoja){
		 // Getting the Sheet at index zero
		
		open();
		
        Sheet sheet = workbook.getSheet(hoja);
		return getRows(sheet);
		
		
	}
	
	public HashMap<String, ArrayList<String>> getRows(int hoja){
		
		open();
		
		Sheet sheet = workbook.getSheetAt(hoja);
		return getRows(sheet);
	}
	
	private HashMap<String, ArrayList<String>> getRows(Sheet sheet){
		// Create a DataFormatter to format and get each cell's value as String
        
		HashMap<String, ArrayList<String>> filas = new HashMap<>();
		
		DataFormatter dataFormatter = new DataFormatter();
		
		int numColumnas = sheet.getRow(0).getLastCellNum();
		
		for (int i = 0; i < numColumnas; i++) {
			String cellValue = dataFormatter.formatCellValue(sheet.getRow(0).getCell(i));
			filas.put(cellValue, getRowsByColum(sheet, i));
		}
		
		
		close();
		return filas;
	}
	
	private ArrayList<String> getRowsByColum(Sheet sheet, int column){
		
		ArrayList<String> datos = new ArrayList<>();
		
		DataFormatter dataFormatter = new DataFormatter();

		Iterator<Row> rowIterator = sheet.rowIterator();
		
		if (rowIterator.hasNext()) {
			rowIterator.next();
		}
		
		while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            String cellValue = dataFormatter.formatCellValue(row.getCell(column));
            datos.add(cellValue);
        }
		
		return datos;
		
	}

	public Workbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(Workbook workbook) {
		this.workbook = workbook;
	}
	
	
	
}

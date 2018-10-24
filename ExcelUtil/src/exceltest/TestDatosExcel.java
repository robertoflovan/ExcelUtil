package exceltest;

import java.util.ArrayList;
import java.util.HashMap;

import datos.DatosExcel;
import modelo.Cuenta;
import modelo.Transaccion;

public class TestDatosExcel {

	public static void main(String[] args) {
		
		DatosExcel d = new DatosExcel();
		
		ArrayList<Transaccion> transacciones = d.getTransaccionesExcel();
		
		HashMap<String, Cuenta> cuentas = d.getCuentas();
		
		System.out.println(cuentas);
		
		System.out.println("t");
		
	}
	
	
}

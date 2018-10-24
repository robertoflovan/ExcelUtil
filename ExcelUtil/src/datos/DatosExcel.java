package datos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import exceltest.UtilExcel;
import modelo.Cuenta;
import modelo.Transaccion;

public class DatosExcel {

	public static final String RUTA = "src/res/SeleniumUat.xlsx";
	
	UtilExcel excel;
	
	public DatosExcel() {
		excel = new UtilExcel(RUTA);
	}
	
	public ArrayList<Transaccion> getTransaccionesExcel(){
		
		HashMap<String, Cuenta> cuentas = getCuentas();
		
		HashMap<String, ArrayList<String>> datosExcelTransacciones = excel.getRows("Transacciones");
		
		ArrayList<Transaccion> transacciones = new ArrayList<>();
		
		for (int i = 0; i < datosExcelTransacciones.get("Numero cliente").size(); i++) {
			String cuentaOrigen = datosExcelTransacciones.get("Cuenta origen").get(i);
			String cuentaDestino = datosExcelTransacciones.get("Cuenta destino").get(i);
			String monto = datosExcelTransacciones.get("Monto").get(i);
			String tipo = datosExcelTransacciones.get("Tipo").get(i);
			Cuenta cuenta = cuentas.get(datosExcelTransacciones.get("Numero cliente").get(i));
			
			transacciones.add(new Transaccion(cuentaOrigen, cuentaDestino, monto, tipo, cuenta));
		}
		
		return transacciones;
	}
	
	
	public HashMap<String, Cuenta> getCuentas(){
		
		HashMap<String, ArrayList<String>> datosExcelCuentas = excel.getRows("Cuentas");
		
		HashMap<String, Cuenta> cuentas = new HashMap<>();
		
		for (int i = 0; i < datosExcelCuentas.get("Numero cliente").size()-1; i++) {
			String nCliente = datosExcelCuentas.get("Numero cliente").get(i);
			String clave = datosExcelCuentas.get("Clave").get(i);
			String nombre = datosExcelCuentas.get("Nombre").get(i);
			String mejorCorreo = datosExcelCuentas.get("Mejor correo").get(i);
			
			cuentas.put(nCliente, new Cuenta(nCliente, clave, nombre, mejorCorreo));
		}
		
		return cuentas;
	}
	
}

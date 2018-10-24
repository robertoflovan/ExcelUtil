package modelo;

public class Cuenta {

	private String nCliente;
	private String clave;
	private String nombre;
	private String mejorCorreo;
	
	public Cuenta() {}
	
	public Cuenta(String nCliente, String clave, String nombre, String mejorCorreo) {
		super();
		this.nCliente = nCliente;
		this.clave = clave;
		this.nombre = nombre;
		this.mejorCorreo = mejorCorreo;
	}

	public String getnCliente() {
		return nCliente;
	}

	public void setnCliente(String nCliente) {
		this.nCliente = nCliente;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMejorCorreo() {
		return mejorCorreo;
	}

	public void setMejorCorreo(String mejorCorreo) {
		this.mejorCorreo = mejorCorreo;
	}
	
	
	
	
}

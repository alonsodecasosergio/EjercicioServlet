package dataModelEntities;

import java.io.Serializable;

public class Empleado implements Serializable{
	
	private int codigo;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String lugarNacimiento;
	private char[] fechaNacimiento;
	private String direccion;
	private String telefono;
	private String puesto;
	private int cod_departamento;
	
	public Empleado() {
		
	}

	public Empleado(int codigo, String nombre, String apellido1, String apellido2, String lugarNacimiento,
			char[] fechaNacimiento, String direccion, String telefono, String puesto, int cod_departamento) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.lugarNacimiento = lugarNacimiento;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.puesto = puesto;
		this.cod_departamento = cod_departamento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public char[] getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(char[] fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public int getCod_departamento() {
		return cod_departamento;
	}

	public void setCod_departamento(int cod_departamento) {
		this.cod_departamento = cod_departamento;
	}

	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", lugarNacimiento=" + lugarNacimiento + ", fechaNacimiento=" + fechaNacimiento
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", puesto=" + puesto + ", cod_departamento="
				+ cod_departamento + "]";
	}
	
	
}

package dataModelEntities;

import java.io.Serializable;

public class Departamento implements Serializable{
	
	private int codigo;
	private String nombre;
	private int cod_responsable;
	
	public Departamento() {
		
	}
	
	public Departamento(int codigo, String nombre, int cod_responsable) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cod_responsable = cod_responsable;
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

	public int getCod_responsable() {
		return cod_responsable;
	}

	public void setCod_responsable(int cod_responsable) {
		this.cod_responsable = cod_responsable;
	}

	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", nombre=" + nombre + ", cod_responsable=" + cod_responsable + "]";
	}
	
	
	
	
}

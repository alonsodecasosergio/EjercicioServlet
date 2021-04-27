package dataModelDAO;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import dataModelEntities.Departamento;
import servlet.MostrarDepartamentos;

public abstract class DepartamentoDAO {
	
	private static Logger logger = LogManager.getLogger(MostrarDepartamentos.class);
	
	//INSERTA UN DEPARTAMENTO EN LA BASE DE DATOS
	public static void inserDepartamento(Session s, Departamento depar) {
		s.save(depar);
		logger.debug("Inserccion del departamento " + depar.toString());
	}
	
	//DEVUELVE UNA LISTA CON TODOS LOS DEPARTAMENTOS
	public static List<Departamento> getAllDepartamento(Session s){
		logger.debug("Obtencion de los datos de la tabla departamento");
		String hQuery = "from Departamento";
		List<Departamento> departamentoList = s.createQuery(hQuery, Departamento.class).list();
		
		return departamentoList;
	}
	
	//DEVUELVE EL DEPARTAMENTO SEGUN SU CODIGO
	public static Departamento getDepartamento(Session s, int departamentoId) {
		String hQuery = " from Departamento d where d.codigo = :codigo";
		Departamento departamento = s.createQuery(hQuery, Departamento.class)
											.setParameter("codigo", departamentoId)
											.setMaxResults(1)
											.uniqueResult();
		return departamento;
	}
	
	//BORRA UN DEPARTAMENTO SEGUN SU CODIGO DE DEPARTAMENTO
	public static void deleteDepartamento(Session s, int departamentoId) {
		
		Departamento depar = s.get(Departamento.class, departamentoId);
		
		s.delete(depar);
		
		logger.debug("Borrado del departamento: " + depar.toString());
		
	}
	
	//ACTUALIZA LOS DATOS DEL DEPARTAMENTO 
	public static void updateDepartamento(Session s, int departamentoId, Departamento deparActualizado) {
		
		Departamento depar = s.get(Departamento.class, departamentoId);
		
		depar.setCod_responsable(deparActualizado.getCod_responsable());
		depar.setNombre(deparActualizado.getNombre());
		
		s.update(depar);
		
		logger.debug("Actualizacion del departamento: " + depar.toString());
	}

}

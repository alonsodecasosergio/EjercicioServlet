package dataModelDAO;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import dataModelEntities.Empleado;
import servlet.MostrarDepartamentos;

public abstract class EmpleadoDAO {
	
	private static Logger logger = LogManager.getLogger(MostrarDepartamentos.class);
	
	//METODO EL CUAL INSERTARA EL EMPLEADO EN LA BASE DE DATOS
	public static void insertEmpleados(Session s, Empleado empleado) {
		
		s.save(empleado);
		logger.debug("Inserccion del departamento " + empleado.toString());
	}
	
	//OBTIENE UNA LISTA DE TODOS LOS EMPLEADOS
	public static List<Empleado> getAllEmpleado(Session s){
		String hQuery = "from Empleado";
		List<Empleado> empleadoList = s.createQuery(hQuery, Empleado.class).list();
		
		return empleadoList;
	}
	
	//OBTIENE EL EMPLEADO SEGUN EL ID PASADO COMO PARAMETRO
	public static Empleado getEmpleado(Session s, int empleadoId) {
		String hQuery = " from Empleado e where e.codigo = :codigo";
		Empleado empleado = s.createQuery(hQuery, Empleado.class)
									.setParameter("codigo", empleadoId)
									.setMaxResults(1)
									.uniqueResult();
		return empleado;
	}
	
	//BORRA UN EMPLEADO SEGUN SU CODIGO DE EMPLEADO
	public static void deleteEmpleado(Session s, int empleadoId) {
		
		Empleado empleado = s.get(Empleado.class, empleadoId);
		
		s.delete(empleado);
		
		logger.debug("Borrado del departamento " + empleado.toString());

		
	}
	
	//ACTUALIZA EL EMPLEADO CAMBIANDO SUS DATOS POR LOS DATOS NUEVOS
	public static void updateEmpleado(Session s, int empleadoId, Empleado empleActualizado) {
		
		Empleado empleado = s.get(Empleado.class, empleadoId);
		
		empleado.setNombre(empleActualizado.getNombre());
		empleado.setApellido1(empleActualizado.getApellido1());
		empleado.setApellido2(empleActualizado.getApellido2());
		empleado.setDireccion(empleActualizado.getDireccion());
		empleado.setFechaNacimiento(empleActualizado.getFechaNacimiento());
		empleado.setLugarNacimiento(empleActualizado.getLugarNacimiento());
		empleado.setPuesto(empleActualizado.getPuesto());
		empleado.setTelefono(empleActualizado.getTelefono());
		empleado.setCod_departamento(empleActualizado.getCod_departamento());
		
		s.update(empleado);
		
		logger.debug("Actualizacion del departamento " + empleado.toString());

	}

}

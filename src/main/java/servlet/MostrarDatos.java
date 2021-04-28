package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dataModelDAO.DepartamentoDAO;
import dataModelDAO.EmpleadoDAO;
import dataModelEntities.Departamento;
import dataModelEntities.Empleado;
import dataModelUtils.HibernateUtil;

/**
 * Servlet implementation class MostrarDatos
 */
@WebServlet("/MostrarDatos")
public class MostrarDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LogManager.getLogger(MostrarDepartamentos.class);
	
	static SessionFactory sessionFactory;
	static Session session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarDatos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		logger.info("%1$s: >>>>>> Main execution started. MOSTRAR DATOS");
		
		session = HibernateUtil.getSessionFactory().openSession();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String parameter = request.getParameter("table");
		
		logger.debug("Peticion de todos los departamentos");
		PrintWriter out = response.getWriter();
		if(parameter.equals("empleado")) {
			
			logger.debug("Peticion de todos los empleados");
			List<Empleado> listaEmpleado = EmpleadoDAO.getAllEmpleado(session);
			logger.debug("Escritura de los empleados en la tabla");
			printResponseEmpleados(out, listaEmpleado);
			
		}else if(parameter.equals("departamento")) {
			
			logger.debug("Peticion de todos los departamentos");
			List<Departamento> listaDepartamento = DepartamentoDAO.getAllDepartamento(session);
			logger.debug("Escritura de los departamentos en la tabla");
			printResponseDepartamentos(out, listaDepartamento);
			
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private PrintWriter printResponseDepartamentos(PrintWriter out, List<Departamento> listaDepartamento) {
		
		PrintWriter res = out;
		
		res.println("<html>");
		res.println("<title>Ejercicio Serverlet | Sergio Alonso</title>");
		res.println("<body>");
		res.println("<h1>TABLA DEPARTAMENTOS</h1>");		
		res.println("<table border=\"2\">");
		res.println("<tr>");
		res.println("<td> CODIGO </td>");
		res.println("<td> NOMBRE </td>");
		res.println("<td> CODIGO RESPONSABLE </td>");
		res.println("</tr>");
		for(int i = 0; i < listaDepartamento.size(); i++) {
			
			Departamento depar = listaDepartamento.get(i);
			res.println("<tr>");
			res.println("<td>" + depar.getCodigo() + "</td>");
			res.println("<td>" + depar.getNombre() + "</td>");
			res.println("<td>" + depar.getCod_responsable() + "</td>");
			res.println("</tr>");
		}
		res.println("</table>");
		res.println("</body>");
		res.println("</html>");
		
		return res;
	}
	
	private PrintWriter printResponseEmpleados(PrintWriter out, List<Empleado> listaEmpleado) {
		
		PrintWriter res = out;
		
		res.println("<html>");
		res.println("<title>Ejercicio Serverlet | Sergio Alonso</title>");
		res.println("<body>");
		res.println("<h1>TABLA EMPLEADOS</h1>");		
		res.println("<table border=\"2\">");
		res.println("<tr>");
		res.println("<td> CODIGO </td>");
		res.println("<td> NOMBRE </td>");
		res.println("<td> PRIMER APELLIDO </td>");
		res.println("<td> SEGUNDO APELLIDO </td>");
		res.println("<td> LUGAR DE NACIMIENTO </td>");
		res.println("<td> FECHA DE NACIMEINTO </td>");
		res.println("<td> DIRECCION </td>");
		res.println("<td> TELEFONO </td>");
		res.println("<td> PUESTO </td>");
		res.println("<td> CODIGO DE DEPARTAMENTO </td>");
		
		res.println("</tr>");
		for(int i = 0; i < listaEmpleado.size(); i++) {
			
			Empleado emple = listaEmpleado.get(i);
			
			res.println("<tr>");
			res.println("<td>" + emple.getCodigo() + "</td>");
			res.println("<td>" + emple.getNombre() + "</td>");
			res.println("<td>" + emple.getApellido1() + "</td>");
			res.println("<td>" + emple.getApellido2() + "</td>");
			res.println("<td>" + emple.getLugarNacimiento() + "</td>");
			
			String fNacimiento = "";
			for(int j = 0; j < emple.getFechaNacimiento().length; j++)  {
				fNacimiento += emple.getFechaNacimiento()[j];
			}
			
			res.println("<td>" + fNacimiento + "</td>");
			res.println("<td>" + emple.getDireccion()+ "</td>");
			res.println("<td>" + emple.getTelefono() + "</td>");
			res.println("<td>" + emple.getPuesto() + "</td>");
			res.println("<td>" + emple.getCod_departamento() + "</td>");
			
			res.println("</tr>");
		}
		res.println("</table>");
		res.println("</body>");
		res.println("</html>");
		
		return res;
	}

}

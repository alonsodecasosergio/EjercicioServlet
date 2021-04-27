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
import dataModelEntities.Departamento;
import dataModelUtils.HibernateUtil;

/**
 * Servlet implementation class MostrarDepartamentos
 */
@WebServlet("/MostrarDepartamentos")
public class MostrarDepartamentos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LogManager.getLogger(MostrarDepartamentos.class);
	
	static SessionFactory sessionFactory;
	static Session session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarDepartamentos() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		logger.info("%1$s: >>>>>> Main execution started.");
		
		session = HibernateUtil.getSessionFactory().openSession();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		List<Departamento> listaDepartamento = DepartamentoDAO.getAllDepartamento(session);
		printResponse(out, listaDepartamento);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private PrintWriter printResponse(PrintWriter out, List<Departamento> listaDepartamento) {
		
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

}

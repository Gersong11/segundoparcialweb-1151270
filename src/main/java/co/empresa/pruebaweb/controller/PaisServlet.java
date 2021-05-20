package co.empresa.pruebaweb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import co.empresa.pruebaweb.dao.PaisDao;
import co.empresa.pruebaweb.dao.PaisDaoFactory;
import co.empresa.pruebaweb.modelo.Pais;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/")
public class PaisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private PaisDao paisDao; 
	
	
    /**
     * Default constructor. 
     */
    public PaisServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.paisDao = new PaisDaoFactory().getPaisDao("postgresql");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		try {
			
		
		switch (action) {
		case "/new": 
			showNewForm(request, response);
			break;
		case "/insert":
			insertarPais(request, response);
			break;
		case "/delete":
			eliminarPais(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			ActualizarPais(request, response);
			break;
		default:
			listpaises(request,response);
				break;
				
		}} catch (SQLException e) {
			
		}
		
		
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("pais.jsp");
		dispatcher.forward(request, response);
	}
	
	public void insertarPais(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		System.out.println("se llamo insertar");
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		
		if(paisDao.selec(id)==null) {
		
		
			Pais pais = new Pais(id,nombre);
	
		this.paisDao.insert(pais);
		response.sendRedirect("list");
		
		}else{
			request.setAttribute("error", "id ya existe");
			response.sendRedirect("new");
			
		}
		
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		Pais paisactual = this.paisDao.selec(id);
		request.setAttribute("pais",paisactual);
		RequestDispatcher dispatcher = request.getRequestDispatcher("pais.jsp");
		dispatcher.forward(request, response);
		
	}
	
	public void ActualizarPais(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		
	
		
		
			Pais pais = new Pais(id,nombre);
	
		this.paisDao.update(pais);
		response.sendRedirect("list");
	}
	
	public void eliminarPais(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	int id = Integer.parseInt(request.getParameter("id"));
	
	
	
		

	this.paisDao.delete(id);
	response.sendRedirect("list");
	}
	
	
	
	private void listpaises(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
	
	List<Pais> listUsuarios = this.paisDao.selecAll();
	request.setAttribute("listPaises", listUsuarios);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("paislist.jsp");
	dispatcher.forward(request, response);
	
	}

}

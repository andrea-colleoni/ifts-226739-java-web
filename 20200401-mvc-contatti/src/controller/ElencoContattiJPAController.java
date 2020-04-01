package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contatto;

/**
 * Servlet implementation class ElencoContattiJPAController
 */
@WebServlet("/elenco-contatti")
public class ElencoContattiJPAController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ElencoContattiJPAController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("20200401-mvc-contatti");
		EntityManager em = emf.createEntityManager();
		
		// interazioni MVC 2 e 3: creo (ottengo) il model
		// uso JPA e JPQL per ottenere tutti i contatti
		List<Contatto> contatti = em.createQuery("select c from Contatto c", Contatto.class).getResultList();

		request.setAttribute("contatti", contatti);
		request.getRequestDispatcher("elenco-contatti.jsp").forward(request, response);
	}

}

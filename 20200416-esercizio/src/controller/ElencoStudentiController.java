package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Studente;
import utils.JpaUtils;

/**
 * Servlet implementation class ElencoStudentiController
 */
@WebServlet("/studenti")
public class ElencoStudentiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Studente> studenti;
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		studenti = em.createQuery("select studente from Studente studente", Studente.class).getResultList();
		em.close();
		response.getWriter().println("trovati " + studenti.size() + " studenti");
		
		request.setAttribute("studenti", studenti);
		request.getRequestDispatcher("/WEB-INF/views/elenco-studenti.jsp").forward(request, response);
		
	}

}

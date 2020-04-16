package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Lezione;
import utils.JpaUtils;

/**
 * Servlet implementation class ElencoLezioniController
 */
@WebServlet("/lezioni")
public class ElencoLezioniController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Lezione> lezioni;
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		lezioni = em.createQuery("select lezione from Lezione lezione", Lezione.class).getResultList();
		em.close();

		request.setAttribute("lezioni", lezioni);
		request.getRequestDispatcher("/WEB-INF/views/elenco-lezioni.jsp").forward(request, response);
	}

}

package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Corso;
import utils.JpaUtils;

/**
 * Servlet implementation class ElencoCorsiController
 */
@WebServlet("/corsi")
public class ElencoCorsiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		// leggo il parametro codiceCorso
		String codiceCorso = request.getParameter("codiceCorso");
		if (codiceCorso == null) {
			List<Corso> corsi;
			// creiamo una query JPQL per estrarre tutti i corsi dal DB con entitymanager
			// JPQL è diverso dall'SQL => è object oriented (che per noi è un bene!!)
			corsi = em.createQuery("select corso from Corso corso", Corso.class).getResultList();
			
			// dobbiamo passare alla view l'elenco dei corsi che abbiamo appena recuperato
			request.setAttribute("corsi", corsi);
			// quindi passiamo il controllo alla view corretta, inoltrandogli la request "arricchita" dei corsi
			request.getRequestDispatcher("/WEB-INF/views/elenco-corsi.jsp").forward(request, response);
		} else {
			Corso corso;
			corso = em.find(Corso.class, codiceCorso);
			// invalida la cache di JPA e interroga il DB rinfrescando l'oggetto
			em.refresh(corso);
			
			request.setAttribute("corso", corso);
			String mode = request.getParameter("mode");
			if (mode != null && "edit".contentEquals(mode)) {
				request.getRequestDispatcher("/WEB-INF/views/edit-corso.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/views/corso.jsp").forward(request, response);
			}
		}
		em.close();
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// tutto quello che arriva da una form HTML è SEMPRE tutto testo (String)
		// quindi andrà convertito nel tipo corretto
		String codiceCorso = request.getParameter("codiceCorso");
		String titolo = request.getParameter("titolo");
		String descrizione = request.getParameter("descrizione");
		String dataInizio = request.getParameter("dataInizio");
		String dataFine = request.getParameter("dataFine");
		String monteOre = request.getParameter("monteOre");
		
		System.out.println(titolo);
	}

	
}

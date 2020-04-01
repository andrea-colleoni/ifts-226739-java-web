package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Brano;
import model.Playlist;
import utils.JPAUtils;

/**
 * Servlet implementation class ElencoBraniController
 */
@WebServlet("/brani")
public class ElencoBraniController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElencoBraniController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JPAUtils.getEntityManager();
		List<Brano> brani = new ArrayList<>();
		try {
			int idPLaylist = Integer.parseInt(request.getParameter("playlist"));
			Playlist p = em.find(Playlist.class, idPLaylist);
			if (p != null) {
				brani = p.getBrani();
			}
		} catch (NumberFormatException ex) {
			brani = em.createQuery("select b from Brano b", Brano.class).getResultList();
		}
		
		request.setAttribute("brani", brani);
		request.getRequestDispatcher("WEB-INF/views/elencoBrani.jsp").forward(request, response);
	}	

}

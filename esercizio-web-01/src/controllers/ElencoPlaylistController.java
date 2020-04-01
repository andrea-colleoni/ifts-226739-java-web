package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Playlist;
import utils.JPAUtils;

/**
 * Servlet implementation class ElencoPlaylistController
 */
@WebServlet("/playlists")
public class ElencoPlaylistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElencoPlaylistController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JPAUtils.getEntityManager();
		List<Playlist> playlist = em.createQuery("select p from Playlist p", Playlist.class).getResultList();
		
		request.setAttribute("playlist", playlist);
		request.getRequestDispatcher("WEB-INF/views/elencoPlaylist.jsp").forward(request, response);
	}

}

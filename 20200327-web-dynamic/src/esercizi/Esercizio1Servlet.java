package esercizi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Esercizio1Servlet
 */
@WebServlet("/esercizio1")
public class Esercizio1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Esercizio1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numero = Integer.parseInt(request.getParameter("numero"));
		for(int i = 0; i < numero; i++) {
			for(int j = 0; j <= i; j++) {
				response.getWriter().append("#");
			}
			response.getWriter().append("\n");
		}
	}

}

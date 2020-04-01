package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contatto;

/**
 * Servlet implementation class ElencoContattiController
 */
@WebServlet("/elenco-contatti-old")
public class ElencoContattiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElencoContattiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// interazioni MVC 2 e 3: creo (ottengo) il model
		List<Contatto> contatti = new ArrayList<>();
		contatti.add(new Contatto("Andrea", "Colleoni", "andrea@", "123456789", new Date()));
		contatti.add(new Contatto("Mario", "Rossi", "rossi@", "98765432", new Date()));
		contatti.add(new Contatto("Anna", "Verdi", "verdi@", "7382937", new Date()));
		
		// ho il model => devo decidere come mandarlo sulla response
		// "allego" il model alla request, in modo da poterlo trasferire alla view
		request.setAttribute("contatti", contatti);
		
		// redirigo il request dispatcher sulla mia view (pagina JSP)
		request.getRequestDispatcher("elenco-contatti.jsp").forward(request, response);
		
		
		// non lo maderò in questo modo il contenuto al browser, ma delegherò una view per farlo
		/*
		response.setContentType("text/html");
		response.getWriter().append("<html>");
		response.getWriter().append("<head>");
		response.getWriter().append("<title>Elenco dei contatti</title>");
		response.getWriter().append("</head>");
		response.getWriter().append("<body>");
		response.getWriter().append("<h1>Elenco dei contatti</h1>");
		response.getWriter().append("<ul>");
		for(Contatto c : contatti) {
			response.getWriter().println("<li>" + c.toString() + "</li>");
		}
		response.getWriter().append("</ul>");
		response.getWriter().append("</body>");
		response.getWriter().append("</html>");
		*/
	}

}

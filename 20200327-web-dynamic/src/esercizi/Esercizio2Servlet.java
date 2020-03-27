package esercizi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Esercizio2Servlet
 */
@WebServlet("/esercizio2")
public class Esercizio2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Esercizio2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float op1 = Float.parseFloat(request.getParameter("operando1"));
		float op2 = Float.parseFloat(request.getParameter("operando2"));
		String op = request.getParameter("operazione");
		
		float ris = 0;
		switch(op) {
		case "+":
			ris = op1 + op2;
			break;
		case "-":
			ris = op1 - op2;
			break;
		case "*":
			ris = op1 * op2;
			break;
		case "/":
			ris = op1 / op2;
			break;
		}
		
		response.getWriter().append(String.format("Operazione => %1f %2s %3f = %4f", op1, op, op2, ris));
	}

}

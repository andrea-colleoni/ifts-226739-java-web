package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Persona;
import util.JPAUtil;

/**
 * Servlet implementation class PersoneController
 */
@WebServlet("/persone")
public class PersoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PersoneController() {
    }
    
    //for Preflight
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setAccessControlHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
    }    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		List<Persona> persone = JPAUtil.getEm().createQuery("select p from Persona p", Persona.class).getResultList();
		
		// devo trasformare il mio oggetto in JSON
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(persone);
		response.setContentType("application/json");
		response.getWriter().append(json);
	}

}

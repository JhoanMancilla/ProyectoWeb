package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asesorame.Genero;
import asesorame.Materia;
import asesorame.PreguntaSeg;
import dao.GeneroDao;
import dao.MateriaDao;
import dao.PreguntaSegDao;

/**
 * Servlet implementation class verifica_incio_sesion
 */
@WebServlet("/verifica_incio_sesion")
public class verifica_incio_sesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private List<Materia> materias;
    private List<PreguntaSeg> preguntas;
    private List<Genero> generos;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verifica_incio_sesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Materia m= new Materia();
		MateriaDao md= new MateriaDao();
		PreguntaSeg ps= new PreguntaSeg();
		PreguntaSegDao psd= new PreguntaSegDao();
		Genero g= new Genero();
		GeneroDao gd= new GeneroDao();
		materias =md.list();
		preguntas =psd.list();
		generos= gd.list();
		session.setAttribute("materias", materias);
		request.setAttribute("listamaterias", materias);
		request.setAttribute("listapreguntas", preguntas);
		request.setAttribute("listageneros", generos);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("formulario_datos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

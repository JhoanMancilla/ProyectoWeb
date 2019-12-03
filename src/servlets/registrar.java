package servlets;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import dao.*;
import asesorame.*;
/**
 * Servlet implementation class registrar
 */
@WebServlet("/registrar")
public class registrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected Persona consulta(HttpServletRequest request) {
		Connection con;
		Persona pers=new Persona();
		PersonaDao persd= new PersonaDao();
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/asesorame", "root", "");
            
             Statement st = (Statement) con.createStatement();
             String query = "SELECT id FROM persona WHERE apellido1 = '"+request.getParameter("apellido1")+"' AND apellido2= '"+request.getParameter("apellido2")+"'"
             		+ "AND nombre1= '"+request.getParameter("nombre")+"';";
             ResultSet rs = st.executeQuery(query);
                while (rs.next())
                 { 
                 pers = persd.find(Integer.parseInt(rs.getString("id_persona")));
                 }
                 rs.close();
                 st.close();
                 con.close();
                 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return pers;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Persona pers=new Persona();
		PersonaDao persd= new PersonaDao();
		Usuario usu=new Usuario();
		UsuarioDao usud= new UsuarioDao();
		Aprendiz apre= new Aprendiz();
		AprendizDao apred=new AprendizDao();
		Asesor ase= new Asesor();
		GeneroDao gd= new GeneroDao();
		AsesorDao ased= new AsesorDao();
		pers.setApellido1((String) request.getAttribute("apellido1"));
		pers.setApellido2((String) request.getAttribute("apellido2"));
		pers.setNombre1((String) request.getAttribute("nombre"));
		pers.setGeneroBean(gd.find(request.getAttribute("genero")));
		Date fechaNac;
		try {
			fechaNac = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter(""));
			pers.setFechaNac(fechaNac);
		} catch (ParseException e) {
			response.getWriter().append("ha ocurrido un error al ingresar la fecha de nacimiento, respeta el formato");
		}
		
		
		persd.insert(pers);
		response.getWriter().append("persona registrada");
		pers=persd.find(consulta(request).getId());
		
		usu.setCorreo((String) request.getAttribute("correo"));
		usu.setContrasena((String) request.getAttribute("pass"));
		System.out.println("fin");
		
		
		
	}

}

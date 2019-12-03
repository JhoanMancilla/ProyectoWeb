package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asesorame.*;
import dao.*;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
		Aprendiz a = new Aprendiz();
		AprendizDao aDao = new AprendizDao();
		Usuario u = new Usuario();
		UsuarioDao uDao = new UsuarioDao();
		String mat="";
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/asesorame", "root", "");
			
			 Statement st = con.createStatement();
			
			 String query = "SELECT * FROM `usuario` WHERE nombre_usuario = '"+request.getParameter("username")+"'";
			 ResultSet rs = st.executeQuery(query);
				while (rs.next())
		         { 
	 
					u = uDao.find(Integer.parseInt(rs.getString("id_persona")));          
		         }
				String query2 = "SELECT * FROM `aprendiz` WHERE `id_usuario`'"+u.getIdPersona()+"'";
				ResultSet rs2 = st.executeQuery(query);
				while (rs2.next())
			        { 
					a = aDao.find(Integer.parseInt(rs2.getString("id_usuario")));
			        }
				out.print("USUARIO"+a.getIdUsuario());
				String query3 = "SELECT * FROM `debilidades` WHERE `id_aprendiz` = '"+a.getIdUsuario()+"'";
				ResultSet rs3 = st.executeQuery(query);
			         
						while (rs3.next())
				         { 
							out.print(rs3.getString("id_materia"));
							 mat = rs3.getString("id_materia");
				         }
						 
						 
				 rs3.close();  
			     rs2.close();
		         rs.close();
		         st.close();
		         con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		if(u.getContrasena().equals(request.getParameter("pass"))) {
			HttpSession session = request.getSession();
			
			request.setAttribute("user", u); 
			request.setAttribute("mat", mat); 
			request.setAttribute("userNombre", u.getNombreUsuario()); 

	        RequestDispatcher rd = getServletContext().getRequestDispatcher("/panel.jsp");
	        rd.forward(request, response);
	        
		}else {
			request.setAttribute("user", 0); 
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
	        rd.forward(request, response);
		}
		
		
		
	}
	
	


}

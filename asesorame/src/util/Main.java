package util;


import java.util.ArrayList;

import asesorame.*;
import dao.*;

import java.sql.*;

public class Main {

	
	
	public static void main(String []args){

		Usuario u = new Usuario();
		UsuarioDao uDao = new UsuarioDao();
		
		u.setNombreUsuario("RealSmoke");
		Connection con;
		try {
			con = DriverManager.getConnection(
"jdbc:mysql://localhost/asesorame", "root", "");
			
			 Statement st = con.createStatement();
				String query = "SELECT * FROM `usuario` WHERE nombre_usuario = 'RealSmoke'";
				ResultSet rs = st.executeQuery("SELECT * FROM `usuario` WHERE nombre_usuario = 'newlife16'");
				while (rs.next())
		         { 
				u = uDao.find(Integer.parseInt(rs.getString("id_persona")));
		         }
		         rs.close();
		         st.close();
		         con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Clave"+ u.getContrasena());
		if(u.getContrasena()=="chowiesputo") {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
	
		
		
		
		
		
	
	
	
}
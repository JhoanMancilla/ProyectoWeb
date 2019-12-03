package util;


import java.util.ArrayList;

import asesorame.*;
import dao.*;



public class Main {

	
	
	public static void main(String []args) {

		Usuario u = new Usuario();
		UsuarioDao uDao = new UsuarioDao();
	
		u.setIdPersona(1);
		u = uDao.find(u);
		System.out.println("User: "+u);
			
	
	}
	
}
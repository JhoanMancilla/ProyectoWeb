package dao;


import asesorame.*;
import util.*;

public class UsuarioDao extends Conexion<Usuario> 

implements GenericDao<Usuario>{
	
public UsuarioDao() {
	super(Usuario.class);
	}
}
package dao;

import asesorame.*;
import util.*;

public class GeneroDao extends Conexion<Genero> 

implements GenericDao<Genero>{
	
public GeneroDao() {
	super(Genero.class);
	}
}
package dao;

import asesorame.*;
import util.*;

public class EstadoDao extends Conexion<Estado> 

implements GenericDao<Estado>{
	
public EstadoDao() {
	super(Estado.class);
	}
}
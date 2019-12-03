package dao;

import asesorame.*;
import util.*;

public class ComentarioDao extends Conexion<Comentario> 

implements GenericDao<Comentario>{
	
public ComentarioDao() {
	super(Comentario.class);
	}
}
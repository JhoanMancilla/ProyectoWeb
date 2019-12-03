package dao;

import asesorame.*;
import util.*;

public class AprendizDao extends Conexion<Aprendiz> 

implements GenericDao<Aprendiz>{
	
public AprendizDao() {
	super(Aprendiz.class);
	}
}
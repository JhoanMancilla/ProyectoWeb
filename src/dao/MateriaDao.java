package dao;

import asesorame.*;
import util.*;

public class MateriaDao extends Conexion<Materia> 

implements GenericDao<Materia>{
	
public MateriaDao() {
	super(Materia.class);
	}
}

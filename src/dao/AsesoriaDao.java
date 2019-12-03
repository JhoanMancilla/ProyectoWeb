package dao;

import asesorame.*;
import util.*;

public class AsesoriaDao extends Conexion<Asesoria> 

implements GenericDao<Asesoria>{
	
public AsesoriaDao() {
	super(Asesoria.class);
	}
}
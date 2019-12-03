package dao;

import asesorame.*;
import util.*;

public class AsistenciaDao extends Conexion<Asistencia> 

implements GenericDao<Asistencia>{
	
public AsistenciaDao() {
	super(Asistencia.class);
	}
}
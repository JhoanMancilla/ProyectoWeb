package dao;

import asesorame.*;
import util.*;

public class EstadoAsesoriaDao extends Conexion<EstadoAsesoria> 

implements GenericDao<EstadoAsesoria>{
	
public EstadoAsesoriaDao() {
	super(EstadoAsesoria.class);
	}
}
package dao;

import asesorame.*;
import util.*;

public class TipoAsesoriaDao extends Conexion<TipoAsesoria> 

implements GenericDao<TipoAsesoria>{
	
public TipoAsesoriaDao() {
	super(TipoAsesoria.class);
	}
}
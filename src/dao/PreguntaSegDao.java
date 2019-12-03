package dao;

import asesorame.*;
import util.*;

public class PreguntaSegDao extends Conexion<PreguntaSeg> 

implements GenericDao<PreguntaSeg>{
	
public PreguntaSegDao() {
	super(PreguntaSeg.class);
	}
}
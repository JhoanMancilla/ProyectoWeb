package dao;

import asesorame.*;
import util.*;

public class AsesorDao extends Conexion<Asesor> 

implements GenericDao<Asesor>{
	
public AsesorDao() {
	super(Asesor.class);
	}
}
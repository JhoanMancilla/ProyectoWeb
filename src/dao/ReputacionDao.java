package dao;

import asesorame.*;
import util.*;

public class ReputacionDao extends Conexion<Reputacion> 

implements GenericDao<Reputacion>{
	
public ReputacionDao() {
	super(Reputacion.class);
	}
}
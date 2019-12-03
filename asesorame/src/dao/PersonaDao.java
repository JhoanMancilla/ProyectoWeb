package dao;

import asesorame.*;
import util.*;

public class PersonaDao extends Conexion<Persona> 

implements GenericDao<Persona>{
	
public PersonaDao() {
	super(Persona.class);
	}
}
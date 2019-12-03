package util;
import dao.*;

import java.util.List;

import asesorame.*;
public class prueba {
	  private List<Materia> materias;
	    private List<PreguntaSeg> preguntas;
	    private List<Genero> generos;
	public static void main(String[] args) {
	prueba p = new prueba();
		Materia m= new Materia();
		MateriaDao md= new MateriaDao();
		PreguntaSeg ps= new PreguntaSeg();
		PreguntaSegDao psd= new PreguntaSegDao();
		Genero g= new Genero();
		GeneroDao gd= new GeneroDao();
		p.materias =md.list();
		p.preguntas =psd.list();
		p.generos= gd.list();
		System.out.println(p.generos.get(1).getNombre());
		System.out.println(p.preguntas.get(1).getDescripcion());
		System.out.println(p.materias.get(1).getNombre());
	}

}

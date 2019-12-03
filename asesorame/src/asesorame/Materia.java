package asesorame;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the materias database table.
 * 
 */
@Entity
@Table(name="materias")
@NamedQuery(name="Materia.findAll", query="SELECT m FROM Materia m")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nombre;

	//bi-directional many-to-many association to Aprendiz
	@ManyToMany
	@JoinTable(
		name="debilidades"
		, joinColumns={
			@JoinColumn(name="id_materia")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_aprendiz")
			}
		)
	private List<Aprendiz> aprendizs;

	//bi-directional many-to-many association to Asesor
	@ManyToMany
	@JoinTable(
		name="fortalezas"
		, joinColumns={
			@JoinColumn(name="id_materia")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_asesor")
			}
		)
	private List<Asesor> asesors;

	public Materia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Aprendiz> getAprendizs() {
		return this.aprendizs;
	}

	public void setAprendizs(List<Aprendiz> aprendizs) {
		this.aprendizs = aprendizs;
	}

	public List<Asesor> getAsesors() {
		return this.asesors;
	}

	public void setAsesors(List<Asesor> asesors) {
		this.asesors = asesors;
	}

}
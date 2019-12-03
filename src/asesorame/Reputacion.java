package asesorame;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the reputacion database table.
 * 
 */
@Entity
@NamedQuery(name="Reputacion.findAll", query="SELECT r FROM Reputacion r")
public class Reputacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_reputacion")
	private int idReputacion;

	private String descripcion;

	@Column(name="numero_asistencias")
	private int numeroAsistencias;

	private float valor;

	//bi-directional many-to-one association to Aprendiz
	@OneToMany(mappedBy="reputacion")
	private List<Aprendiz> aprendizs;

	//bi-directional many-to-one association to Asesor
	@OneToMany(mappedBy="reputacion")
	private List<Asesor> asesors;

	public Reputacion() {
	}

	public int getIdReputacion() {
		return this.idReputacion;
	}

	public void setIdReputacion(int idReputacion) {
		this.idReputacion = idReputacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNumeroAsistencias() {
		return this.numeroAsistencias;
	}

	public void setNumeroAsistencias(int numeroAsistencias) {
		this.numeroAsistencias = numeroAsistencias;
	}

	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public List<Aprendiz> getAprendizs() {
		return this.aprendizs;
	}

	public void setAprendizs(List<Aprendiz> aprendizs) {
		this.aprendizs = aprendizs;
	}

	public Aprendiz addAprendiz(Aprendiz aprendiz) {
		getAprendizs().add(aprendiz);
		aprendiz.setReputacion(this);

		return aprendiz;
	}

	public Aprendiz removeAprendiz(Aprendiz aprendiz) {
		getAprendizs().remove(aprendiz);
		aprendiz.setReputacion(null);

		return aprendiz;
	}

	public List<Asesor> getAsesors() {
		return this.asesors;
	}

	public void setAsesors(List<Asesor> asesors) {
		this.asesors = asesors;
	}

	public Asesor addAsesor(Asesor asesor) {
		getAsesors().add(asesor);
		asesor.setReputacion(this);

		return asesor;
	}

	public Asesor removeAsesor(Asesor asesor) {
		getAsesors().remove(asesor);
		asesor.setReputacion(null);

		return asesor;
	}

}
package asesorame;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the comentario database table.
 * 
 */
@Entity
@NamedQuery(name="Comentario.findAll", query="SELECT c FROM Comentario c")
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_comentario")
	private int idComentario;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="`fecha-hora`")
	private Date fecha_hora;

	//bi-directional many-to-many association to Aprendiz
	@ManyToMany
	@JoinTable(
		name="aprendiz_vs_comentario"
		, joinColumns={
			@JoinColumn(name="id_comentario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_aprendiz")
			}
		)
	private List<Aprendiz> aprendizs;

	//bi-directional many-to-many association to Asesor
	@ManyToMany
	@JoinTable(
		name="asesor_vs_comentario"
		, joinColumns={
			@JoinColumn(name="id_comentario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_asesor")
			}
		)
	private List<Asesor> asesors;

	public Comentario() {
	}

	public int getIdComentario() {
		return this.idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_hora() {
		return this.fecha_hora;
	}

	public void setFecha_hora(Date fecha_hora) {
		this.fecha_hora = fecha_hora;
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
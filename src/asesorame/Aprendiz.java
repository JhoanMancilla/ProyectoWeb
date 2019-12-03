package asesorame;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aprendiz database table.
 * 
 */
@Entity
@NamedQuery(name="Aprendiz.findAll", query="SELECT a FROM Aprendiz a")
public class Aprendiz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario")
	private int idUsuario;

	//bi-directional many-to-one association to Reputacion
	@ManyToOne
	@JoinColumn(name="id_reputacion")
	private Reputacion reputacion;

	//bi-directional one-to-one association to Usuario
	@OneToOne
	@JoinColumn(name="id_usuario", insertable=false, updatable=false)
	private Usuario usuario;

	//bi-directional many-to-many association to Comentario
	@ManyToMany(mappedBy="aprendizs")
	private List<Comentario> comentarios;

	//bi-directional many-to-one association to Asistencia
	@OneToMany(mappedBy="aprendiz")
	private List<Asistencia> asistencias;

	//bi-directional many-to-many association to Materia
	@ManyToMany(mappedBy="aprendizs")
	private List<Materia> materias;

	public Aprendiz() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Reputacion getReputacion() {
		return this.reputacion;
	}

	public void setReputacion(Reputacion reputacion) {
		this.reputacion = reputacion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Asistencia> getAsistencias() {
		return this.asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

	public Asistencia addAsistencia(Asistencia asistencia) {
		getAsistencias().add(asistencia);
		asistencia.setAprendiz(this);

		return asistencia;
	}

	public Asistencia removeAsistencia(Asistencia asistencia) {
		getAsistencias().remove(asistencia);
		asistencia.setAprendiz(null);

		return asistencia;
	}

	public List<Materia> getMaterias() {
		return this.materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

}
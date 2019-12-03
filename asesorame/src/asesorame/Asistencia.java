package asesorame;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the asistencia database table.
 * 
 */
@Entity
@NamedQuery(name="Asistencia.findAll", query="SELECT a FROM Asistencia a")
public class Asistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_asistencia")
	private int idAsistencia;

	private int verificado;

	//bi-directional many-to-one association to Aprendiz
	@ManyToOne
	@JoinColumn(name="id_aprendiz")
	private Aprendiz aprendiz;

	//bi-directional many-to-one association to Asesoria
	@ManyToOne
	@JoinColumn(name="id_asesoria")
	private Asesoria asesoria;

	public Asistencia() {
	}

	public int getIdAsistencia() {
		return this.idAsistencia;
	}

	public void setIdAsistencia(int idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	public int getVerificado() {
		return this.verificado;
	}

	public void setVerificado(int verificado) {
		this.verificado = verificado;
	}

	public Aprendiz getAprendiz() {
		return this.aprendiz;
	}

	public void setAprendiz(Aprendiz aprendiz) {
		this.aprendiz = aprendiz;
	}

	public Asesoria getAsesoria() {
		return this.asesoria;
	}

	public void setAsesoria(Asesoria asesoria) {
		this.asesoria = asesoria;
	}

}
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

	@EmbeddedId
	private AsistenciaPK id;

	private int verificado;

	//bi-directional many-to-one association to Aprendiz
	@ManyToOne
	@JoinColumn(name="id_aprendiz", insertable=false, updatable=false)
	private Aprendiz aprendiz;

	//bi-directional many-to-one association to Asesoria
	@ManyToOne
	@JoinColumn(name="id_asesoria", insertable=false, updatable=false)
	private Asesoria asesoria;

	public Asistencia() {
	}

	public AsistenciaPK getId() {
		return this.id;
	}

	public void setId(AsistenciaPK id) {
		this.id = id;
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
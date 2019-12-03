package asesorame;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the asistencia database table.
 * 
 */
@Embeddable
public class AsistenciaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_aprendiz", insertable=false, updatable=false)
	private int idAprendiz;

	@Column(name="id_asesoria", insertable=false, updatable=false)
	private int idAsesoria;

	public AsistenciaPK() {
	}
	public int getIdAprendiz() {
		return this.idAprendiz;
	}
	public void setIdAprendiz(int idAprendiz) {
		this.idAprendiz = idAprendiz;
	}
	public int getIdAsesoria() {
		return this.idAsesoria;
	}
	public void setIdAsesoria(int idAsesoria) {
		this.idAsesoria = idAsesoria;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AsistenciaPK)) {
			return false;
		}
		AsistenciaPK castOther = (AsistenciaPK)other;
		return 
			(this.idAprendiz == castOther.idAprendiz)
			&& (this.idAsesoria == castOther.idAsesoria);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idAprendiz;
		hash = hash * prime + this.idAsesoria;
		
		return hash;
	}
}
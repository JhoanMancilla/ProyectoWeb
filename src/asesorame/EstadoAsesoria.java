package asesorame;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado_asesoria database table.
 * 
 */
@Entity
@Table(name="estado_asesoria")
@NamedQuery(name="EstadoAsesoria.findAll", query="SELECT e FROM EstadoAsesoria e")
public class EstadoAsesoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estado")
	private int idEstado;

	private String nombre;

	//bi-directional many-to-one association to Asesoria
	@OneToMany(mappedBy="estadoAsesoria")
	private List<Asesoria> asesorias;

	public EstadoAsesoria() {
	}

	public int getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Asesoria> getAsesorias() {
		return this.asesorias;
	}

	public void setAsesorias(List<Asesoria> asesorias) {
		this.asesorias = asesorias;
	}

	public Asesoria addAsesoria(Asesoria asesoria) {
		getAsesorias().add(asesoria);
		asesoria.setEstadoAsesoria(this);

		return asesoria;
	}

	public Asesoria removeAsesoria(Asesoria asesoria) {
		getAsesorias().remove(asesoria);
		asesoria.setEstadoAsesoria(null);

		return asesoria;
	}

}
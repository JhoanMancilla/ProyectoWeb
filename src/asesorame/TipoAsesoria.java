package asesorame;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_asesoria database table.
 * 
 */
@Entity
@Table(name="tipo_asesoria")
@NamedQuery(name="TipoAsesoria.findAll", query="SELECT t FROM TipoAsesoria t")
public class TipoAsesoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo")
	private int idTipo;

	private String nombre;

	//bi-directional many-to-one association to Asesoria
	@OneToMany(mappedBy="tipoAsesoria")
	private List<Asesoria> asesorias;

	public TipoAsesoria() {
	}

	public int getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
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
		asesoria.setTipoAsesoria(this);

		return asesoria;
	}

	public Asesoria removeAsesoria(Asesoria asesoria) {
		getAsesorias().remove(asesoria);
		asesoria.setTipoAsesoria(null);

		return asesoria;
	}

}
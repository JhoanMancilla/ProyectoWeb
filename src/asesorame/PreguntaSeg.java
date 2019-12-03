package asesorame;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pregunta_seg database table.
 * 
 */
@Entity
@Table(name="pregunta_seg")
@NamedQuery(name="PreguntaSeg.findAll", query="SELECT p FROM PreguntaSeg p")
public class PreguntaSeg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pregunta")
	private int idPregunta;

	private String descripcion;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="preguntaSeg")
	private List<Usuario> usuarios;

	public PreguntaSeg() {
	}

	public int getIdPregunta() {
		return this.idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPreguntaSeg(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPreguntaSeg(null);

		return usuario;
	}

}
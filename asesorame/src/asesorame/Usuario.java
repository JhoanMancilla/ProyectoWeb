package asesorame;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_persona")
	private int idPersona;

	private String contrasena;

	private String correo;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_reg")
	private Date fechaReg;

	@Column(name="inst_educativa")
	private String instEducativa;

	@Column(name="nombre_usuario")
	private String nombreUsuario;

	private String respuesta;

	//bi-directional one-to-one association to Aprendiz
	@OneToOne(mappedBy="usuario")
	private Aprendiz aprendiz;

	//bi-directional one-to-one association to Asesor
	@OneToOne(mappedBy="usuario")
	private Asesor asesor;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="estado")
	private Estado estadoBean;

	//bi-directional one-to-one association to Persona
	@OneToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	//bi-directional many-to-one association to PreguntaSeg
	@ManyToOne
	@JoinColumn(name="id_pregunta")
	private PreguntaSeg preguntaSeg;

	public Usuario() {
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaReg() {
		return this.fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public String getInstEducativa() {
		return this.instEducativa;
	}

	public void setInstEducativa(String instEducativa) {
		this.instEducativa = instEducativa;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Aprendiz getAprendiz() {
		return this.aprendiz;
	}

	public void setAprendiz(Aprendiz aprendiz) {
		this.aprendiz = aprendiz;
	}

	public Asesor getAsesor() {
		return this.asesor;
	}

	public void setAsesor(Asesor asesor) {
		this.asesor = asesor;
	}

	public Estado getEstadoBean() {
		return this.estadoBean;
	}

	public void setEstadoBean(Estado estadoBean) {
		this.estadoBean = estadoBean;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public PreguntaSeg getPreguntaSeg() {
		return this.preguntaSeg;
	}

	public void setPreguntaSeg(PreguntaSeg preguntaSeg) {
		this.preguntaSeg = preguntaSeg;
	}

}
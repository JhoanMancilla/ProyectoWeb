package asesorame;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the asesoria database table.
 * 
 */
@Entity
@NamedQuery(name="Asesoria.findAll", query="SELECT a FROM Asesoria a")
public class Asesoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_asesor")
	private int idAsesor;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="`fecha-hora`")
	private Date fecha_hora;

	private String lugar;

	private int precio;

	//bi-directional one-to-one association to Asesor
	@OneToOne
	@JoinColumn(name="id_asesor")
	private Asesor asesor;

	//bi-directional many-to-one association to EstadoAsesoria
	@ManyToOne
	@JoinColumn(name="estado")
	private EstadoAsesoria estadoAsesoria;

	//bi-directional many-to-one association to TipoAsesoria
	@ManyToOne
	@JoinColumn(name="tipo")
	private TipoAsesoria tipoAsesoria;

	//bi-directional many-to-one association to Asistencia
	@OneToMany(mappedBy="asesoria")
	private List<Asistencia> asistencias;

	public Asesoria() {
	}

	public int getIdAsesor() {
		return this.idAsesor;
	}

	public void setIdAsesor(int idAsesor) {
		this.idAsesor = idAsesor;
	}

	public Date getFecha_hora() {
		return this.fecha_hora;
	}

	public void setFecha_hora(Date fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Asesor getAsesor() {
		return this.asesor;
	}

	public void setAsesor(Asesor asesor) {
		this.asesor = asesor;
	}

	public EstadoAsesoria getEstadoAsesoria() {
		return this.estadoAsesoria;
	}

	public void setEstadoAsesoria(EstadoAsesoria estadoAsesoria) {
		this.estadoAsesoria = estadoAsesoria;
	}

	public TipoAsesoria getTipoAsesoria() {
		return this.tipoAsesoria;
	}

	public void setTipoAsesoria(TipoAsesoria tipoAsesoria) {
		this.tipoAsesoria = tipoAsesoria;
	}

	public List<Asistencia> getAsistencias() {
		return this.asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

	public Asistencia addAsistencia(Asistencia asistencia) {
		getAsistencias().add(asistencia);
		asistencia.setAsesoria(this);

		return asistencia;
	}

	public Asistencia removeAsistencia(Asistencia asistencia) {
		getAsistencias().remove(asistencia);
		asistencia.setAsesoria(null);

		return asistencia;
	}

}
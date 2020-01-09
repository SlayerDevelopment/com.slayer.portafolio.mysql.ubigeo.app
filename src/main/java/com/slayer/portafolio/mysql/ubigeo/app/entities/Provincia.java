package com.slayer.portafolio.mysql.ubigeo.app.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "provincia", indexes = { @Index(name = "index_valor_provincia", columnList = "valor", unique = true) })
public class Provincia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "valor", nullable = false, length = 4, unique = true)
	private String valor;

	@Column(name = "nombre", nullable = false, length = 25)
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "departamento_id", nullable = false)
	private Departamento departamentoId;

	@OneToMany(mappedBy = "provinciaId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Distrito> distritos = new ArrayList<Distrito>();

	public Provincia() {

	}

	public Provincia(Long id, String valor, String nombre, Departamento departamentoId, List<Distrito> distritos) {
		this.id = id;
		this.valor = valor;
		this.nombre = nombre;
		this.departamentoId = departamentoId;
		this.distritos = distritos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Departamento getDepartamentoId() {
		return departamentoId;
	}

	public void setDepartamentoId(Departamento departamentoId) {
		this.departamentoId = departamentoId;
	}

	public List<Distrito> getDistritos() {
		return distritos;
	}

	public void setDistritos(List<Distrito> distritos) {
		this.distritos = distritos;
	}

	@Override
	public String toString() {
		return "Provincia [id=" + id + ", valor=" + valor + ", nombre=" + nombre + ", departamentoId=" + departamentoId
				+ ", distritos=" + distritos + "]";
	}

}

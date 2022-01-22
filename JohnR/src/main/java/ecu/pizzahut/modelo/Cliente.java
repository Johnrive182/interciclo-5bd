package ecu.pizzahut.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 4563184521756911824L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nif;

	@Column(nullable = false)
	private String nombre;
	private String direccion;

	public Cliente() {
	}

	public Cliente(int nif, String nombre, String direccion) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public int getNif() {
		return nif;
	}

	public void setNif(int nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}

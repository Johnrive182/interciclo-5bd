package ecu.pizzahut.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "linea_de_pedido")
public class Linea_de_Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_lpe;
	
	@Column
	private int cantidad;
	private int precio_unidad;
	private String descuento;

	public Linea_de_Pedido() {
	}

	public Linea_de_Pedido(int cantidad, int precio_unidad, String descuento) {
		super();
		this.cantidad = cantidad;
		this.precio_unidad = precio_unidad;
		this.descuento = descuento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio_unidad() {
		return precio_unidad;
	}

	public void setPrecio_unidad(int precio_unidad) {
		this.precio_unidad = precio_unidad;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}

}

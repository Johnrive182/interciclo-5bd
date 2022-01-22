package ecu.pizzahut.infraestructura.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ecu.pizzahut.modelo.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {

	@Query("select pe from Pedido pe where pe.numero like %:numero%")
	List<Pedido> findAllByPe(String numero);

}
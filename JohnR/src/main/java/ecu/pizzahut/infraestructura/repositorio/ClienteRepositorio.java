package ecu.pizzahut.infraestructura.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ecu.pizzahut.modelo.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

	@Query("select cli from Cliente cli where cli.nombre like %:nombre%")
	List<Cliente> findAllByNombre(String nombre);

}

package ecu.pizzahut.infraestructura.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ecu.pizzahut.modelo.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

	@Query("select prod from Producto prod where prod.descripcion like %:descripcion%")
	List<Producto> findAllByDescri(String descripcion);

}
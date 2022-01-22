package ecu.pizzahut.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ecu.pizzahut.infraestructura.repositorio.ClienteRepositorio;
import ecu.pizzahut.modelo.Cliente;

@RestController
@RequestMapping("/api")
public class ClienteControl {

	@Autowired
	private ClienteRepositorio cliRepositorio;

	@GetMapping("/clientes")
	public List<Cliente> index() {
		return cliRepositorio.findAll();
	}

	@PostMapping("/pcliente")
	public ResponseEntity<?> saveCliente(@RequestBody Cliente cliente, BindingResult result) {
		Cliente clienteGrabar;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errores = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("Los errores son", errores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			clienteGrabar = cliRepositorio.save(cliente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al ingresar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El Cliente se ha insertado con éxito");
		response.put("Cliente: ", clienteGrabar);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}

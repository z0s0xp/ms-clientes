package common.msclientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import common.msclientes.implementacion.ClienteLogic;
import common.persistence.entitys.Clientes;
import common.persistence.request.ClientesRequest;

@RestController
@RequestMapping("clientes/")
public class ClienteController {

	@Autowired
	ClienteLogic cliente;
	
	// http://localhost:8091/clientes/mostar GET
		@GetMapping("mostrar")
		public ResponseEntity<List<Clientes>> listarTodos() {
			List<Clientes> clientes = cliente.mostrar();
			return new ResponseEntity<List<Clientes>>(clientes, HttpStatus.OK);
		}

		// http://localhost:8091/clientes/ POST
		@PostMapping
		public ResponseEntity<Clientes> guardar(@RequestBody ClientesRequest request) {
			Clientes c = cliente.guardar(request);
			return new ResponseEntity<Clientes>(c, HttpStatus.OK);
		}

		// http://localhost:8091/clientes/ PUT
		@PutMapping
		public ResponseEntity<Clientes> actualizar(@RequestBody ClientesRequest request) {
			Clientes c = cliente.actualizar(request);
			return new ResponseEntity<Clientes>(c, HttpStatus.OK);
		}
		
		//http://localhost:8091/clientes/buscar-por-id/5	GET
		@GetMapping("buscar-por-id/{id}")
		public ResponseEntity<Clientes> buscar(@PathVariable int id){
			Clientes c = cliente.buscar(id);
			return new ResponseEntity<Clientes>(c, HttpStatus.OK);		
		}
		
		//http://localhost:8091/clientes/eliminar/5	DELETE
		@DeleteMapping("eliminar/{id}")
		public ResponseEntity<String> eliminar(@PathVariable int id){
			String mensaje = cliente.eliminar(id);
			return new ResponseEntity<String>(mensaje, HttpStatus.OK);		
		}
	
	
}

package common.msclientes.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import common.msclientes.service.IClientesService;
import common.persistence.entitys.Clientes;
import common.persistence.repositorys.IClientesRepository;
import common.persistence.request.ClientesRequest;

@Service
public class ClienteLogic implements IClientesService {

	@Autowired
	IClientesRepository crepository;

	@Override
	public Clientes guardar(ClientesRequest request) {
		Clientes clientes = new Clientes();
		clientes.setNombre(request.getNombre());
		clientes.setFechaNac(request.getFechaNac());
		clientes.setDomicilio(request.getDomicilio());
		crepository.save(clientes);
		return clientes;
	}

	@Override
	public Clientes actualizar(ClientesRequest request) {
		Clientes clientes = crepository.findById(request.getCustomerId()).get();
		clientes.setNombre(request.getNombre());
		clientes.setFechaNac(request.getFechaNac());
		clientes.setDomicilio(request.getDomicilio());
		crepository.save(clientes);
		return clientes;
		
		
	}

	@Override
	public Clientes buscar(int id) {
		// TODO Auto-generated method stub
		return crepository.findById(id).get();
	}

	@Override
	public String eliminar(int id) {
		crepository.deleteById(id);
		return "Eliminado";
	}

	@Override
	public List mostrar() {
		
		return crepository.findAll();
	}
	

}

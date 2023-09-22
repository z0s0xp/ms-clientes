package common.msclientes.service;

import java.util.List;

import common.persistence.entitys.Clientes;
import common.persistence.request.ClientesRequest;

public interface IClientesService {

	Clientes guardar(ClientesRequest request);
	Clientes actualizar(ClientesRequest request);
	Clientes buscar(int id);
	String eliminar(int id);
	List mostrar();
}

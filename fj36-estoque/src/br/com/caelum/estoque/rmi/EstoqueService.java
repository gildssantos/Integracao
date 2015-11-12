package br.com.caelum.estoque.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class EstoqueService extends UnicastRemoteObject implements EstoqueRmi {

	private static final long serialVersionUID = 1L;

	private Map<String, ItemEstoque> repositorio = new HashMap<>();

	public EstoqueService() throws RemoteException {
		repositorio.put("ARQ", new ItemEstoque("ARQ", 5));
		repositorio.put("SOA", new ItemEstoque("SOA", 2));

		repositorio.put("TDD", new ItemEstoque("TDD", 3));
		repositorio.put("RES", new ItemEstoque("RES", 4));

		repositorio.put("LOG", new ItemEstoque("LOG", 3));
		repositorio.put("WEB", new ItemEstoque("WEB", 4));
	}

	@Override
	public ItemEstoque getItemEstoque(String CodigoProduto)
			throws RemoteException {

		System.out.println("Verificando o Estoque do Produto" + CodigoProduto);

		return this.repositorio.get(CodigoProduto);
	}

}

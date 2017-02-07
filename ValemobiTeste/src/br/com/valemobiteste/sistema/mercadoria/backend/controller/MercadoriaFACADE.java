package br.com.valemobiteste.sistema.mercadoria.backend.controller;

import java.util.ArrayList;

import br.com.valemobiteste.exceptions.ApplicationException;
import br.com.valemobiteste.interfaces.Crud;
import br.com.valemobiteste.sistema.mercadoria.backend.model.MercadoriaPO;
import br.com.valemobiteste.sistema.mercadoria.backend.model.MercadoriaSERVICE;

public class MercadoriaFACADE implements Crud< MercadoriaPO >{

	private final MercadoriaSERVICE SERVICE;

	public MercadoriaFACADE(){
		SERVICE = new MercadoriaSERVICE();
	}

	public void inserir( MercadoriaPO po ) throws ApplicationException {
		SERVICE.inserir( po );
	}

	public void alterar( MercadoriaPO po ) throws ApplicationException {
		SERVICE.alterar( po );
	}

	public void excluir( MercadoriaPO po ) throws ApplicationException {
		SERVICE.excluir( po );
	}

	public ArrayList< MercadoriaPO > filtrar( MercadoriaPO po ) throws ApplicationException {
		return SERVICE.filtrar( po );
	}

	public ArrayList< MercadoriaPO > filtrarTodos() throws ApplicationException {
		return SERVICE.filtrarTodos();
	}

	public MercadoriaPO filtrarPorId( Long id ) throws ApplicationException {
		return SERVICE.filtrarPorId( id );
	}

}

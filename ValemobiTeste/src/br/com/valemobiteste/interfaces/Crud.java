package br.com.valemobiteste.interfaces;

import java.util.ArrayList;

import br.com.valemobiteste.exceptions.ApplicationException;

public interface Crud< T > {

	void inserir( T po ) throws ApplicationException;

	void alterar( T po ) throws ApplicationException;

	void excluir( T po ) throws ApplicationException;

	ArrayList< T > filtrar( T po ) throws ApplicationException;

	ArrayList< T > filtrarTodos() throws ApplicationException;

	T filtrarPorId( Long id ) throws ApplicationException;
}

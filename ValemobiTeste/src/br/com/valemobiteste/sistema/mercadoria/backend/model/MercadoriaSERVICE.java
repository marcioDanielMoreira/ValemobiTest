package br.com.valemobiteste.sistema.mercadoria.backend.model;

import java.util.ArrayList;
import java.util.List;

import br.com.valemobiteste.abstracts.AbstractPO;
import br.com.valemobiteste.connection.HibernateConnection;
import br.com.valemobiteste.exceptions.ApplicationException;
import br.com.valemobiteste.interfaces.Crud;
import br.com.valemobiteste.sistema.mercadoria.backend.dao.MercadoriaDAO;

public class MercadoriaSERVICE implements Crud< MercadoriaPO >{

	private final MercadoriaDAO DAO;

	/** Construtor responsável por inicializar o atributo DAO */
	public MercadoriaSERVICE(){
		DAO = new MercadoriaDAO();
	}

	public void inserir( MercadoriaPO po ) throws ApplicationException {

		HibernateConnection< AbstractPO > hibernate = new HibernateConnection< AbstractPO >();

		try {

			/** 1º Iniciar a Transação */
			hibernate.iniciarTransacao();
			/** Fazer o que tem que fazer */
			DAO.inserir( po, hibernate );
			/** 3º Confirmar a Transação */
			hibernate.commitTransacao();
		} catch ( ApplicationException e ) {
			hibernate.rollbackTransacao();
			throw e;
		} catch ( Exception e ) {
			hibernate.rollbackTransacao();
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}

	public void alterar( MercadoriaPO po ) throws ApplicationException {

		HibernateConnection< AbstractPO > hibernate = new HibernateConnection< AbstractPO >();

		try {

			/** 1º Iniciar a Transação */
			hibernate.iniciarTransacao();
			/** Fazer o que tem que fazer */
			DAO.alterar( po, hibernate );
			/** 3º Confirmar a Transação */
			hibernate.commitTransacao();
		} catch ( ApplicationException e ) {
			hibernate.rollbackTransacao();
			throw e;
		} catch ( Exception e ) {
			hibernate.rollbackTransacao();
			throw new ApplicationException( "Erro desconhecido", e );
		}

	}

	public void excluir( MercadoriaPO po ) throws ApplicationException {
		HibernateConnection< AbstractPO > hibernate = new HibernateConnection< AbstractPO >();

		try {
			/** 1º Iniciar a Transação */
			hibernate.iniciarTransacao();
			/** Fazer o que tem que fazer */
			DAO.excluir( po, hibernate );
			/** 3º Confirmar a Transação */
			hibernate.commitTransacao();
		} catch ( ApplicationException e ) {
			hibernate.rollbackTransacao();
			throw e;
		} catch ( Exception e ) {
			hibernate.rollbackTransacao();
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}

	public ArrayList< MercadoriaPO > filtrar( MercadoriaPO po ) throws ApplicationException {
		HibernateConnection< AbstractPO > hibernate = new HibernateConnection< AbstractPO >();

		try {
			/** 1º Iniciar a Transação */
			hibernate.iniciarTransacao();

			/** Fazer o que tem que fazer */
			ArrayList< MercadoriaPO > encontrados = DAO.filtrar( po, hibernate );

			/** 3º Confirmar a Transação */
			hibernate.commitTransacao();

			return encontrados;
		} catch ( ApplicationException e ) {
			hibernate.rollbackTransacao();
			throw e;
		} catch ( Exception e ) {
			hibernate.rollbackTransacao();
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}

	public ArrayList< MercadoriaPO > filtrarTodos() throws ApplicationException {
		HibernateConnection< AbstractPO > hibernate = new HibernateConnection< AbstractPO >();

		try {
			/** 1º Iniciar a Transação */
			hibernate.iniciarTransacao();

			/** Fazer o que tem que fazer */
			List encontrados = DAO.filtrarTodos( hibernate );

			/** 3º Confirmar a Transação */
			hibernate.commitTransacao();

			return (ArrayList< MercadoriaPO >) encontrados;
		} catch ( ApplicationException e ) {
			hibernate.rollbackTransacao();
			throw e;
		} catch ( Exception e ) {
			hibernate.rollbackTransacao();
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}

	public MercadoriaPO filtrarPorId( Long id ) throws ApplicationException {
		HibernateConnection< AbstractPO > hibernate = new HibernateConnection< AbstractPO >();

		try {
			/** 1º Iniciar a Transação */
			hibernate.iniciarTransacao();

			/** Fazer o que tem que fazer */
			MercadoriaPO encontrado = DAO.filtrarPorId( id, hibernate );

			/** 3º Confirmar a Transação */
			hibernate.commitTransacao();

			return encontrado;
		} catch ( ApplicationException e ) {
			hibernate.rollbackTransacao();
			throw e;
		} catch ( Exception e ) {
			hibernate.rollbackTransacao();
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}

}

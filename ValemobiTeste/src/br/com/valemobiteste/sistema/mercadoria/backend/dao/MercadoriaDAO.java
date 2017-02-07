package br.com.valemobiteste.sistema.mercadoria.backend.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.valemobiteste.abstracts.AbstractPO;
import br.com.valemobiteste.connection.HibernateConnection;
import br.com.valemobiteste.exceptions.ApplicationException;
import br.com.valemobiteste.sistema.mercadoria.backend.model.MercadoriaPO;

public final class MercadoriaDAO{

	public void inserir( MercadoriaPO po, HibernateConnection< AbstractPO > hibernate ) throws ApplicationException {
		try {

			po.setId( ( (MercadoriaPO) hibernate.inserir( po ) ).getId() );

		} catch ( ApplicationException e ) {
			throw e;
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}

	public void alterar( MercadoriaPO po, HibernateConnection< AbstractPO > hibernate ) throws ApplicationException {
		try {
			hibernate.alterar( po );
		} catch ( ApplicationException e ) {
			throw e;
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}

	public void excluir( MercadoriaPO po, HibernateConnection< AbstractPO > hibernate ) throws ApplicationException {
		try {
			hibernate.excluir( po );
		} catch ( ApplicationException e ) {
			throw e;
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}

	public ArrayList< MercadoriaPO > filtrar( MercadoriaPO poFiltrar, HibernateConnection< AbstractPO > hibernate ) throws ApplicationException {

		try {
			Criteria criteria = hibernate.getSessaoCorrente().createCriteria( MercadoriaPO.class );

			/*MONTANDO AS RESTRIÇÕES DINAMICAS*/
			if ( poFiltrar.getPreco() != null ) {
				criteria.add( Restrictions.eq( "preco", poFiltrar.getPreco() ) );
			}

			if ( poFiltrar.getQuantidade() != null ) {
				criteria.add( Restrictions.eq( "quantidade", poFiltrar.getQuantidade() ) );
			}

			if ( poFiltrar.getTipo() != null ) {
				criteria.add( Restrictions.like( "tipo", poFiltrar.getTipo(), MatchMode.START ) );
			}

			if ( poFiltrar.getTipoNegocio() != null ) {
				criteria.add( Restrictions.like( "tipoNegocio", poFiltrar.getTipoNegocio(), MatchMode.START ) );
			}

			if ( poFiltrar.getId() != null ) {
				criteria.add( Restrictions.idEq( poFiltrar.getId() ) );
			}

			if ( poFiltrar.getNome() != null ) {
				criteria.add( Restrictions.like( "nome", poFiltrar.getNome(), MatchMode.START ) );
			}

			return (ArrayList< MercadoriaPO >) criteria.list();
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}

	public List filtrarTodos( HibernateConnection< AbstractPO > hibernate ) throws ApplicationException {
		try {
			return hibernate.filtrarTodos( MercadoriaPO.class );
		} catch ( ApplicationException e ) {
			throw e;
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}

	public MercadoriaPO filtrarPorId( Long id, HibernateConnection< AbstractPO > hibernate ) throws ApplicationException {

		try {
			return (MercadoriaPO) hibernate.filtrarPorId( MercadoriaPO.class, id );
		} catch ( ApplicationException e ) {
			throw e;
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}

}

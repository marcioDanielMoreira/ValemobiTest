package br.com.valemobiteste.connection;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import br.com.valemobiteste.exceptions.ApplicationException;

public final class HibernateConnection< T > {

	/** UTILIZAÇÃO DO HIBERNATE 4.x */
	private static final SessionFactory SESSION_FACTORY;
	protected Session sessaoCorrente;
	private Transaction transacao;

	/**
	 * Bloco estático responsável por carregar um objeto "Configuration" com os
	 * dados configurados na TAG (<hibernate-configuration>) do arquivo
	 * hibernate.cfg.xml PS: Bloco estático garante que seu conteúdo será
	 * executado pelo meno uma(1) vez ao instanciar a classe onde foi escrito.
	 */
	static {
		Configuration configuration = new Configuration().configure( "hibernate.cfg.xml" );
		configuration.setProperty( "hibernate.connection.url", "jdbc:mysql://us-cdbr-iron-east-04.cleardb.net/heroku_ce200899fc2742a?reconnect=true" );

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings( configuration.getProperties() ).buildServiceRegistry();
		SESSION_FACTORY = configuration.buildSessionFactory( serviceRegistry );
	}

	public Session getSessaoCorrente() {
		return sessaoCorrente;
	}

	private void abrirSessao() {
		sessaoCorrente = SESSION_FACTORY.openSession();
	}

	private void fecharSessao() {
		if ( sessaoCorrente != null ) {
			sessaoCorrente.close();
			sessaoCorrente = null;
		}
	}

	/**
	 * Informa que uma transação(persistencia) será feita no banco de dados.
	 * todas as transações devem ser confirmadas(commit) ou desfeitas(rollback)
	 * 
	 * @author Gabriel Damiani Carvalheiro <gabriel.carvalheiro@gmail.com.br>
	 * @since 4 de out de 2015 11:11:14
	 * @version 1.0
	 */
	public void iniciarTransacao() {
		abrirSessao();
		transacao = sessaoCorrente.beginTransaction();
	}

	public void commitTransacao() {
		if ( transacao != null ) {
			transacao.commit();
			fecharSessao();
			transacao = null;
		}
	}

	public void rollbackTransacao() {
		if ( transacao != null ) {
			transacao.rollback();
			fecharSessao();
			transacao = null;
		}
	}

	public T inserir( T po ) throws ApplicationException {
		try {
			return (T) sessaoCorrente.merge( po );
		} catch ( Throwable e ) {
			throw new ApplicationException( "Erro desconhecido!", e );
		}
	}

	public T alterar( T po ) throws ApplicationException {
		try {
			return (T) sessaoCorrente.merge( po );
		} catch ( Throwable e ) {
			throw new ApplicationException( "Erro desconhecido!", e );
		}
	}

	public void excluir( T po ) throws ApplicationException {
		try {
			sessaoCorrente.delete( po );
		} catch ( Throwable e ) {
			throw new ApplicationException( "Erro desconhecido!", e );
		}
	}

	public T filtrarPorId( Class clazz, Long id ) throws ApplicationException {
		try {
			Criteria criteria = sessaoCorrente.createCriteria( clazz );

			/** Caso a select retorne 2 tuplas identicas, ele transformará em 1 só. */
			/** Ele força tambem o resultado da select virar do tipo da Classe passada. */
			criteria.setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY );

			criteria.add( Restrictions.idEq( id ) );

			return (T) criteria.uniqueResult();

		} catch ( Throwable e ) {
			throw new ApplicationException( "Erro desconhecido!", e );
		}
	}

	public List filtrarTodos( Class clazz ) throws ApplicationException {
		try {
			Criteria criteria = sessaoCorrente.createCriteria( clazz );

			/** Caso a select retorne 2 tuplas identicas, ele transformará em 1 só. */
			/** Ele força tambem o resultado da select virar do tipo da Classe passada. */
			criteria.setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY );

			return criteria.list();

		} catch ( Throwable e ) {
			throw new ApplicationException( "Erro desconhecido!", e );
		}
	}
}
package br.com.valemobiteste.sistema.mercadoria.frontend;

import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import br.com.valemobiteste.exceptions.ApplicationException;
import br.com.valemobiteste.sistema.mercadoria.backend.controller.MercadoriaFACADE;
import br.com.valemobiteste.sistema.mercadoria.backend.model.MercadoriaPO;
import br.com.valemobiteste.util.Messages;
import br.com.valemobiteste.util.Utilidades;

public final class MercadoriaAction extends DispatchAction{

	public ActionForward abrirTela( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		MercadoriaForm meuForm = (MercadoriaForm) form;

		meuForm.limparCampos();

		/** O Mapping vai até o struts-config.xml procurar um forward com o nome passado como parametro */
		return filtrar( mapping, meuForm, request, response );
	}

	public ActionForward inserir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		MercadoriaForm meuForm = (MercadoriaForm) form;

		try {
			MercadoriaFACADE facade = new MercadoriaFACADE();

			facade.inserir( montarPO( meuForm ) );

			meuForm.limparCampos();

			this.addMessages( request, Messages.createMessages( "sucesso" ) );
		} catch ( ApplicationException e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", e.getMessage() ) );
		}

		/** O Mapping vai até o struts-config.xml procurar um forward com o nome passado como parametro */
		return filtrar( mapping, meuForm, request, response );
	}

	public ActionForward filtrar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		MercadoriaForm meuForm = (MercadoriaForm) form;

		try {
			MercadoriaFACADE facade = new MercadoriaFACADE();

			ArrayList< MercadoriaPO > encontrados = facade.filtrar( montarPO( meuForm ) );

			meuForm.setMercadorias( encontrados );

		} catch ( ApplicationException e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", e.getMessage() ) );
		}

		/** O Mapping vai até o struts-config.xml procurar um forward com o nome passado como parametro */
		return mapping.findForward( "mercadoriaCadastro" );
	}

	public ActionForward selecionar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		MercadoriaForm meuForm = (MercadoriaForm) form;

		try {
			MercadoriaFACADE facade = new MercadoriaFACADE();

			MercadoriaPO encontrado = facade.filtrarPorId( Long.valueOf( meuForm.getId() ) );

			meuForm.setId( encontrado.getId().toString() );
			meuForm.setNome( encontrado.getNome() );
			meuForm.setPreco( Utilidades.parseBigDecimal( encontrado.getPreco() ) );
			meuForm.setQuantidade( encontrado.getQuantidade().toString() );
			meuForm.setTipo( encontrado.getTipo() );
			meuForm.setTipoNegocio( encontrado.getTipoNegocio() );

		} catch ( ApplicationException e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", e.getMessage() ) );
		}

		/** O Mapping vai até o struts-config.xml procurar um forward com o nome passado como parametro */
		return mapping.findForward( "mercadoriaCadastro" );
	}

	public ActionForward excluir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		MercadoriaForm meuForm = (MercadoriaForm) form;

		try {
			MercadoriaFACADE facade = new MercadoriaFACADE();

			facade.excluir( montarPO( meuForm ) );

			meuForm.limparCampos();

			this.addMessages( request, Messages.createMessages( "sucesso" ) );
		} catch ( ApplicationException e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", e.getMessage() ) );
		}

		/** O Mapping vai até o struts-config.xml procurar um forward com o nome passado como parametro */
		return filtrar( mapping, meuForm, request, response );
	}

	public ActionForward alterar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		MercadoriaForm meuForm = (MercadoriaForm) form;

		try {
			MercadoriaFACADE facade = new MercadoriaFACADE();

			facade.alterar( montarPO( meuForm ) );

			meuForm.limparCampos();

			this.addMessages( request, Messages.createMessages( "sucesso" ) );
		} catch ( ApplicationException e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", e.getMessage() ) );
		}

		/** O Mapping vai até o struts-config.xml procurar um forward com o nome passado como parametro */
		return filtrar( mapping, meuForm, request, response );
	}

	private MercadoriaPO montarPO( MercadoriaForm meuForm ) throws ParseException {
		MercadoriaPO po = new MercadoriaPO();

		if ( meuForm.getId() != null && !meuForm.getId().isEmpty() ) {
			po.setId( Long.valueOf( meuForm.getId() ) );
		} else {
			po.setId( null );
		}

		if ( meuForm.getPreco() != null && !meuForm.getPreco().isEmpty() ) {
			po.setPreco( Utilidades.parseBigDecimal( meuForm.getPreco() ) );
		} else {
			po.setPreco( null );
		}

		if ( meuForm.getQuantidade() != null && !meuForm.getQuantidade().isEmpty() ) {
			po.setQuantidade( Long.valueOf( meuForm.getQuantidade() ) );
		} else {
			po.setQuantidade( null );
		}

		if ( meuForm.getTipo() != null && !meuForm.getTipo().isEmpty() ) {
			po.setTipo( meuForm.getTipo() );
		} else {
			po.setTipo( null );
		}

		if ( meuForm.getTipoNegocio() != null && !meuForm.getTipoNegocio().isEmpty() ) {
			po.setTipoNegocio( meuForm.getTipoNegocio() );
		} else {
			po.setTipoNegocio( null );
		}

		if ( meuForm.getNome() != null && !meuForm.getNome().isEmpty() ) {
			po.setNome( meuForm.getNome() );
		} else {
			po.setNome( null );
		}

		return po;
	}

}

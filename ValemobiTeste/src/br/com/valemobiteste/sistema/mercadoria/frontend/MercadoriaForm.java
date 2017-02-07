package br.com.valemobiteste.sistema.mercadoria.frontend;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import br.com.valemobiteste.sistema.mercadoria.backend.model.MercadoriaPO;

public final class MercadoriaForm extends ActionForm{

	private static final long serialVersionUID = -3397097279076167105L;

	private String id;
	private String tipo;
	private String nome;
	private String quantidade;
	private String preco;
	private String tipoNegocio;

	private ArrayList< MercadoriaPO > mercadorias = new ArrayList< MercadoriaPO >();

	public void limparCampos() {
		setId( null );
		setNome( null );
		setPreco( null );
		setQuantidade( null );
		setTipo( null );
		setTipoNegocio( null );
	}

	public String getId() {
		return id;
	}

	public void setId( String id ) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo( String tipo ) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome( String nome ) {
		this.nome = nome;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade( String quantidade ) {
		this.quantidade = quantidade;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco( String preco ) {
		this.preco = preco;
	}

	public String getTipoNegocio() {
		return tipoNegocio;
	}

	public void setTipoNegocio( String tipoNegocio ) {
		this.tipoNegocio = tipoNegocio;
	}

	public ArrayList< MercadoriaPO > getMercadorias() {
		return mercadorias;
	}

	public void setMercadorias( ArrayList< MercadoriaPO > mercadorias ) {
		this.mercadorias = mercadorias;
	}

}

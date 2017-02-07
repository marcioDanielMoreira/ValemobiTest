package br.com.valemobiteste.sistema.mercadoria.backend.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.valemobiteste.abstracts.AbstractPO;
import br.com.valemobiteste.util.Utilidades;

@Entity
@Table( name = "mercadorias", schema = Utilidades.SCHEMA )
public class MercadoriaPO extends AbstractPO< MercadoriaPO >{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id" )
	private Long id;

	@Column( name = "tipo", nullable = false, length = 50 )
	private String tipo;

	@Column( name = "nome", nullable = false, length = 80 )
	private String nome;

	@Column( name = "quantidade", nullable = false )
	private Long quantidade;

	@Column( name = "preco", nullable = false, precision = 5, scale = 2 )
	private BigDecimal preco;

	@Column( name = "tipoNegocio", nullable = false )
	private String tipoNegocio;

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
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

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade( Long quantidade ) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco( BigDecimal preco ) {
		this.preco = preco;
	}

	public String getTipoNegocio() {
		return tipoNegocio;
	}

	public void setTipoNegocio( String tipoNegocio ) {
		this.tipoNegocio = tipoNegocio;
	}

	@Override
	public int compareTo( MercadoriaPO o ) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "MercadoriaPO [id=" + id + ", tipo=" + tipo + ", nome=" + nome + ", quantidade=" + quantidade + ", preco=" + preco + ", tipoNegocio=" + tipoNegocio + "]";
	}

}

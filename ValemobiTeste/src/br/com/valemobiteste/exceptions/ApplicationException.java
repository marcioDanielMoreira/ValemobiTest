package br.com.valemobiteste.exceptions;

public final class ApplicationException extends Exception{

	private static final long serialVersionUID = 3477076025026964587L;

	public ApplicationException( String message, Throwable cause ){
		super( message, cause );
	}

	public ApplicationException( String message ){
		super( message );
	}

}

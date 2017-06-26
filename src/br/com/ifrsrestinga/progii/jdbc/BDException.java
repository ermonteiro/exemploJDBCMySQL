package br.com.ifrsrestinga.progii.jdbc;

public class BDException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BDException(String s) {
        super(s);
    }

    public BDException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BDException(Throwable throwable) {
        super(throwable);
    }
}

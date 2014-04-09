package pl.lodz.p.pk;

import java.math.BigInteger;

public class BigIntegerLengthException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BigIntegerLengthException(BigInteger bi) {
		super("BigIntegerLengthException: Nie można spotęgować tak dużej liczby: "+bi.bitLength()+" bitów.\n");
	}
}

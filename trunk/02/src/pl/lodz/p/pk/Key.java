package pl.lodz.p.pk;

import java.math.BigInteger;

public class Key {
	
	public static final String SEPARATOR = "\n";
	private BigInteger a;
	private BigInteger n;
	
	public Key(BigInteger a, BigInteger n) {
		this.a = a;
		this.n = n;
	}
	
	public Key(String a, String b) {
		this.a = new BigInteger(a);
		this.n = new BigInteger(b);
	}
	
	public String toString () {
		return (a.toString()+SEPARATOR+n.toString());
	}

	public BigInteger getA() {
		return a;
	}

	public BigInteger getN() {
		return n;
	}
	
	public int getLiczbaZnakow() {
		return (n.bitLength()-1)/8;
	}
}

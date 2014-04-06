package pl.lodz.p.pk;

import java.math.BigInteger;

public class Key {
	
	private BigInteger a;
	private BigInteger n;
	
	public Key(BigInteger a, BigInteger n) {
		this.a = a;
		this.n = n;
	}
	
	public String toString () {
		return ("("+a.toString()+", "+n.toString()+")");
		
	}
}

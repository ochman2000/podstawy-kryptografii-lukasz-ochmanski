package pl.lodz.p.pk;

import java.math.BigInteger;
import java.util.Random;

public class RSAKey {
	
	private int keyLen=256;
	private Key publiczny;
	private Key prywatny;
	
	public RSAKey() {
		
		//	1.	SELECT TWO PRIME NUMBERS, p=17 AND q=11
		BigInteger p = BigInteger.probablePrime(keyLen,new Random());
	    BigInteger q = BigInteger.probablePrime(keyLen,new Random());
		
		//	2.	CALCULATE n = pq = 17 x 11 = 187
		BigInteger n = p.multiply(q);
		
		//	3.	CALCULATE PHI(n) = (p-1)(q-1) = 16 x 10 = 160
		BigInteger euler = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		
		//	4.	SELECT e SUCH THAT e IS RELATIVELY PRIME TO PHI(n)=160 AND LESS
		//		THAN PHI(n); WE CHOOSE e=7
		BigInteger e = BigInteger.probablePrime(keyLen, new Random());
		while(!(e.gcd(euler).equals(BigInteger.ONE))) {
			e=e.nextProbablePrime();
		}
		
		//	5.	DETERMINE d SUCH THAT de(mod 160) = 1(mod 160) AND d<160.
		//		THE CORRECT VALUE IS d=23, because 23x7=161=(1x160)+1;
		//		d CAN BE CALCULATED USING THE EXTENDED EUCLID'S ALGORITHM.
		BigInteger d = e.modInverse(euler);
		
		//	THE RESULTING KEYS ARE PUBLIC KEY PU={7,187}, AND PRIVATE KEY PR={23,187}.
		
		Key pu = new Key(e, n);
		this.setPubliczny(pu);
		Key pr = new Key(d, n);
		this.setPrywatny(pr);
	}
	
	public Key getPubliczny() {
		return publiczny;
	}
	public void setPubliczny(Key publiczny) {
		this.publiczny = publiczny;
	}

	public Key getPrywatny() {
		return prywatny;
	}

	public void setPrywatny(Key prywatny) {
		this.prywatny = prywatny;
	}
}

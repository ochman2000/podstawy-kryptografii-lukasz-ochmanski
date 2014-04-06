package pl.lodz.p.tewi;
import java.lang.*;
import java.util.*;
import java.math.BigInteger;
public class Rabin 
{    
    class RabinKeyException extends Exception
    {public RabinKeyException(String msg){super(msg);};
    }
    
    
    BigInteger p,q,N,a,b,dwa,trzy,cztery;
    int keyLen=2048; //ta wartość daje długość p||q=keyLen*2  
    int ilZnHex=keyLen/4;//ilość znaków hex wyświetlanych w polu klucza
    Random random=new Random();

    public Rabin()
    { 
        generateKey();
    } 
    
    
    public void generateKey()
    {      
       dwa=new BigInteger("2"); 
       trzy=new BigInteger("3");
       cztery=new BigInteger("4");
       p = BigInteger.probablePrime(keyLen,new Random());
       while(true)
       if (p.mod(cztery).equals(trzy))break;
       else p=p.nextProbablePrime();   
       q = BigInteger.probablePrime(keyLen,new Random());
       while(true)
       if (q.mod(cztery).equals(trzy))break;
       else q=q.nextProbablePrime(); 
       N = p.multiply(q);
       generateFactors();
     }      
    
    
    public void generateFactors() 
    {
        BigInteger x = BigInteger.ZERO;
        BigInteger y = BigInteger.ONE;
        a = BigInteger.ONE;
        b = BigInteger.ZERO;
        BigInteger a = p;
        BigInteger b = q;
        while (!b.equals(BigInteger.ZERO)) 
        {
            BigInteger tmp, quotient = a.divide(b);
            tmp = a;
            a = b;
            b = tmp.mod(b);
            tmp = x;
            x = this.a.subtract(quotient.multiply(x));
            this.a = tmp;
            tmp = y;
            y = this.b.subtract(quotient.multiply(y));
            this.b = tmp;
        }
    }
    
    
    public BigInteger[] encrypt(byte[] message) 
    {
	   int ileZnakow = (N.bitLength()-10)/8;
           while (message.length % ileZnakow != 0)
           {
               message = Arrays.copyOf(message, message.length+1); // powiększa o 1 i uzupełnia zerem
               message[message.length-1] = '\000';
           }
           int chunks = message.length/ ileZnakow;
           BigInteger[] cipher = new BigInteger[chunks];
           for (int i = 0; i < chunks; i++) 
           {
               byte[] pom = Auxx.podtablica(message, ileZnakow*i, ileZnakow*(i+1));
               cipher[i] = new BigInteger(1, pom);
               cipher[i]=cipher[i].modPow(dwa, N);
           }
       return cipher;
   }
    
   public BigInteger[] encrypt(String message) 
   {
       int ileZnakow = (N.bitLength()-10)/8;
       while (message.length() % ileZnakow != 0)
           message += ' ';
       int chunks = message.length()/ ileZnakow;
       BigInteger[] cipher = new BigInteger[chunks];
       for (int i = 0; i < chunks; i++) 
       {
          String s = message.substring(ileZnakow*i,ileZnakow*(i+1));
          cipher[i] = Auxx.stringToBigInt(s);
          cipher[i]=cipher[i].modPow(dwa, N);
       }
          return cipher;
   }
    
   
    public String encryptFromStringToString(String message)
   {
	   String str = new String();
	   BigInteger[] bi_table = encrypt(message);
	   for(int i = 0; i < bi_table.length; i++)
               str += bi_table[i] + "\n";
	   return str;
   }
    
    
    
    public String decrypt(BigInteger[] cipher) 
    { 
      String s1 ="",s2="",s3="",s4="";
      for (int i = 0; i < cipher.length; i++) 
      {    BigInteger M1,M2,M3,M4,m1,m3,pom1,pom2;
           m1=cipher[i].modPow(p.add(BigInteger.ONE).divide(cztery), p);
           m3=cipher[i].modPow(q.add(BigInteger.ONE).divide(cztery), q);
           pom1=a.multiply(m3).multiply(p);
           pom2=b.multiply(m1).multiply(q);
           M1=pom1.add(pom2).mod(N);
           M2=N.subtract(M1);
           M3=pom1.subtract(pom2).mod(N);
           M4=N.subtract(M3);
           s1 += Auxx.bigIntToString(M1);
           s2 += Auxx.bigIntToString(M2);
           s3 += Auxx.bigIntToString(M3);
           s4 += Auxx.bigIntToString(M4);
      }
       return s1+"\n========================================\n"+s2+"\n========================================\n"+s3+"\n========================================\n"+s4;
    }
    
    
    public BigInteger[] decryptToBigInt(BigInteger[] cipher) 
    {
      BigInteger[] wynik = new BigInteger[cipher.length*4];
      for (int i = 0,j=0; i < cipher.length; i++,j+=4) 
      {    BigInteger M1,M2,M3,M4,m1,m3;
           m1=cipher[i].modPow(p.add(BigInteger.ONE).divide(cztery), p);
           m3=cipher[i].modPow(q.add(BigInteger.ONE).divide(cztery), q);
           M1=a.multiply(m3).multiply(p).add((b.multiply(m1).multiply(q))).mod(N); 
           M2=N.subtract(M1);
           M3=a.multiply(m3).multiply(p).subtract((b.multiply(m1).multiply(q))).mod(N);
           M4=N.subtract(M3);
           wynik[j] = M1;
           wynik[j+1] = M2;
           wynik[j+2] = M3;
           wynik[j+3] = M4;
      }
      return wynik;
    }
    
    public String decryptFromStringToString(String cipher) 
    {
	   String[] wiersze = cipher.split("\n");
	   BigInteger[] bi_table = new BigInteger[wiersze.length];
	   for(int i = 0; i < wiersze.length; i++) 
		   bi_table[i] = new BigInteger(wiersze[i]);
	   return decrypt(bi_table);
   }
 
      
}//klasa Rabin

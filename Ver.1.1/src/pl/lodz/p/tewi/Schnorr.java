package pl.lodz.p.tewi;
import java.lang.*;
import java.util.*;
import java.math.BigInteger;
import java.security.*;
public class Schnorr 
{    
    class SchnorrKeyException extends Exception
    {public SchnorrKeyException(String msg){super(msg);};
    }
    
    
    BigInteger p,q,h,x,y,r,S1,S2,a,v,Z,qp1;
    MessageDigest digest;
    int keyLen=512; //ta wartość daje długość p=512
    int ilZnHex=keyLen/4;//ilość znaków hex wyświetlanych w polu klucza
    int qBits=140;//według Schnorra ilość bitów q ma wynosić 140
    Random random=new Random();

    public Schnorr()
    { 
        generateKey();
        try{
            digest=MessageDigest.getInstance("SHA-256");
           } catch (NoSuchAlgorithmException ex) {ex.printStackTrace();}
    } 
    
    
    public void generateKey()
    {
        q=BigInteger.probablePrime(qBits,new Random());
        BigInteger pom1, pom2;
        do {
                pom1 = BigInteger.probablePrime(keyLen,new Random());//new BigInteger(keyLen, 20, rand);
                pom2 = pom1.subtract(BigInteger.ONE);
                pom1 = pom1.subtract(pom2.remainder(q));
           } while (!pom1.isProbablePrime(2));
        p=pom1;    
        h=new BigInteger(keyLen-2,random);
        h=h.modPow(p.subtract(BigInteger.ONE).divide(q), p);
        do
        a=new BigInteger(qBits-2,random);
        while (a.compareTo(BigInteger.ONE) != 1);
        
        BigInteger pom=h.modPow(a, p);
        v=pom.modInverse(p);        
       
    }      
  
 
    public BigInteger[] podpisuj(byte[] tekst) 
    {     
            r=new BigInteger(160-2,random);
            x=h.modPow(r, p);
            //tworzymy konkatenację wiadomości z wartością x
            byte xBytes[]=x.toByteArray();
            byte pom[]=new byte[tekst.length+xBytes.length];
            for (int i=0;i<tekst.length;i++)
                pom[i]=tekst[i];
            for (int i=tekst.length,j=0;j<xBytes.length;i++,j++)
                pom[i]=xBytes[j];
            digest.update(pom);
            S1=new BigInteger(1, digest.digest());
            S2=r.add(a.multiply(S1)).mod(q);
            BigInteger podpis[]=new BigInteger[2];
            podpis[0]=S1;
            podpis[1]=S2;
        return podpis;
    }
    
    
    
    public BigInteger[] podpisuj(String tekst) 
    {      
            r=new BigInteger(160-2,random);
            x=h.modPow(r, p);
            //tworzymy konkatenację wiadomości z wartością x
            String xBytes=tekst;
            xBytes+=x.toString();
            digest.update(xBytes.getBytes());            
            S1=new BigInteger(1, digest.digest());
            S2=r.add(a.multiply(S1)).mod(q);
            BigInteger podpis[]=new BigInteger[2];
            podpis[0]=S1;
            podpis[1]=S2;
        return podpis;
    }
    
    
    public boolean weryfikujBigInt(byte[] tekstJawny, BigInteger[] podpis) 
    {     
        Z=h.modPow(podpis[1], p).multiply(v.modPow(podpis[0], p)).mod(p);
        //tworzymy konkatenację wiadomości z wartością x
            byte ZBytes[]=Z.toByteArray();
            byte pom[]=new byte[tekstJawny.length+ZBytes.length];
            for (int i=0;i<tekstJawny.length;i++)
                pom[i]=tekstJawny[i];
            for (int i=tekstJawny.length,j=0;j<ZBytes.length;i++,j++)
                pom[i]=ZBytes[j];
            digest.update(pom);
            BigInteger hash=new BigInteger(1, digest.digest());
           if(hash.compareTo(podpis[0])==0)return true; else return false;
    }
    
    
    
    //zakładamy, że podpis jest w postaci hexadecymalnych znaków
    public boolean weryfikujString(String tekstJawny, String podpis) 
    {     
         String tab[]=podpis.split("\n");
         BigInteger s1=new BigInteger(1,Auxx.hexToBytes(tab[0]));
         BigInteger s2=new BigInteger(1,Auxx.hexToBytes(tab[1]));
         Z=h.modPow(s2, p).multiply(v.modPow(s1, p)).mod(p);
         //tworzymy konkatenację wiadomości z wartością x
         String ZBytes=tekstJawny;
         ZBytes+=Z.toString();
         digest.update(ZBytes.getBytes());    
         BigInteger hash=new BigInteger(1, digest.digest());
         if(hash.compareTo(s1)==0)return true; else return false;
    }
    
    
}//klasa RSA

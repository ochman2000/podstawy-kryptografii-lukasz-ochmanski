package pl.lodz.p.tewi;
import java.lang.*;
public class DESX extends DES 
{   String s_key1, s_key2, s_key3;
    byte[] b_key1, b_key3;
    
    public DESX()
    {
    } 
    
  
    public byte[] encodeDESX(byte[] message) throws DESKeyException
    {
        //sprawdzenie kluczy jeżeli złe to wyjątek i brak szyfrowania
        b_key1 = Auxx.hexToBytes(s_key1);
        testKey();
        b_key = Auxx.hexToBytes(s_key2);
        testKey();
        b_key3 = Auxx.hexToBytes(s_key3);
        testKey();
        subKeys = getSubkeys();
        //xorowanie z kluczem I 
        byte[] step1=xorEncode(message, b_key1);//jest 64*X i poxorowane z kluczem I
        //szyfrowanie z kluczem II
        byte[] step2=encode(step1);   
        //xorowanie z kluczem II
        byte[] result=xorEncode(step2, b_key3);
        return result;
    }
   
    
    public byte[] decodeDESX (byte[] cipher) throws DESKeyException
    {
        //sprawdzenie kluczy jeżeli złe to wyjątek i brak szyfrowania
        b_key1 = Auxx.hexToBytes(s_key1);
        testKey();
        b_key = Auxx.hexToBytes(s_key2);
        testKey();
        b_key3 = Auxx.hexToBytes(s_key3);
        testKey();
        subKeys = getSubkeys();
       //xorowanie z kluczem I 
        byte[] step1=xorEncode(cipher, b_key3);
        //szyfrowanie z kluczem II
        byte[] step2=decode(step1);   
        //xorowanie z kluczem II
        byte[] result=xorDecode(step2, b_key1); 
        return result;
    }

     
    public byte[] xorBlock(byte[] key, byte[] data, int beginIndex) throws Exception 
    {
        byte[] msg = new byte[8];
        System.arraycopy(data, beginIndex, msg, 0, 8);
        for (int i=0;i<8;i++)
            msg[i]^=key[i];
        return msg;
    }

    
    
    public byte[] xorEncode(byte[] message, byte[] key) 
    {
        //Obliczanie długości szyfrogramu
        int len;
        if ((message.length / 2 % 4) != 0) 
            len = (message.length / 8 + 1) * 8;
        else 
            len = message.length;

        byte[] result = new byte[len];
        byte[] tempBlock = new byte[8];
        byte[] rawData = null;
        try {
            rawData = message;
            // Pętla tnąca i kodowanie bloków
            for (int i = 0; i < (rawData.length / 8); i++)
            {
                tempBlock = xorBlock(key, rawData, i * 8);
                System.arraycopy(tempBlock, 0, result, i * 8, 8);
            }
            
            // Dopełnianie zerami i kodowanie ostatniego bloku
            if (message.length / 2 % 4 != 0) 
            {
                for (int i = 0; i < 8; i++) 
                {
                    if (i + (rawData.length / 8) * 8 < rawData.length) 
                       tempBlock[i] = rawData[i + (rawData.length / 8) * 8];
                    else 
                       tempBlock[i] = 0;
                }
                tempBlock = xorBlock(key, tempBlock, 0);
                System.arraycopy(tempBlock, 0, result, (rawData.length / 8) * 8, 8);
            }
            return result;
            } catch (Exception ex) {};
         return null;
    }

    public byte[] xorDecode(byte[] encrypted, byte[] key) 
    {
        byte[] tmpResult = new byte[encrypted.length];
        byte[] tempBlock = new byte[8];
        byte[] rawData = null;
        try {
            rawData = encrypted;
            //Pętla tnąca i kodowanie bloków
            for (int i = 0; i < (rawData.length / 8); i++) 
            {
                tempBlock = xorBlock(key, rawData, i * 8);
                System.arraycopy(tempBlock, 0, tmpResult, i * 8, tempBlock.length);
            }
            // Usuwanie dopełnionych zer
            int cnt = 0;
            for (int i = 1; i < 9; i += 2) 
            {
                if (tmpResult[tmpResult.length - i] == 0 && tmpResult[tmpResult.length - i - 1] == 0) 
                    cnt += 2;
                else 
                    break;
            }
            byte[] result = new byte[tmpResult.length - cnt];
            System.arraycopy(tmpResult, 0, result, 0, tmpResult.length - cnt);
            return result;
            } catch (Exception ex) { };
        return null;
    }

    
    
    
    
    
    
    
    
}//klasa DESX

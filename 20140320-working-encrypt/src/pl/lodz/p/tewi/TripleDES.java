package pl.lodz.p.tewi;
import java.lang.*;
public class TripleDES extends DES 
{   String s_key1, s_key2, s_key3;
    
    
    public byte[] encode3DES(byte[] message) throws DESKeyException
    {
        setKeyHex(s_key1);
        byte[] result = encode(message);
        setKeyHex(s_key2);
        result = decode(result);
        setKeyHex(s_key3);
        result = encode(result);
        return result;
    }

    
    public byte[] decode3DES (byte[] cipher)throws DESKeyException
    {
        setKeyHex(s_key3);
        byte[]result = decode(cipher);
        setKeyHex(s_key2);
        result = encode(result);
        setKeyHex(s_key1);
        result =decode(result);
        return result;
    }

    
}//klasa TripleDES

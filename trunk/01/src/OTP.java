
public class OTP {
    
class OTPKeyException extends Exception
    {public OTPKeyException(String msg){super(msg);};
    }


    public byte[] encode(byte[] message, byte[] key) throws OTPKeyException
    {
        if(message.length!=key.length) throw new OTPKeyException("Długośći klucza i tekstu jawnego muszą się zgadzać");
        byte[] result=message;
        for(int i=0;i<message.length;i++) result[i]^=key[i];
        return result;
    }

    public byte[] decode(byte[] message, byte[] key) throws OTPKeyException
    {
        if(message.length!=key.length) throw new OTPKeyException("Długośći klucza i szyfrogramu muszą się zgadzać");
        byte[] result=message;
        for(int i=0;i<message.length;i++) result[i]^=key[i];
        return result;
    }
 
}//OTP
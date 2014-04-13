//*************************************************************************

//

//                         Demo class Tools

//

//              methods:   static int    GetInt()

//                         static long   GetLong()

//                         static String GetString()

//                         static char   GetChar()

//                         static double GetReal()

//************************************************************************
import java.io.*;
import java.util.*;

class   Tools  {



     public static  String GetString() throws IOException {

      BufferedReader stringIn = new BufferedReader (new
InputStreamReader(System.in));

      return  stringIn.readLine();

     }// GetString



     public  static  int  GetInt( ) throws IOException {

       String aux = GetString();

       return Integer.parseInt(aux);

    }// GetInt



    public  static  long GetLong( ) throws IOException {

        String aux = GetString();

        return Long.parseLong(aux);

    }// GetInt



    public  static char  GetChar( ) throws IOException {

        String  aux = GetString();

        return aux.charAt(0);

    }// GetChar



    public static  double  GetReal( ) throws IOException {

       String  aux = GetString();

       Double d  = new Double(aux) ;

       return  d.doubleValue() ;

    }// GetReal

}//Tools
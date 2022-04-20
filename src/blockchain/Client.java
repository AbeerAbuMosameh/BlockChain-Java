package blockchain;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;



public class Client {

	public static void main(String[] args)
    {
        try
        {
        Socket sock = new Socket("127.0.0.1",8000);
        byte[] mybytearray = new byte[8089];
        InputStream is =sock.getInputStream();
        String filepath = "C:\\Users\\HP\\eclipse\\BlockChain\\Blockchain.txt";
        FileOutputStream fos = new FileOutputStream(filepath);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int byteRead = is.read(mybytearray , 0 , mybytearray.length);
        bos.write(mybytearray,0,byteRead);
        bos.close();
        sock.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
     }
}
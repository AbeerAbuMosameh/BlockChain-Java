package blockchain;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			try (ServerSocket s = new ServerSocket(8089)) {
				String filepath = "C:\\Users\\HP\\eclipse\\BlockChain\\Blockchain.txt";
				File myFile = new File(filepath);

				while (true) {
					Socket sock = s.accept();
					byte[] mybytearray = new byte[(int) myFile.length()];
					try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile))) {
						bis.read(mybytearray, 0, mybytearray.length);
					}
					OutputStream os = sock.getOutputStream();
					os.write(mybytearray, 0, mybytearray.length);
					os.flush();
					sock.close();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
package server;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

	public static void main(String[] args) {
		try {
			// �����׽���
			ServerSocket ss = new ServerSocket(8289);
			// �ȴ��ͻ��˵�����
			Socket in = ss.accept();
			InputStream inStream = in.getInputStream();
			OutputStream outputStream = in.getOutputStream();
			Scanner sc = new Scanner(inStream);
			PrintWriter out = new PrintWriter(outputStream, true);
			out.println("Hello Enter Q to exit!");
			boolean done = false;
			while (!done && sc.hasNextLine()) {
				String line = sc.nextLine();
				out.println("Echo Server: " + line);
				if (line.trim().equals("Q")) {
					done = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

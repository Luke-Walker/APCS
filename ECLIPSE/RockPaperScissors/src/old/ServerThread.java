package old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {

	protected Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	
	public ServerThread(Socket clientSocket) {
		this.socket = clientSocket;
		System.out.print("I AM A CLIENT");
	}
	
	@Override
	public void run() {
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	public void sendMessage(String msg) {
		System.out.println(msg);
		out.println(msg);
	}
}

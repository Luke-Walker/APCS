package old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	/*
	 * TODO
	 * - CLIENT COMMUNICATE WITH SERVER/HOST
	 */
	
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in, stdIn;
	
	public void connect(String ip, int port) {
		try {
			socket = new Socket(ip, port);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			stdIn = new BufferedReader(new InputStreamReader(System.in));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		try {
			if (stdIn.readLine().equalsIgnoreCase("test")) { Server.changeState(State.WAITING_FOR_CLIENT); System.out.println("my name jeff"); }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			readPacket(in.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readPacket(String msg) {
		String s = msg.replace("packet:", "").substring(0,1);
		System.out.println(s);
		Packet packet = Packet.valueOf(Integer.parseInt(s));
		
		System.out.println("TESTING 123:" + packet.getValue());
	}
	
	public static void main(String[] args) {
		if (args.length < 3) {
			System.out.println("Incorrect arguments.");
			return;
		}
		System.out.println(args[0]);
		
		if (args[0].equalsIgnoreCase("yes")) {
			new Thread() {
				public void run() {
					Server server = new Server();
					server.launch(Integer.parseInt(args[2]));
				}
			}.start();
		}
		System.out.println("LMAO");
		Client client = new Client();
		client.connect(args[1], Integer.parseInt(args[2]));
	}
}

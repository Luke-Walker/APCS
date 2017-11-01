package me.lukewalker.rps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

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
	}
	
	public void readPacket(String msg) {
		Packet packet = Packet.valueOf(Integer.parseInt(msg.replace("packet:", "").split("{")[0]));
		
		System.out.println(packet);
	}
	
	public static void main(String[] args) {
		if (args.length < 3) {
			System.out.println("Incorrect arguments.");
			return;
		}
		System.out.println(args[0]);
		
		if (args[0].equalsIgnoreCase("yes")) {
			Server server = new Server();
			server.launch(Integer.parseInt(args[2]));
		}
		
		Client client = new Client();
		client.connect(args[1], Integer.parseInt(args[2]));
		
	}
}

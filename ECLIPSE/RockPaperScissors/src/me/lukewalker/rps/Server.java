package me.lukewalker.rps;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static State state;
	public static ArrayList<ServerThread> clients = new ArrayList<ServerThread>();
	
	private ServerSocket serverSocket;
	private Socket clientSocket;
	
	public void launch(int port) {
		try {
			serverSocket = new ServerSocket(port);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		System.out.println("abc");
		state = State.STARTED;
		System.out.println(state.getValue());
		
		new Thread() {
			public void run() {
				
			}
		}.start();
		while (true) {
			try {
				clientSocket = serverSocket.accept();
				System.out.println("TEST");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			clients.add(new ServerThread(clientSocket));
			System.out.println(clients.size());
			clients.get(clients.size()-1).start();
		}
	}
	
	public static void changeState(State state) {
		Server.state = state;
		
		sendPacket(Packet.STATE_CHANGE, new String[] {state.getValue() + ""});
	}
	
	public static void sendPacket(Packet packet, String[] args) {
		String msg = "packet:" + packet.getValue() + "{";
		for (String s : args) {
			msg += s + " ";
		}
		int i = 0;
		for (ServerThread client : clients) { client.sendMessage("packet:" + packet.getValue() + "|" + args); System.out.println(i); i++;}
	}
}

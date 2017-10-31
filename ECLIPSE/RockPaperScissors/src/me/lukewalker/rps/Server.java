package me.lukewalker.rps;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static State state;
	
	private ArrayList<ServerThread> clients = new ArrayList<ServerThread>();
	private ServerSocket serverSocket;
	private Socket clientSocket;
	
	public void launch(int port) {
		try {
			serverSocket = new ServerSocket(port);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		state = State.STARTED;
		
		while (true) {
			try {
				clientSocket = serverSocket.accept();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			clients.add(new ServerThread(clientSocket));
			clients.get(clients.size()).start();
		}
	}
	
	public void changeState(State state) {
		this.state = state;
		
		sendPacket(Packet.STATE_CHANGE, new String[] {state.getValue() + ""});
	}
	
	public void sendPacket(Packet packet, String[] args) {
		String msg = "packet:" + packet.getValue() + "{";
		for (String s : args) {
			msg += s + " ";
		}
		
		for (ServerThread client : clients) client.sendMessage("packet:" + packet + "|" + args);
	}
}

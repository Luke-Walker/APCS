package me.lukewalker.tictactoe.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	private ArrayList<Socket> clients = new ArrayList<Socket>();
	
	private ServerSocket serverSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	public void launch(int port) {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		while (clients.size() < 2) {
			try {
				Socket clientSocket = serverSocket.accept();
				clients.add(clientSocket);
				System.out.println(clientSocket.toString());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.launch(Integer.parseInt(args[0]));
	}
}

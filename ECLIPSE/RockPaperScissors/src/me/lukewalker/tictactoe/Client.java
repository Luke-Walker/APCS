package me.lukewalker.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.Scanner;

public class Client {

	// https://stackoverflow.com/questions/22287439/java-server-with-multiclient-communication	
	
	public static Protocol state;
	
	private ServerSocket serverSocket;
	private Socket socket, clientSocket;
	private PrintWriter out;
	private BufferedReader in, stdIn;
	
	public void connect(String ip, int port) {
		try {
			socket = new Socket(ip, port);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			stdIn = new BufferedReader(new InputStreamReader(System.in));
		} catch (UnknownHostException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void host(int port) {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		state = Protocol.WAITING_FOR_CLIENT;
		
		while (clientSocket == null) {
			try {
				clientSocket = serverSocket.accept();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		state = Protocol.CLIENT_CONNECTED;
		
		
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		Scanner scan = new Scanner(System.in);
		System.out.println("Are you the host? yes/no");
		if (scan.nextLine().equalsIgnoreCase("yes")) {
			System.out.print("Port: ");
			client.host(Integer.parseInt(scan.nextLine()));
		} else {
			System.out.print("IP: ");
			String ip = scan.nextLine();
			System.out.print("Port");
			client.connect(ip, Integer.parseInt(scan.nextLine()));
		}
		scan.close();
	}
}

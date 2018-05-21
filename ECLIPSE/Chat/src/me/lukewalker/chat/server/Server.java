package me.lukewalker.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class Server {
	
	public static String name = "";
	public static int port = -1;
	
	public static ServerSocket serverSocket = null;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Name of Server: ");
		name = scan.nextLine();
		System.out.print("Port: ");
		try {
			port = Integer.parseInt(scan.nextLine());
		} catch (Exception ex) {
			ex.printStackTrace();
			return;
		}
		
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException ex) {
			System.err.println("Could not listen on port: " + port);
			ex.printStackTrace();
		}
	}
}

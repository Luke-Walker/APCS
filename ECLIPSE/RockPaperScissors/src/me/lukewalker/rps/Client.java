package me.lukewalker.rps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.UnknownHostException;

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
			
			new Thread() {
				@Override
				public void run() {
					String input;
					try {
						while ((input = stdIn.readLine()) != null) {
							out.println(input);
						}
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}.start();
		
			String input;
			while ((input = in.readLine()) != null) {
				
			}
		} catch (UnknownHostException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		if (args.length < 2) return;
		
		Client client = new Client();
		client.connect(args[0], Integer.parseInt(args[1]));
	}
}

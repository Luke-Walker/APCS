import java.io.*;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void connect(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Client connected on port " + port + ".");
            String input;
            while ((input = in.readLine()) != null) {
                System.out.println("Received message: " + input + " from " + clientSocket.toString());
                out.println(input);
            }
        } catch (IOException ex) {
            System.out.println("Exception caught when trying to listen on port " + port + " or listening for a connection.");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.connect(Integer.parseInt(args[0]));
    }
}

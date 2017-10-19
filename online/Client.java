import java.io.*;
import java.net.*;

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

            String input;
            while ((input = stdIn.readLine()) != null) {
                out.println(input);
                System.out.println("Echo: " + in.readLine());
            }
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.connect(args[0], Integer.parseInt(args[1]));
    }
}

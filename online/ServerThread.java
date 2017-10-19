import java.io.*;
import java.net.*;
import java.lang.*;

public class ServerThread extends Thread {

    protected Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ServerThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        String line;
        while (true) {
            try {
                line = in.readLine();
                if ((line == null)) {
                    socket.close();
                    return;
                } else {
                    out.println(line);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                return;
            }
        }
    }
}

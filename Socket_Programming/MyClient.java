import java.io.*;
import java.net.*;

public class MyClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 1234;

        try (Socket socket = new Socket(serverAddress, serverPort)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message = "Hello My name is Alice";

            out.println(message);
            System.out.println("Client sends: " + message);

            String serverResponse = in.readLine();
            System.out.println("Server says: " + serverResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






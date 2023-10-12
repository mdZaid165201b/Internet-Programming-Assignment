import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args) {
        int port = 1234;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage = in.readLine();

                if (clientMessage != null) {
                    System.out.println("Client says: " + clientMessage);

                    String response = "Walikum Salam " + clientMessage.substring(clientMessage.lastIndexOf("_") + 1);
                    out.println(response);
                    System.out.println("Server responds: " + response);
                }

                clientSocket.close();
                System.out.println("Client disconnected.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.io.*;
import java.net.*;

class MaxCharacterCount implements Serializable {
    private static final long serialVersionUID = 1L;
    private String input;

    public MaxCharacterCount(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}

public class MyClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 1234;

        try (Socket socket = new Socket(serverAddress, serverPort);
             ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream())) {

            // Message to send to the server
            String message = "Hello , Ali! How are you ?";

            // Create and send a MaxCharacterCount object to the server
            MaxCharacterCount maxCharacterCount = new MaxCharacterCount(message);
            objectOutput.writeObject(maxCharacterCount);
            System.out.println("Client sends: " + message);

            // Receive the response from the server
            String serverResponse = (String) objectInput.readObject();
            System.out.println("Server responds: " + serverResponse);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
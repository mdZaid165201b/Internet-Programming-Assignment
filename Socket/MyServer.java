import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

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

public class MyServer {
    public static void main(String[] args) {
        int port = 1234;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                try (
                    ObjectInputStream objectInput = new ObjectInputStream(clientSocket.getInputStream());
                    ObjectOutputStream objectOutput = new ObjectOutputStream(clientSocket.getOutputStream())
                ) {
                    // Read the MaxCharacterCount object from the client
                    MaxCharacterCount maxCharacterCount = (MaxCharacterCount) objectInput.readObject();

                    String input = maxCharacterCount.getInput();
                    System.out.println("Client's input: " + input);

                    Map<Character, Integer> charCountMap = new HashMap<>();
                    int maxCount = 0;
                    for (char c : input.toCharArray()) {
                        if (Character.isLetter(c)) {
                            c = Character.toLowerCase(c);
                            int count = charCountMap.getOrDefault(c, 0) + 1;
                            charCountMap.put(c, count);
                            if (count > maxCount) {
                                maxCount = count;
                            }
                        }
                    }

                    // Prepare and send the response
                    StringBuilder response = new StringBuilder();
                    for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
                        if (entry.getValue() == maxCount) {
                            response.append(entry.getKey()).append(":").append(entry.getValue()).append(" , ");
                        }
                    }
                    if (response.length() > 2) {
                        response.setLength(response.length() - 2); // Remove the trailing " , "
                    }

                    objectOutput.writeObject(response.toString());
                    System.out.println("Server responds: " + response);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                
                // Close the connection
                clientSocket.close();
                System.out.println("Client disconnected.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
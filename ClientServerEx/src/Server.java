import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 5000; // Server listens on this port
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port);

            Socket clientSocket = serverSocket.accept(); //This Waits for client connection
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message = in.readLine();  // Read message from The Client
            System.out.println("Client says: " + message);

            out.println("Hello from Server!"); // Send response to The Client

            clientSocket.close(); // Close connection
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

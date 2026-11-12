package transport;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) {

        int port = 5000;

        System.out.println("======================================");
        System.out.println("           TCP SERVER");
        System.out.println("======================================");

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("TCP Server started.");
            System.out.println("Waiting for client...");
            System.out.println("Port: " + port);

            Socket socket = serverSocket.accept();

            System.out.println("Client connected!");

            BufferedReader input =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));

            PrintWriter output =
                    new PrintWriter(
                            socket.getOutputStream(), true);

            String message = input.readLine();

            System.out.println("Received patient data:");
            System.out.println(message);

            output.println(
                    "TCP: Patient data received successfully."
            );

            socket.close();

        } catch (Exception e) {

            System.out.println(
                    "TCP Server Error: " + e.getMessage()
            );
        }
    }
}
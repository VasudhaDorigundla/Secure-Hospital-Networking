package transport;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) {

        String serverAddress = "localhost";
        int port = 5000;

        System.out.println("======================================");
        System.out.println("           TCP CLIENT");
        System.out.println("======================================");

        try (Socket socket = new Socket(serverAddress, port)) {

            System.out.println("Connected to TCP Server.");

            BufferedReader input =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));

            PrintWriter output =
                    new PrintWriter(
                            socket.getOutputStream(), true);

            String patientData =
                    "Patient ID: P101, Department: ICU, Status: Stable";

            System.out.println("Sending patient data:");
            System.out.println(patientData);

            output.println(patientData);

            String response = input.readLine();

            System.out.println();
            System.out.println("Server Response:");
            System.out.println(response);

            System.out.println("--------------------------------------");
            System.out.println("TCP communication completed!");

        } catch (Exception e) {

            System.out.println(
                    "TCP Client Error: " + e.getMessage()
            );
        }
    }
}
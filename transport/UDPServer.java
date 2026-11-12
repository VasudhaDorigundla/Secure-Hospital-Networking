package transport;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

    public static void main(String[] args) {

        int port = 6000;

        System.out.println("======================================");
        System.out.println("           UDP SERVER");
        System.out.println("======================================");

        try (DatagramSocket socket = new DatagramSocket(port)) {

            System.out.println("UDP Server started.");
            System.out.println("Waiting for patient data...");
            System.out.println("Port: " + port);

            byte[] buffer = new byte[1024];

            DatagramPacket packet =
                    new DatagramPacket(
                            buffer,
                            buffer.length);

            socket.receive(packet);

            String message =
                    new String(
                            packet.getData(),
                            0,
                            packet.getLength());

            System.out.println();
            System.out.println("Received patient data:");
            System.out.println(message);

            String response =
                    "UDP: Patient data received.";

            byte[] responseData =
                    response.getBytes();

            DatagramPacket responsePacket =
                    new DatagramPacket(
                            responseData,
                            responseData.length,
                            packet.getAddress(),
                            packet.getPort());

            socket.send(responsePacket);

            System.out.println();
            System.out.println("Response sent to client.");

        } catch (Exception e) {

            System.out.println(
                    "UDP Server Error: " + e.getMessage());
        }
    }
}
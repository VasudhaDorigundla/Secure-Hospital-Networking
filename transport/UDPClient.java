package transport;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

    public static void main(String[] args) {

        String serverAddress = "localhost";
        int port = 6000;

        System.out.println("======================================");
        System.out.println("           UDP CLIENT");
        System.out.println("======================================");

        try (DatagramSocket socket = new DatagramSocket()) {

            InetAddress address =
                    InetAddress.getByName(serverAddress);

            String patientData =
                    "Patient ID: P202, Department: Emergency, Status: Critical";

            byte[] data = patientData.getBytes();

            DatagramPacket packet =
                    new DatagramPacket(
                            data,
                            data.length,
                            address,
                            port);

            System.out.println("Sending patient data:");
            System.out.println(patientData);

            socket.send(packet);

            byte[] buffer = new byte[1024];

            DatagramPacket responsePacket =
                    new DatagramPacket(
                            buffer,
                            buffer.length);

            socket.receive(responsePacket);

            String response =
                    new String(
                            responsePacket.getData(),
                            0,
                            responsePacket.getLength());

            System.out.println();
            System.out.println("Server Response:");
            System.out.println(response);

            System.out.println("--------------------------------------");
            System.out.println("UDP communication completed!");

        } catch (Exception e) {

            System.out.println(
                    "UDP Client Error: " + e.getMessage());
        }
    }
}
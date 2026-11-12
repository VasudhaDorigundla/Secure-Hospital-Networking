import java.util.Scanner;

import hospital.HospitalNetwork;
import security.Encryption;
import framing.CharacterStuffing;
import error.BitStuffingCRC;
import reliability.GoBackN;
import routing.Dijkstra;
import routing.DistanceVector;
import transport.TCPClient;
import transport.TCPServer;
import transport.UDPClient;
import transport.UDPServer;
import analysis.PerformanceAnalysis;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n======================================");
            System.out.println("     SECURE HOSPITAL NETWORK SYSTEM");
            System.out.println("======================================");

            System.out.println("1. Hospital Network & IP Configuration");
            System.out.println("2. AES Encryption & Decryption");
            System.out.println("3. Character Stuffing");
            System.out.println("4. Bit Stuffing & CRC");
            System.out.println("5. Sliding Window & Go-Back-N");
            System.out.println("6. Dijkstra Routing");
            System.out.println("7. Distance Vector Routing");
            System.out.println("8. TCP Communication");
            System.out.println("9. UDP Communication");
            System.out.println("10. Network Performance Analysis");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
                choice = -1;
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    HospitalNetwork.main(new String[0]);
                    break;

                case 2:
                    Encryption.main(new String[0]);
                    break;

                case 3:
                    CharacterStuffing.main(new String[0]);
                    break;

                case 4:
                    BitStuffingCRC.main(new String[0]);
                    break;

                case 5:
                    GoBackN.main(new String[0]);
                    break;

                case 6:
                    Dijkstra.main(new String[0]);
                    break;

                case 7:
                    DistanceVector.main(new String[0]);
                    break;

                case 8:
                    System.out.println("Start TCPServer first in a separate terminal.");
                    TCPClient.main(new String[0]);
                    break;

                case 9:
                    System.out.println("Start UDPServer first in a separate terminal.");
                    UDPClient.main(new String[0]);
                    break;

                case 10:
                    PerformanceAnalysis.main(new String[0]);
                    break;

                case 0:
                    System.out.println("Exiting Secure Hospital Network System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (choice != 0) {
                System.out.println("\nPress Enter to return to the menu...");
                scanner.nextLine();
                scanner.nextLine();
            }

        } while (choice != 0);

        scanner.close();
    }
}

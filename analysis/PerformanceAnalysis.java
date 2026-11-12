package analysis;

public class PerformanceAnalysis {

    public static void main(String[] args) {

        // Network simulation values
        int totalPackets = 100;
        int sentPackets = 100;
        int receivedPackets = 95;
        int lostPackets = sentPackets - receivedPackets;

        double totalDataKB = 500.0;
        double transmissionTimeSeconds = 2.5;

        // Calculate packet loss percentage
        double packetLoss =
                ((double) lostPackets / sentPackets) * 100;

        // Calculate packet delivery ratio
        double packetDeliveryRatio =
                ((double) receivedPackets / sentPackets) * 100;

        // Calculate average delay
        double averageDelay =
                (transmissionTimeSeconds / receivedPackets) * 1000;

        // Calculate throughput
        double throughput =
                totalDataKB / transmissionTimeSeconds;

        System.out.println("======================================");
        System.out.println("       NETWORK PERFORMANCE ANALYSIS");
        System.out.println("======================================");

        System.out.println("Total Packets       : " + totalPackets);
        System.out.println("Packets Sent        : " + sentPackets);
        System.out.println("Packets Received    : " + receivedPackets);
        System.out.println("Packets Lost        : " + lostPackets);

        System.out.printf(
                "Packet Loss         : %.2f%%%n",
                packetLoss
        );

        System.out.printf(
                "Packet Delivery     : %.2f%%%n",
                packetDeliveryRatio
        );

        System.out.printf(
                "Average Delay       : %.2f ms%n",
                averageDelay
        );

        System.out.printf(
                "Throughput          : %.2f KB/s%n",
                throughput
        );

        System.out.println("--------------------------------------");
        System.out.println("Network performance analysis completed!");
    }
}
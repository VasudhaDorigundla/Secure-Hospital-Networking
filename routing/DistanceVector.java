package routing;

public class DistanceVector {

    static final int INF = 9999;

    public static void main(String[] args) {

        // Hospital network routers
        // 0 = Reception
        // 1 = Emergency
        // 2 = ICU
        // 3 = Medical Server

        int[][] graph = {
            {0, 4, 8, 0},
            {4, 0, 3, 7},
            {8, 3, 0, 2},
            {0, 7, 2, 0}
        };

        int n = graph.length;

        int[][] distance = new int[n][n];

        // Initialize routing table
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (i == j) {
                    distance[i][j] = 0;
                }
                else if (graph[i][j] != 0) {
                    distance[i][j] = graph[i][j];
                }
                else {
                    distance[i][j] = INF;
                }
            }
        }

        // Distance Vector calculation
        boolean updated;

        do {

            updated = false;

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    for (int k = 0; k < n; k++) {

                        if (distance[i][k] != INF
                                && distance[k][j] != INF
                                && distance[i][k] + distance[k][j]
                                < distance[i][j]) {

                            distance[i][j] =
                                    distance[i][k] + distance[k][j];

                            updated = true;
                        }
                    }
                }
            }

        } while (updated);

        System.out.println("======================================");
        System.out.println("       DISTANCE VECTOR ROUTING");
        System.out.println("======================================");

        System.out.println("Final Routing Table");
        System.out.println();

        System.out.println("             Reception  Emergency  ICU  Server");

        for (int i = 0; i < n; i++) {

            System.out.print(getRouterName(i) + "       ");

            for (int j = 0; j < n; j++) {

                if (distance[i][j] == INF) {
                    System.out.print("INF        ");
                }
                else {
                    System.out.print(
                            distance[i][j] + "          "
                    );
                }
            }

            System.out.println();
        }

        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("Distance Vector routing completed!");
    }

    static String getRouterName(int router) {

        switch (router) {

            case 0:
                return "Reception";

            case 1:
                return "Emergency";

            case 2:
                return "ICU";

            case 3:
                return "Server";

            default:
                return "Unknown";
        }
    }
}
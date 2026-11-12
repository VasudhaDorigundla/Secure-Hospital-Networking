package routing;

import java.util.Arrays;

public class Dijkstra {

    static final int INF = 9999;

    public static void dijkstra(int[][] graph, int source) {

        int vertices = graph.length;

        int[] distance = new int[vertices];
        boolean[] visited = new boolean[vertices];

        Arrays.fill(distance, INF);

        distance[source] = 0;

        for (int count = 0; count < vertices - 1; count++) {

            int minDistance = INF;
            int currentVertex = -1;

            // Find the nearest unvisited vertex
            for (int i = 0; i < vertices; i++) {

                if (!visited[i] && distance[i] < minDistance) {
                    minDistance = distance[i];
                    currentVertex = i;
                }
            }

            if (currentVertex == -1) {
                break;
            }

            visited[currentVertex] = true;

            // Update distances
            for (int i = 0; i < vertices; i++) {

                if (!visited[i]
                        && graph[currentVertex][i] != 0
                        && distance[currentVertex] != INF
                        && distance[currentVertex]
                        + graph[currentVertex][i] < distance[i]) {

                    distance[i] =
                            distance[currentVertex]
                            + graph[currentVertex][i];
                }
            }
        }

        System.out.println("Shortest paths from "
                + getDepartmentName(source) + ":");

        for (int i = 0; i < vertices; i++) {

            System.out.println(
                    getDepartmentName(source)
                    + " -> "
                    + getDepartmentName(i)
                    + " = "
                    + distance[i]
            );
        }
    }

    public static String getDepartmentName(int number) {

        switch (number) {
            case 0:
                return "Reception";
            case 1:
                return "Emergency";
            case 2:
                return "ICU";
            case 3:
                return "Pharmacy";
            case 4:
                return "Laboratory";
            case 5:
                return "Doctors";
            case 6:
                return "Administration";
            case 7:
                return "Medical Server";
            default:
                return "Unknown";
        }
    }

    public static void main(String[] args) {

        /*
         * Hospital network:
         *
         * 0 = Reception
         * 1 = Emergency
         * 2 = ICU
         * 3 = Pharmacy
         * 4 = Laboratory
         * 5 = Doctors
         * 6 = Administration
         * 7 = Medical Server
         */

        int[][] graph = {

            {0, 4, 0, 0, 0, 0, 0, 8},
            {4, 0, 3, 0, 0, 0, 0, 0},
            {0, 3, 0, 2, 0, 0, 0, 0},
            {0, 0, 2, 0, 3, 0, 0, 0},
            {0, 0, 0, 3, 0, 4, 0, 0},
            {0, 0, 0, 0, 4, 0, 2, 0},
            {0, 0, 0, 0, 0, 2, 0, 3},
            {8, 0, 0, 0, 0, 0, 3, 0}
        };

        System.out.println("======================================");
        System.out.println("       DIJKSTRA ROUTING ALGORITHM");
        System.out.println("======================================");

        dijkstra(graph, 0);

        System.out.println("--------------------------------------");
        System.out.println("Dijkstra routing completed!");
    }
}
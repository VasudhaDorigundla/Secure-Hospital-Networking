package reliability;

public class GoBackN {

    public static void main(String[] args) {

        int totalFrames = 8;
        int windowSize = 4;

        // Simulate frame 3 being lost only once
        int lostFrame = 3;
        boolean frameLost = false;

        System.out.println("======================================");
        System.out.println("       SLIDING WINDOW - GO-BACK-N");
        System.out.println("======================================");

        System.out.println("Total Frames : " + totalFrames);
        System.out.println("Window Size  : " + windowSize);
        System.out.println();

        int frame = 1;

        while (frame <= totalFrames) {

            int end = Math.min(
                    frame + windowSize - 1,
                    totalFrames
            );

            System.out.println(
                    "Sending window: " + frame + " to " + end
            );

            boolean error = false;

            for (int i = frame; i <= end; i++) {

                // Frame 3 is lost only the first time
                if (i == lostFrame && !frameLost) {

                    System.out.println(
                           "Frame " + i + " lost!"
                    );

                    frameLost = true;
                    error = true;

                    break;
                }

                System.out.println(
                        "Frame " + i +
                        " received successfully. ✓"
                );
            }

            if (error) {

                System.out.println(
                        "Go-Back-N: Retransmitting from frame "
                        + lostFrame
                );

                System.out.println();

                // Go back to the lost frame
                frame = lostFrame;

            } else {

                // Move to the next window
                frame = end + 1;
            }
        }

        System.out.println("--------------------------------------");
        System.out.println("All frames transmitted successfully!");
        System.out.println("Go-Back-N simulation completed!");
    }
}
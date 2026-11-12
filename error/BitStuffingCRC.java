package error;

public class BitStuffingCRC {

    // Bit stuffing
    public static String bitStuff(String data) {

        StringBuilder result = new StringBuilder();
        int consecutiveOnes = 0;

        for (char bit : data.toCharArray()) {

            result.append(bit);

            if (bit == '1') {
                consecutiveOnes++;

                // Insert 0 after five consecutive 1s
                if (consecutiveOnes == 5) {
                    result.append('0');
                    consecutiveOnes = 0;
                }

            } else {
                consecutiveOnes = 0;
            }
        }

        return result.toString();
    }

    // CRC calculation
    public static String calculateCRC(String data, String generator) {

        int generatorLength = generator.length();

        StringBuilder remainder = new StringBuilder(data);

        // Add zeros
        for (int i = 0; i < generatorLength - 1; i++) {
            remainder.append('0');
        }

        for (int i = 0; i <= remainder.length() - generatorLength; i++) {

            if (remainder.charAt(i) == '1') {

                for (int j = 0; j < generatorLength; j++) {

                    char bit = remainder.charAt(i + j);
                    char genBit = generator.charAt(j);

                    remainder.setCharAt(
                            i + j,
                            bit == genBit ? '0' : '1'
                    );
                }
            }
        }

        return remainder.substring(
                remainder.length() - generatorLength + 1
        );
    }

    public static void main(String[] args) {

        String data = "11111010111110";
        String generator = "1101";

        String stuffedData = bitStuff(data);
        String crc = calculateCRC(data, generator);

        System.out.println("======================================");
        System.out.println("       BIT STUFFING AND CRC");
        System.out.println("======================================");

        System.out.println("Original Data : " + data);
        System.out.println("Stuffed Data  : " + stuffedData);
        System.out.println("Generator     : " + generator);
        System.out.println("CRC           : " + crc);

        System.out.println("--------------------------------------");
        System.out.println("Bit stuffing and CRC completed!");
    }
}
package framing;

public class CharacterStuffing {

    public static String stuff(String data, char flag, char escape) {

        StringBuilder result = new StringBuilder();

        // Starting flag
        result.append(flag);

        for (char ch : data.toCharArray()) {

            // If data contains FLAG or ESCAPE,
            // add ESCAPE before it
            if (ch == flag || ch == escape) {
                result.append(escape);
            }

            result.append(ch);
        }

        // Ending flag
        result.append(flag);

        return result.toString();
    }

    public static void main(String[] args) {

        char FLAG = '$';
        char ESCAPE = '/';

        String data = "Patient$ICU/Stable";

        String stuffedData = stuff(data, FLAG, ESCAPE);

        System.out.println("======================================");
        System.out.println("       CHARACTER STUFFING");
        System.out.println("======================================");

        System.out.println("Original Data : " + data);
        System.out.println("Flag Character: " + FLAG);
        System.out.println("Escape Character: " + ESCAPE);
        System.out.println("Stuffed Data  : " + stuffedData);

        System.out.println("--------------------------------------");
        System.out.println("Character stuffing completed!");
    }
}
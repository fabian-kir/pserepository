import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> matrikelnummerZuNote = new HashMap<>();

        matrikelnummerZuNote.put(111111, 12);
        matrikelnummerZuNote.put(123456, 3);
        matrikelnummerZuNote.put(3787773, 2);

        for (Map.Entry<Integer, Integer> entry : matrikelnummerZuNote.entrySet()) {
            if (entry.getValue() < 12) {
                System.out.println(entry.getKey() + " hat nicht bestanden");
            }
        }
    }
}




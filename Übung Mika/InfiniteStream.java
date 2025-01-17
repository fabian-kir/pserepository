import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.Set;
import java.util.stream.Collectors;

public class InfintiteStream {
    public static void main(String[] args) {
        Supplier<Double> supplier = Math::random;
        Stream.generate(supplier).foreach(System.out::println); //Unendlicher Stream (möglichkeit anstatt while to schleife oder so)
        Stream.generate(supplier).toList(); //OutOfMemoryError
        Stream.generate(supplier).limit(maxSize:100).toList(); //limit 100
        double res = Stream.generate(supplier).limit(maxSize: 100).mapToDouble(Double x -> x).sum();
        System.out.println(res);
        Set<Double> mySet = Stream.generate(supplier).limit(maxSize: 100).collect(Collectors.toSet()); //anstatt toSet geht auch toUnmodifable....
        System.out.println(mySet);
        // Gut zu wissen:
        List<Double> myList = Stream.generate(supplier).limit(maxSize: 100)
            .reduce(new ArrayList<Double>(), (list, nextDouble) -> { //siehe Doku zu .reduce lol
                list.add(nextDouble);
            }, (ArrayList<Double> list, ArrayList<Double> list2) -> { //mit der 3 Liste kann man die beiden davor zu einer kombinieren
                list.addAll(list2);
                return list; // genau das gleiche wie .toList xD, nützlich wenn man eigene Datenstruktur hat, mit reduce kann man also einen Stream in diese neue Datenstruktur Umwandeln (z.B. SuchIndex)
            });
    }
}
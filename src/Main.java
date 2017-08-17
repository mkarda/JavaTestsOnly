import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();

        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(Main.class.getResourceAsStream("people.txt")));

                Stream<String> stream = reader.lines()



        ) {
            stream.map(line -> {
                String[] s = line.split(" ");
                Person p = new Person(s[0].trim(), Integer.parseInt(s[1].trim()) );
                list.add(p);
                return p;
            })
                    .forEach(System.out::println);

            System.out.println(list.size());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Stream<Person> stream = list.stream();
        Optional<Person> min = stream.filter(p -> p.getAge() >= 20).max(Comparator.comparing(Person::getAge));
        System.out.println(min.get().getName());


    }
}

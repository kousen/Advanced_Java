package lambdasstreams;

import database.jdbc.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UsePerson {
    private List<String> names =
            Arrays.asList("Joffrey Baratheon", "Daenerys Targaryen", "Jon Snow",
                    "Arya Stark", "Tyrion Lannister", "Margaery Tyrell");

    public List<Person> createPersonList() {
        return names.stream()
                .map(name -> new Person(name))
                .collect(Collectors.toList());
    }

    public Person[] createPersonArray() {
        return names.stream()
                .map(Person::new)
                .toArray(Person[]::new);
    }

    public List<Person> createPersonListUsingNew() {
        return names.stream()
                .map(Person::new)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static void main(String[] args) {
        UsePerson up = new UsePerson();
        System.out.println(up.createPersonList());
        System.out.println(up.createPersonListUsingNew());
        Arrays.stream(up.createPersonArray())
                .forEach(System.out::println);
    }
}

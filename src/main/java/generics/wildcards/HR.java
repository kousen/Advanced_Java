package generics.wildcards;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class HR {
    public static void printEmpNames(List<Employee> employees) {
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    public static void printEmpAndSubclassNames(List<? extends Employee> employees) {
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
        // employees.add(new Employee("Fred")); // does not compile
        // employees.add(new Salaried("Barney")); // does not compile
    }

    public static void printAllFiltered(
            List<? extends Employee> employees, Predicate<? super Employee> predicate) {
        for (Employee e : employees) {
            if (predicate.test(e)) {
                System.out.println(e.getName());
            }
        }
    }
}

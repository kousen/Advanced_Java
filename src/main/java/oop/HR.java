package oop;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class HR {
    private List<Employee> employees = new ArrayList<>();

    public void hire(Employee e) {
        employees.add(e);
    }

    public void layoff(Employee e) {
        employees.remove(e);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void printEverybody() {
        employees.forEach(System.out::println);
    }

    public void payEverybody() {
        for (Employee e : employees) {
            System.out.printf("Paying %s %s%n", e.getName(),
                    NumberFormat.getCurrencyInstance().format(e.getPay()));
        }
    }
}

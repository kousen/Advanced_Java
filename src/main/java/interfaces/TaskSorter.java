package interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskSorter {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, "Run away from killer rabbit", 4));
        tasks.add(new Task(2, "Answer the bridgekeeper", 2));
        tasks.add(new Task(3, "Defeat the Black Knight", 1));
        tasks.add(new Task(4, "Give a shrubbery to the Knights Who Say Ni!", 4));
        tasks.add(new Task(5, "Lobbeth thou thy Holy Hand Grenade", 3));

        tasks.forEach(System.out::println);

        Collections.sort(tasks);
        System.out.println("After natural sort:");
        tasks.forEach(System.out::println);
    }
}

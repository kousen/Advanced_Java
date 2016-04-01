package lambdasstreams;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FileFilterDemo {
    public static void main(String[] args) {
        File directory = new File("./src/main/java/lambdasstreams");
        System.out.println(directory.getAbsolutePath());

        // Anonymous inner class
        Arrays.stream(directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("java");
            }
        })).forEach(System.out::println);

        // Use lambda expression instead
        Arrays.stream(
                directory.list((dir, name) -> name.endsWith("java")))
                .forEach(System.out::println);

        // Assign lambda to variable
        FilenameFilter javaFiles = (dir, name) -> name.endsWith("java");
        Arrays.stream(
                directory.list(javaFiles))
                .forEach(System.out::println);
    }
}

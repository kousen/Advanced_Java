package interfaces.defaults;

public interface Employee {
    String getFirst();
    String getLast();
    void doWork();

    default String getName() {
        return String.format("%s %s", getFirst(), getLast());
    }
}

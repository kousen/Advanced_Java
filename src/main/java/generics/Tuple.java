package generics;

public class Tuple<T,U> {
    private T first;
    private U second;

    public Tuple(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return String.format("Tuple{first=%s, second=%s}", first, second);
    }
}

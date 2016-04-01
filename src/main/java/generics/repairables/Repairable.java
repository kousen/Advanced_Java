package generics.repairables;

public interface Repairable {
    default void fix() {
        System.out.println("fixing " + this.getClass().getName());
    }
}

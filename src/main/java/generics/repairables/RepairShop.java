package generics.repairables;

import java.util.List;

public class RepairShop {

    public static <T extends Repairable> void fixAll(List<T> items) {
        items.forEach(T::fix);
    }
}

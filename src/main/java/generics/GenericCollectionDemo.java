package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericCollectionDemo {

    public void noGenerics() {
        List nums = new ArrayList();
        nums.add(3);
        nums.add(1);
        nums.add(4);
        nums.add("oops");
        System.out.println(nums);

        for (Object n : nums) {
            // Integer val = (Integer) n;  // Ack! ClassCastException
            System.out.println(n);
        }
    }

    public void genericList() {
        List<Integer> nums = new ArrayList<>();
        nums.add(3); nums.add(1); nums.add(4);
        // nums.add("oops"); // Won't compile
        System.out.println(nums);

        nums.forEach(System.out::println);
    }

    public static void main(String[] args) {
        GenericCollectionDemo demo = new GenericCollectionDemo();
        demo.noGenerics();
        demo.genericList();

    }
}

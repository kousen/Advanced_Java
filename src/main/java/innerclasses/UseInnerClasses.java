package innerclasses;

public class UseInnerClasses {
    public static void main(String[] args) {
        new Outer().new Inner().myMethod(); // inner instance of outer
        new Outer.InnerStatic().myMethod(); // static inner class
    }
}

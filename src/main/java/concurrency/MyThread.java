package concurrency;

public class MyThread extends Thread {
    private int id;

    public MyThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Hello from " + this);
    }

    @Override
    public String toString() {
        return String.format("MyThread{id=%d} ", id);
    }
}

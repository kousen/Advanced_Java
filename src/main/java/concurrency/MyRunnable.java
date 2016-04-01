package concurrency;

public class MyRunnable implements Runnable {
    private int id;
    private Thread thread = new Thread(this);

    public MyRunnable(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Hello from " + this);
    }

    public void start() {
        thread.start();
    }

    @Override
    public String toString() {
        return String.format("MyRunnable{id=%d}", id);
    }
}

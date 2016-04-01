package concurrency.callables;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private int id;

    public MyCallable(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return String.format("%s using thread %s",
                this, Thread.currentThread().getName());
    }

    @Override
    public String toString() {
        return String.format("MyCallable{id=%d}", id);
    }
}

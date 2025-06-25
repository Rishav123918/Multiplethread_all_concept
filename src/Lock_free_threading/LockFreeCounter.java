package Lock_free_threading;

import java.util.concurrent.atomic.AtomicInteger;

public class LockFreeCounter {
    AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        while (true) {
            int oldValue = count.get();
            int newValue = oldValue + 1;
            if (count.compareAndSet(oldValue, newValue)) {
                break;
            }
        }
    }

    public int getCount() {
        return count.get();
    }
}

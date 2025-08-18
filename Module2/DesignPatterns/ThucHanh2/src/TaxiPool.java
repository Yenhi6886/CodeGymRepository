import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class TaxiPool {
    //là thời gian chờ tối đa để có taxi trước khi báo lỗi.
    private static final int NUMBER_OF_TAXI = 4;
    private static final long EXPIRED_TIME_IN_MILISECOND = 1200;
    private final List<Taxi> available = Collections.synchronizedList(new ArrayList<>());
    private final List<Taxi> inUse = Collections.synchronizedList(new ArrayList<>());
    private final AtomicInteger count = new AtomicInteger(0);
    private final AtomicBoolean waiting = new AtomicBoolean(false);

    public synchronized void release(Taxi taxi) {
        inUse.remove(taxi);
        available.add(taxi);
        System.out.println(taxi.getName() + " is free");
    }

    public synchronized Taxi getTaxi() {
        if (!available.isEmpty()) {
            Taxi taxi = available.get(0);
            inUse.add(taxi);
            return taxi;
        }
    }

    private Taxi createTaxi() {
        waiting(200);
        Taxi taxi = new Taxi("Taxi " + count.incrementAndGet());
        System.out.println(taxi.getName() + " iscreated");
        return taxi;
    }

    private  void waitingUntilTaxiAvailable() {
        if(waiting.get()) {
            waiting.set(false);
            throw new TaxiNotFoundException("No taxi avaiable");}
    }

    private void waiting(int i) {
    }
}

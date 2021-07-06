package test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ValueObject {
    public String value = "";
    Lock lock = new ReentrantLock();
    Condition notNull = lock.newCondition();
    Condition notFull = lock.newCondition();

    public void produce() {
        lock.lock();
        try {
            if(!value.equals("")) notFull.await();
            value = System.currentTimeMillis() + "_" + System.nanoTime();
            System.out.println(Thread.currentThread().getName() + " set value: " + value);
            Thread.sleep(1000);
            notNull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void custom() {
        lock.lock();
        try {
            if(value.equals("")) notNull.await();
            System.out.println(Thread.currentThread().getName() + " get value: " + value);
            value = "";
            Thread.sleep(1000);
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ValueObject obj = new ValueObject();
        Thread p = new Thread(() -> {
            while(true) obj.produce();
        });
        Thread c1 = new Thread(() -> {
            while(true) obj.custom();
        });
        Thread c2 = new Thread(() -> {
            while(true) obj.custom();
        });
        p.start();
        c1.start();
        c2.start();
    }
}

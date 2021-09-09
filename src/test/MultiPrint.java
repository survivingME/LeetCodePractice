package test;

public class MultiPrint {
    static final Object lock = new Object();
    static volatile int number = 1;

    public static void main(String[] args) {
        Thread first = new Thread(() -> {
            synchronized (lock) {
                while(number <= 100) {
                    if(number % 3 == 1) System.out.println(Thread.currentThread() + " : " + number++);
                    lock.notifyAll();
                    if(number == 101) return;
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread second = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while(number <= 100) {
                        if(number % 3 == 2) System.out.println(Thread.currentThread() + " : " + number++);
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread third = new Thread(() -> {
            synchronized (lock) {
                while(number <= 100) {
                    if(number % 3 == 0) System.out.println(Thread.currentThread() + " : " + number++);
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        first.start();
        second.start();
        third.start();
    }
}

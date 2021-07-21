package test;

import java.util.concurrent.SynchronousQueue;

public class QueueTest {

    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        queue.offer(1);
    }
}

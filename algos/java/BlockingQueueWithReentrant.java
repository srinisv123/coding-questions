import java.util.concurrent.locks.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueWithReentrant<T> {

    private Queue<T> queue;
    private AtomicInteger limit = new AtomicInteger(10);
    private Lock lock = new ReentrantLock();
    private Condition put_condition = lock.newCondition();
    private Condition take_condition = lock.newCondition();

    public BlockingQueueWithReentrant(AtomicInteger limit){
        queue = new LinkedList<T>();
        this.limit = limit;
    }

    public boolean enqueue(T item) throws InterruptedException{
        lock.lockInterruptibly();
        try {
            while(queue.size() == limit.get()) {
                put_condition.await();
            }
            take_condition.signal();
            queue.add(item);
        } finally{
            lock.unlock();
        }

        return true;
    }

    public T dequeue() throws InterruptedException{
        lock.lockInterruptibly();
        try {
            while (queue.size() == 0) {
                take_condition.await();
            }
            put_condition.signal();
            return queue.poll();
        } finally {
            lock.unlock();
        }
    }
}


class Producer implements Runnable {

    BlockingQueueWithReentrant<Integer> queue;

    public Producer(BlockingQueueWithReentrant<Integer> queue) {
        this.queue = queue;
    }

    public void run() {

        try {
            for (int i=0;i<10;i++) {
                this.queue.enqueue(i);
                System.out.println("Enqueued: "+i);

                if (i%2==0) {
                    try {Thread.sleep(444);}catch(InterruptedException e){};
                }

            }
        }catch(Exception e) {
            System.out.println("Caught exception: ");
            e.printStackTrace();
        } 
    }
}



class Consumer implements Runnable {

    BlockingQueueWithReentrant<Integer> queue;

    public Consumer(BlockingQueueWithReentrant<Integer> queue) {
        this.queue = queue;
    }

    public void run() {

        try {
            for (int i=0;i<10;i++) {
                Integer data = this.queue.dequeue();
                System.out.println("Dequeued: "+data);

                if (i%2!=0) {
                    try {Thread.sleep(444);}catch(InterruptedException e){};
                }
            }
        } catch (Exception e) {
            System.out.println("Caught exception: ");
            e.printStackTrace();
        }
    }

}


class ProducerConsumerUsingBlockingQueueWithReentrant {

    public static void main(String[] args) {

        BlockingQueueWithReentrant<Integer> blqueue = new BlockingQueueWithReentrant<Integer>(new AtomicInteger(5));
        Thread producer = new Thread(new Producer(blqueue));
        Thread consumer = new Thread(new Consumer(blqueue));
        producer.start();
        consumer.start();


    }


}

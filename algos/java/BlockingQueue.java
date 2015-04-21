import java.util.LinkedList;

class BlockingQueue<E> {

    LinkedList<E> queue;
    int size;

    public BlockingQueue(int size) {
        this.queue = new LinkedList<E>();
        this.size =size;
    }

    public synchronized void enqueue(E data) {

        try {
            while(this.queue.size() >= this.size) {
                wait();
            }
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
            return;
        }

        queue.add(data);
        notifyAll();

    }



    public synchronized E dequeue() {

        try {
            while(this.queue.size() <=0) {
                wait();
            }
        }catch(InterruptedException e) {
            System.out.println("Interrupted");
            return null;
        }

        E data = queue.removeFirst();
        notifyAll();
        return data;
    }
}

class Producer implements Runnable {

    BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {

        for (int i=0;i<10;i++) {
            this.queue.enqueue(i);
            System.out.println("Enqueued: "+i);

            if (i%2==0) {
                try {Thread.sleep(444);}catch(InterruptedException e){};
            }

        }
    }
}



class Consumer implements Runnable {

    BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {

        for (int i=0;i<11;i++) {
            Integer data = this.queue.dequeue();
            System.out.println("Dequeued: "+data);

            if (i%2!=0) {
                try {Thread.sleep(444);}catch(InterruptedException e){};
            }
        }
    }

}


class ProducerConsumerUsingBlockingQueue {

    public static void main(String[] args) {

        BlockingQueue<Integer> blqueue = new BlockingQueue<Integer>(5);
        Thread producer = new Thread(new Producer(blqueue));
        Thread consumer = new Thread(new Consumer(blqueue));
        producer.start();
        consumer.start();

        consumer.interrupt();

    }


}

class ThreadExample implements Runnable{


    public void run() {
        System.out.println("From run");
        return;
    }

    public static void main(String[] args) throws InterruptedException{
        
        Thread t = new Thread(new ThreadExample());
        t.start();
        System.out.println("From main");
        t.join();
        System.out.println("Main second");
        return;


    }




}

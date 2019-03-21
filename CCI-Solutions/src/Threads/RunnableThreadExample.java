package Threads;

public class RunnableThreadExample implements Runnable{
    public int count = 0;

    @Override
    public void run() {
        System.out.println("Runnable Thread Starting.");
        try {
            while(count < 5) {
                Thread.sleep(500);
                count++;
            }
        } catch (InterruptedException exc) {
            System.out.println("Runnable Thread Interrupted");
        }
        System.out.println("Runnable Thread Terminating");
    }

    public static void main(String[] args) {
        RunnableThreadExample instance = new RunnableThreadExample();
        Thread thread =  new Thread(instance);
        thread.start();

        while(instance.count != 5) {
            try {
                Thread.sleep(250);
            } catch(InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }
}

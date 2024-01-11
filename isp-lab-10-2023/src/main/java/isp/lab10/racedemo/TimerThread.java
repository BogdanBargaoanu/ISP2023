package isp.lab10.racedemo;

public class TimerThread  extends Thread{
    private long timer;

    public long getTimer() {
        return timer;
    }

    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10);
                timer += 10;
            }
        } catch (InterruptedException e) {
            // Timer thread interrupted
        }
    }
}

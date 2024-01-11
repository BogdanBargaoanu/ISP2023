package isp.lab10.racedemo;

import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class CarRace {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Car Race");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CarPanel carPanel = new CarPanel();
        SemaphorePanel semaphorePanel = new SemaphorePanel();


        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(carPanel, BorderLayout.CENTER);
        frame.getContentPane().add(semaphorePanel, BorderLayout.EAST);
        frame.pack();
        frame.setSize(500, 300);
        frame.setVisible(true);

        SemaphoreThread semaphoreThread = new SemaphoreThread(semaphorePanel);
        semaphoreThread.start();
        TimerThread timerThread = new TimerThread();
        timerThread.start();

        Car car1 = new Car("Red car", carPanel);
        Car car2 = new Car("Blue car", carPanel);
        Car car3 = new Car("Green car", carPanel);
        Car car4 = new Car("Yellow car", carPanel);
/* //acelasi lucru cu o metoda in plus in Semaphore
        while (!semaphorePanel.isGreen()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
*/
        try {
            semaphoreThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        carPanel.getPlaySound().playSound();
        car1.start();
        car2.start();
        car3.start();
        car4.start();
        try {
            car1.join();
            car2.join();
            car3.join();
            car4.join();
            timerThread.interrupt();
            timerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long raceDuration = timerThread.getTimer();
        System.out.println("Race duration: " + raceDuration + " miliseconds");
    }

}

class Car extends Thread {
    private String name;
    private int distance = 0;
    private CarPanel carPanel;
    private long raceDuration;

    public Car(String name, CarPanel carPanel) {
        //set thread name;
        setName(name);
        this.name = name;
        this.carPanel = carPanel;
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        while (distance < 400) {
            // simulate the car moving at a random speed
            int speed = (int) (Math.random() * 10) + 1;
            distance += speed;

            carPanel.updateCarPosition(name, distance);

            try {
                // pause for a moment to simulate the passage of time
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        raceDuration = endTime - startTime;
        carPanel.carFinished(name, raceDuration);
    }
}

class CarPanel extends JPanel {
    private int[] carPositions;
    private String[] carNames;
    private Color[] carColors;
    private PlaySound playSound;
    private int finishedCarCount;
    private Map<String, Long> raceDurations;

    public CarPanel() {
        carPositions = new int[4];
        carNames = new String[]{"Red car", "Blue car", "Green car", "Yellow car"};
        carColors = new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
        playSound = new PlaySound();
        finishedCarCount = 0;
        raceDurations = new HashMap<>();
    }

    public PlaySound getPlaySound() {
        return playSound;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 4; i++) {
            int yPos = 50 + i * 50; // Vertical position of the car
            int xPos = carPositions[i]; // Horizontal position of the car
            int carSize = 30; // Size of the car

            g.setColor(carColors[i]);
            g.fillOval(xPos, yPos, carSize, carSize);
            g.setColor(Color.BLACK);
            g.drawString(carNames[i], xPos, yPos - 5);
        }
    }

    public void updateCarPosition(String carName, int distance) {
        int carIndex = getCarIndex(carName);
        if (carIndex != -1) {
            carPositions[carIndex] = distance;
            repaint();
        }
    }

    public void carFinished(String carName, long raceDuration) {
        raceDurations.put(carName, raceDuration);
        finishedCarCount++;
        if (finishedCarCount == 4) {
            playSound.stopSound();
            int position = 1;
            for (Map.Entry<String, Long> entry : raceDurations.entrySet()) {
                System.out.printf("%d. %s - Duration: %d milliseconds%n", position, entry.getKey(), entry.getValue());
                position++;
            }
        }
    }

    private int getCarIndex(String carName) {
        for (int i = 0; i < 4; i++) {
            if (carNames[i].equals(carName)) {
                return i;
            }
        }
        return -1;
    }
}

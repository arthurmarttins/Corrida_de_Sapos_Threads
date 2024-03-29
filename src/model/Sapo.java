package model;

import java.util.Random;

public class Sapo implements Runnable {
    public static final int MAX_DISTANCE = 20; // Distância total da corrida

    private String name;
    private int distance;
    private Random random;

    public Sapo(String name) {
        this.name = name;
        this.distance = 0;
        this.random = new Random(); // Cada sapo tem seu próprio gerador de números aleatórios
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public void run() {
        while (distance < MAX_DISTANCE) {
            int jumpDistance = random.nextInt(6); // Números aleatórios de 0 a 5
            distance += jumpDistance;

            try {
                Thread.sleep(1000); // Aguarda 1 segundo entre os saltos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

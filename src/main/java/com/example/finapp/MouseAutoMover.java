package com.example.finapp;
import java.awt.Robot;
import java.awt.AWTException;

public class MouseAutoMover {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();

            int x = 500;
            int y = 500;
            boolean toggle = true;

            while (true) {
                // Alternate between two points
                if (toggle) {
                    robot.mouseMove(x, y);
                } else {
                    robot.mouseMove(x + 50, y + 50);
                }
                toggle = !toggle;

                System.out.println("Mouse moved to: " + (toggle ? (x + 50) : x) + "," + (toggle ? (y + 50) : y));
                Thread.sleep(5000); // 5 seconds delay
            }
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

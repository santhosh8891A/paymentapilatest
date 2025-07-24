package com.example.finapp;
import java.awt.Robot;
import java.awt.AWTException;

public class MouseMoveExample {
    public static void main(String[] args) {
        try {
            // Create Robot instance
            Robot robot = new Robot();
            
            // Move the mouse in a square pattern
            for (int i = 0; i < 1500; i += 50) {
                robot.mouseMove(200 + i, 200);   // move right
                Thread.sleep(500);
                robot.mouseMove(200 + i, 400);   // move down
                Thread.sleep(500);
            }

            System.out.println("Mouse movement completed.");
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

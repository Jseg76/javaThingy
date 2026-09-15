package com.code;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.color.*;
import java.awt.event.*;

public class Game implements Runnable {
    Player player = new Player(400, 700, 50, 50, Color.BLUE, 10);
    int width, height;
    private String title;
    boolean running = false;
    Thread thread;

    public BufferStrategy bs;
    public Graphics g;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }
    public void update() {

    }
    public void draw() {
        bs = Window.getCanvas().getBufferStrategy();
        if (bs == null){
            Window.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
        player.draw(g);
        bs.show();
        g.dispose();
    }
    public void run() {
        Window window = new Window(title, width, height);
        while(running){
            update();
            draw();
        }
        stop();
    }
    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

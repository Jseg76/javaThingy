package com.code;

import javax.swing.JFrame;
import java.awt.*;

public class Window {
    private JFrame frame;
    private static Canvas canvas;

    String title;
    int width, height;

    public Window(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        createWindow();
    }
    void createWindow(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        frame.add(canvas);
        frame.pack();
    }
    public static Canvas getCanvas(){
        return canvas;
    }



}

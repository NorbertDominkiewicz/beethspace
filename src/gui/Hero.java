package gui;

import app.Root;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

class Location{
    private int x,y;
    Location(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}

public class Hero extends JPanel{
    Integer HERO_HEIGHT = 200;
    Integer HERO_WIDTH = 106;
    Image LEFT_VIEW_MODEL = new ImageIcon("src/sources/beethoven200.png").getImage();
    Image rightViewModel;
    Location currentLocation;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(LEFT_VIEW_MODEL,0,0,getWidth(),getHeight(),this);
    }

    Hero(Root app){
        currentLocation = new Location(950,600);
        setSize(HERO_WIDTH,HERO_HEIGHT);
        setOpaque(false);
    }

    public void moveRight() {
        new Thread(() -> {
            try{
                for (int i = 0; i < 10; i++) {
                    currentLocation.setX(currentLocation.getX() + 1);
                    setBounds(currentLocation.getX(), currentLocation.getY(), HERO_WIDTH, HERO_HEIGHT);
                    repaint();
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }).start();
    }
    public void moveLeft() {
        new Thread(() -> {
            try{
                for (int i = 0; i < 10; i++) {
                    currentLocation.setX(currentLocation.getX() - 1);
                    setBounds(currentLocation.getX(), currentLocation.getY(), HERO_WIDTH, HERO_HEIGHT);
                    repaint();
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }).start();
    }
    public void jump() {
        new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    currentLocation.setY(currentLocation.getY() - 5);
                    setBounds(currentLocation.getX(), currentLocation.getY(), HERO_WIDTH, HERO_HEIGHT);
                    repaint();
                    Thread.sleep(5);
                }
                for (int i = 0; i < 20; i++) {
                    currentLocation.setY(currentLocation.getY() + 5);
                    setBounds(currentLocation.getX(), currentLocation.getY(), HERO_WIDTH, HERO_HEIGHT);
                    repaint();
                    Thread.sleep(5);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }).start();
    }
}

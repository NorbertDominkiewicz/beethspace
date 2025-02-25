package gui;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

class BackgroundPanel extends JPanel {
    Image BACKGROUND_IMG = new ImageIcon("src/sources/bg.jpg").getImage();
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(BACKGROUND_IMG, 0, 0, this.getWidth(), this.getHeight(), this);
    }
    BackgroundPanel(){
        setLayout(new BorderLayout());
    }
}

public class Game extends JFrame {
    Hero hero;
    BackgroundPanel backgroundPanel;
    public Game(app.Root gameLogic) {
        setTitle("Beethspace Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600, 900);
        setLocationRelativeTo(null);
        backgroundPanel = new BackgroundPanel();
        setContentPane(backgroundPanel);
        setLayout(null);
        setVisible(true);
        hero = new Hero(gameLogic);
        hero.setBounds(hero.currentLocation.getX(), hero.currentLocation.getY(), hero.HERO_WIDTH, hero.HERO_HEIGHT);
        add(hero);
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                switch(e.getKeyCode()){
                    case KeyEvent.VK_RIGHT:
                        hero.moveRight();
                        break;
                    case KeyEvent.VK_LEFT:
                        hero.moveLeft();
                        break;
                    case KeyEvent.VK_UP:
                        hero.jump();
                        break;
                }
            }
        });
    }
}

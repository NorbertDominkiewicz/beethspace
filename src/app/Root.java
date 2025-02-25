package app;

import gui.Game;

public class Root {
    Game gui;
    public Root(){
        gui = new Game(this);
    }
}

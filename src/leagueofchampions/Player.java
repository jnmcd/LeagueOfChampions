package leagueofchampions;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Player extends InputAdapter {
    Map m = new Map();
    Point location = new Point(0, 0);
    Point destination = null;
    int maxMS = 100;
    int currMS = 0;
    int angle = 0;
    int gold = 500;
    int ap = 0;
    int ad = 50;
    double as = 1;
    boolean inShop = false;
    Champion champ = new Champion();
    ArrayList<Character> keysDown = new ArrayList();
    public Player(Map map){
        m = map;
    }
    public void move(){
        if(destination != null)
            if(destination.equalTo(location))
                destination = null;
            else ;
    }
    public void draw(Graphics2D g){
        champ.draw(location.x, location.y, g);
    }
    @Override public void keyPressed(KeyEvent e){
        if(!keysDown.contains(e.getKeyChar()))
            keysDown.add(e.getKeyChar());
    }
    @Override public void keyReleased(KeyEvent e){
        if(keysDown.contains(e.getKeyChar()))
            keysDown.remove(Character.valueOf(e.getKeyChar()));
    }
    @Override public void mousePressed(MouseEvent e){
    }
}
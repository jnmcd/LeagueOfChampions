package leagueofchampions;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Player extends InputAdapter {
    Map m = new Map();
    Point location = new Point(30, 30);
    Point destination = null;
    int maxMS = 100;
    int currMS = 0;
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
            else {
                double angle = ((Math.atan2(destination.y - location.y, destination.x - location.x) * 180.0 / Math.PI) + 720) % 360;
                angle = Math.round(angle / 90.0) % 4;
                if(angle == 0)
                    location.x++;
                if(angle == 1)
                    location.y++;
                if(angle == 2)
                    location.x--;
                if(angle == 3)
                    location.y--;
            }
    }
    public void draw(Graphics2D g){
        champ.draw(location.x, location.y, g);
    }
    public void setDestination(Point p){
        p.x += location.x - 350;
        p.y += location.y - 350;
        if(m.pathExists(location, p)){
            System.out.println("Set New Destination");
            System.out.println("X: " + p.x + ", Y: " + p.y);
            destination = p;
        }
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
        if(e.getButton() == 1)
            setDestination(new Point(e.getX() - 10, e.getY() - 30));
    }
}
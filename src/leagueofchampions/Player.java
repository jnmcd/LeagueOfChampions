package leagueofchampions;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Player extends InputAdapter {
    World world;
    Point location = new Point(30, 30);
    Point mouseLocation = new Point(0, 0);
    Point destination = null;
    double actualX, actualY = actualX = 30.0;
    int MS = 100;
    int gold = 500;
    int ap = 0;
    int ad = 50;
    double as = 1;
    boolean inShop = false;
    ArrayList<Character> keysDown = new ArrayList();
    public Player(World world){
        this.world = world;
    }
    public void move(){
        if(destination != null)
            if(destination.equalTo(location))
                destination = null;
            else {
                double angle = ((Math.atan2(destination.y - actualY, destination.x - actualX)) + 4 * Math.PI) % (2 * Math.PI);
                actualX += Math.cos(angle) * (MS / 100);
                actualY += Math.sin(angle) * (MS / 100);
                location.x = (int) Math.round(actualX);
                location.y = (int) Math.round(actualY);
                if(destination.equalTo(location))
                    destination = null;
            }
    }
    public void draw(Graphics2D g){
        draw(location.x, location.y, g);
    }
    public void draw(int x, int y, Graphics2D g){}
    public void setDestination(Point p){
        p.x += location.x - 350;
        p.y += location.y - 350;
        if(world.map.pathExists(location, p)){
            System.out.println("Set New Destination");
            System.out.println("X: " + p.x + ", Y: " + p.y);
            destination = p;
        }
    }
    public void updateWorld(World w){
        world = w;
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
    @Override public void mouseMoved(MouseEvent e){
        mouseLocation = new Point(e.getX() - 10, e.getY() - 30);
    }
}
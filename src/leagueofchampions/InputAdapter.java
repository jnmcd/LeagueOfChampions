package leagueofchampions;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InputAdapter implements KeyListener, MouseListener, MouseMotionListener {
    @Override public void keyTyped(KeyEvent ke){}
    @Override public void keyPressed(KeyEvent ke){}
    @Override public void keyReleased(KeyEvent ke){}
    @Override public void mouseClicked(MouseEvent me){}
    @Override public void mousePressed(MouseEvent me){}
    @Override public void mouseReleased(MouseEvent me){}
    @Override public void mouseEntered(MouseEvent me){}
    @Override public void mouseExited(MouseEvent me){}
    @Override public void mouseDragged(MouseEvent me){}
    @Override public void mouseMoved(MouseEvent me){}
}
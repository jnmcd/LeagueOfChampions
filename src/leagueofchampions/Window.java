package leagueofchampions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Window extends JPanel implements ActionListener {
    JFrame frame = new JFrame("League Of Legends");
    Map m = new Map();
    Player p = new Player(m);
    boolean[][] view = new boolean[700][700];
    public Window(){}
    public void init(){
        setPreferredSize(new Dimension(700, 700));
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
        frame.setFocusable(true);
        frame.addKeyListener(p);
        frame.addMouseListener(p);
        Timer t = new Timer(1, this);
        t.start();
    }
    public void updateView(){
        view = m.getView(p);
    }
    @Override public void paintComponent(Graphics g){
        for(int x = 0; x < view.length; x++){
            for(int y = 0; y < view[x].length; y++){
                if(view[x][y])
                    g.setColor(Color.black);
                else
                    g.setColor(Color.white);
                g.drawRect(x, y, 1, 1);
            }
        }
        p.draw((Graphics2D) g);
    }
    @Override public void actionPerformed(ActionEvent e){
        p.move();
        updateView();
        repaint();
    }
}
package leagueofchampions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JPanel implements ActionListener {
    JFrame frame = new JFrame("League Of Champions");
    World world;
    Champion p;
    boolean[][] view = new boolean[700][700];
    long lastTime = 0;
    public Window(World w){
        world = w;
        p = new Champion.MarkMerc(world);
        world.players.add(p);
    }
    public void init(){
        setPreferredSize(new Dimension(700, 700));
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
        frame.setFocusable(true);
        frame.addKeyListener(p);
        frame.addMouseListener(p);
        updateView();
    }
    public void updateView(){
        view = world.map.getView(p);
        p.move();
        p.updateWorld(world);
        repaint();
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
        for(Player player : world.players){
            player.draw((Graphics2D)(g));
        }
        for(Minion minion : world.minions){
            minion.draw((Graphics2D)(g));
        }
        for(Spell spell : world.spells){
            spell.draw((Graphics2D)(g));
        }
        for(Turret turret : world.turrets){
            turret.draw((Graphics2D)(g));
        }
    }
    @Override public void actionPerformed(ActionEvent e){
        p.move();
        updateView();
        repaint();
    }
}
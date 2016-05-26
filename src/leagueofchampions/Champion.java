package leagueofchampions;

import java.awt.Color;
import java.awt.Graphics2D;

public class Champion extends Player {
    public Champion(Map map){
        super(map);
    }
    @Override public void draw(int x, int y, Graphics2D g){
        g.setColor(Color.green);
        g.fillOval(335, 335, 30, 30);
    }
}
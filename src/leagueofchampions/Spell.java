package leagueofchampions;

import java.awt.Graphics2D;

public class Spell {
    String name;
    int manaCost;
    SpellType type;
    public Spell(String name, int manaCost, SpellType type){
        this.name = name;
        this.manaCost = manaCost;
        this.type = type;
    }
    public boolean canCast(World w, int x, int y){
        return true;
    }
    public void draw(Graphics2D g){}
}
package leagueofchampions;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class Champion extends Player {
    HashMap<Character, Spell> spells = new HashMap();
    public Champion(World world){
        super(world);
    }
    public void castSpell(Spell s){
        System.out.println("You just casted " + s.name);
    }
    @Override public void draw(int x, int y, Graphics2D g){
        g.setColor(Color.green);
        g.fillOval(335, 335, 30, 30);
    }
    @Override public void keyPressed(KeyEvent e){
        super.keyPressed(e);
        if(spells.containsKey(e.getKeyChar()))
            castSpell(spells.get(e.getKeyChar()));
    }
    static class MarkMerc extends Champion {
        class ShotgunBlast extends Spell {
            public ShotgunBlast(){
                super("Shotgun Blast", 80, SpellType.AoE);
            }
        }
        class RifleBlast extends Spell {
            public RifleBlast(){
                super("Rifle Blast", 80, SpellType.SkillShot);
            }
        }
        class SniperBlast extends Spell {
            public SniperBlast(){
                super("Sniper Blast", 80, SpellType.Target);
            }
        }
        class GrenadeBlast extends Spell {
            public GrenadeBlast(){
                super("Grenade Blast", 80, SpellType.AoE);
            }
        }
        public MarkMerc(World world){
            super(world);
            spells.put('q', new ShotgunBlast());
            spells.put('w', new RifleBlast());
            spells.put('e', new SniperBlast());
            spells.put('r', new GrenadeBlast());
        }
    }
}
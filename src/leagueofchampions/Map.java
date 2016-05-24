package leagueofchampions;

public class Map {
    boolean[][] map = new boolean[10000][10000];
    public boolean[][] getView(Player c){
        boolean[][] visible = new boolean[700][700];
        for(int x = c.location.x - 350; x < c.location.x + 350; x++){
            for(int y = c.location.y - 350; y < c.location.y + 350; y++){
                if(x >= 10000 || x < 0 || y < 0 || y >= 10000)
                    visible[x + 350 - c.location.x][y + 350 - c.location.y] = true;
                else if(map[x][y])
                    visible[x + 350 - c.location.x][y + 350 - c.location.y] = true;
            }
        }
        return visible;
    }
}
package leagueofchampions;

public class Map {
    boolean[][] map = new boolean[4000][4000];
    public boolean[][] getView(Player c){
        boolean[][] visible = new boolean[700][700];
        for(int x = c.location.x - 350; x < c.location.x + 350; x++){
            for(int y = c.location.y - 350; y < c.location.y + 350; y++){
                if(x >= 4000 || x < 0 || y < 0 || y >= 4000)
                    visible[x + 350 - c.location.x][y + 350 - c.location.y] = true;
                else if(map[x][y])
                    visible[x + 350 - c.location.x][y + 350 - c.location.y] = true;
            }
        }
        return visible;
    }
    public boolean pathExists(Point start, Point end){
        if(end.x >= 4000 || end.x < 0 || end.y < 0 || end.y >= 4000)
            return false;
        if(map[end.x][end.y])
            return false;
        return true;
    }
}
class Cell {
    int heuristic = 0;
    int end = 0;
    Point p;
    Cell parent;
    public Cell(Point p){
        this.p = p;
    }
}
/*
Algorithm for pathfinding:
Recursively do this:

1.  Divide the world in to 100 chunks.
2.  Find the shortest path from start chunk to end chunk.
2a. Each chunk along the way, ensure that there is a path from previous chunk to next chunk
3.  Then, find the shortest path from each chunk in the path to the next chunk.
4.  Combine them.

*/
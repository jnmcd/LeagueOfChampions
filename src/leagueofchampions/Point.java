package leagueofchampions;
public class Point {
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public boolean equalTo(Point p){
        return p.x == x && p.y == y;
    }
}

package leagueofchampions;

public class LeagueOfChampions {
    public static void main(String[] args) throws Exception {
        World world = new World();
        Window w = new Window(world);
        w.init();
        for(;;){
            Thread.sleep(10);
            w.updateView();
        }
    }
}
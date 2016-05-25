package leagueofchampions;

public class LeagueOfChampions {
    public static void main(String[] args) throws Exception {
        Window w = new Window();
        w.init();
        for(;;){
            Thread.sleep(10);
            w.updateView();
        }
    }
}
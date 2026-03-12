import java.io.Serializable;

public class BaseballPlayer implements Serializable {
    private int homeRuns;
    private int rbi;
    private double battingAverage;
    
    public BaseballPlayer(int homeRuns, int rbi, double battingAverage) {
        this.homeRuns = homeRuns;
        this.rbi = rbi;
        this.battingAverage = battingAverage;
    }
    
    public int getHomeRuns() { return homeRuns; } 
    public int getRbi() { return rbi; }
    public double getBattingAverage() { return battingAverage; }
}
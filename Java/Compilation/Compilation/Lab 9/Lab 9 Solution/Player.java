import java.util.Arrays;
public class Player implements Comparable<Player> {
    private String name; //name of the player
    private int[] matchScores; // Array to keep track of scores for individual matches
    private int matchesPlayed; // To keep track of the number of matches played

    public Player(String name, int maxMatches) {
        this.name = name;
        this.matchScores = new int[maxMatches];
        this.matchesPlayed = 0;
    }

    public String getName() {
        return name;
    }

    // Add score for a match and increment the match count
    public void addMatchScore(int score) {
        if (matchesPlayed < matchScores.length) {
            matchScores[matchesPlayed++] = score;
        } else {
            System.out.println("Maximum matches reached. Cannot add more scores.");
        }
    }

    public int getMatchScore(int matchNum){
        return matchScores[matchNum];
    }

    // Get the total score across all matches
    public int getTotalScore() {
        int total = 0;
        for (int i = 0; i < matchesPlayed; i++) {
            total += matchScores[i];
        }
        return total;
    }

    // Get the average score per match
    public double getAverageScore() {
        if (matchesPlayed == 0) return 0.0;
        return (double) getTotalScore() / matchesPlayed;
    }

    // Get the number of matches played
    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    // Compare based on total score, return 1, -1 and 0 if score of the current player if greater than, less than or equal 
    //Check that both object are the instances of the same type, if not return -2
    @Override
    public int compareTo(Player other) {
        if(this instanceof CricketPlayer && other instanceof CricketPlayer){
            if(this.getTotalScore() > other.getTotalScore()){
                return 1;
            } else if(this.getTotalScore() < other.getTotalScore()){
                return -1;
            } else {
                return 0;
            }
        } else if(this instanceof FootballPlayer && other instanceof FootballPlayer){
            if(this.getTotalScore() > other.getTotalScore()){
                return 1;
            } else if(this.getTotalScore() < other.getTotalScore()){
                return -1;
            } else {
                return 0;
            }
        } 
        return -2;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", matchScores=" + Arrays.toString(Arrays.copyOf(matchScores, matchesPlayed)) +
                ", matchesPlayed=" + matchesPlayed +
                '}';
    }
}
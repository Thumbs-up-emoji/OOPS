public class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    private int wins; // Number of wins
    private int ranking; // Current ranking of the team
    private T[] members; // Array of team members
    private int memberCount; // Number of added members
    private boolean[] matchWins; // Tracks whether each match was won
    private int matchesPlayed; // Number of matches played

    @SuppressWarnings("unchecked")
    public Team(String name, int teamSize, int numMatches) {
        this.name = name;
        this.members = (T[]) new Player[teamSize]; // Generic array creation with casting
        this.matchWins = new boolean[numMatches]; // Array to track match wins, assuming it equals team size for simplicity
        this.wins = 0;
        this.ranking = 1; // All teams start at rank 1
        this.memberCount = 0;
        this.matchesPlayed = 0;
    }

    public void addMember(T member) {
        if (memberCount < members.length) {
            members[memberCount++] = member;
        } else {
            System.out.println("Team is full. Cannot add more members.");
        }
    }

    public T[] getMembers() {
        for(int i = 0; i < members.length; i++){
            System.out.println("Player" + i + " " + members[i].getName());
        }
        return members;
    }

    public int numOfMembers(){
        return memberCount;
    }

    public String getName(){
        return name;
    }

    public void recordMatch(boolean win) {
        if (matchesPlayed < matchWins.length) {
            matchWins[matchesPlayed++] = win;
            if (win) {
                wins++;
            }
        } else {
            System.out.println("Maximum number of matches reached. Cannot record more results.");
        }
    }

    public int getWins() {
        return wins;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int compareTo(Team<T> other) {
        return Integer.compare(other.wins, this.wins); // For descending order
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", wins=" + wins +
                ", ranking=" + ranking +
                ", members=" + members.length +
                ", memberCount=" + memberCount +
                ", matchWins=" + this.getWins() +
                ", matchesPlayed=" + matchesPlayed +
                '}';
    }
}

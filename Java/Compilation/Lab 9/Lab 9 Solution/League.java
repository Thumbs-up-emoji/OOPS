import java.util.Arrays;
import java.util.Random;
public class League<T extends Team<? extends Player>> {
    private T[] teams;
    private T[] winners; // Array to record the winner of each match
    private int teamCount;
    private int matchCount; // Counter for the number of matches played

    @SuppressWarnings("unchecked")
    public League(int leagueSize, int totalMatch) {
        teams = (T[]) new Team[leagueSize]; // Generic array creation with casting
        winners = (T[]) new Team[totalMatch]; // Assuming a single round-robin format for simplicity
        this.teamCount = 0;
        this.matchCount = 0;
    }

    public void addTeam(T team) {
        if (teamCount < teams.length) {
            teams[teamCount++] = team;
        } else {
            System.out.println("League is full. Cannot add more teams.");
        }
    }

    public void playMatch(T team1, T team2) {
        int team1Score = assignRandomScoresToTeam1(team1); // Assign scores to team1
        int team2Score = assignRandomScoresToTeam1(team2);
        if (team1Score > team2Score) {
            team1.recordMatch(true);
            team2.recordMatch(false);
        } else if (team1Score < team2Score) {
            team1.recordMatch(false);
            team2.recordMatch(true);
        } else {
            System.out.println("The match is a draw.");
            team1.recordMatch(false);
            team2.recordMatch(false);
        }

        matchCount++; // Increment the match counter
        updateRankings();
    }

    private void updateRankings() {
        // Sort the teams based on wins
        Arrays.sort(teams, 0, teamCount);

        // Assign ranks, considering ties
        int currentRank = 1;
        for (int i = 0; i < teamCount; i++) {
            if (i > 0 && teams[i].getWins() == teams[i - 1].getWins()) {
                teams[i].setRanking(teams[i - 1].getRanking());
            } else {
                teams[i].setRanking(currentRank);
            }
            // Adjust currentRank for tied rankings
            if (i < teamCount - 1 && teams[i].getWins() != teams[i + 1].getWins()) {
                currentRank = i + 2;
            }
        }
    }

    public T[] getTeams() {
        return teams;
    }

    public T[] getWinners() {
        T[] temp =  Arrays.copyOf(winners, matchCount);
        return temp; // Return only the part of the array that has been used
    }

    public void showStandings() {
        for (T team : teams) {
            if (team != null) { // Only print out teams that have been added
                System.out.println(team);
            }
        }
    }

    private static int assignRandomScoresToTeam1(Team<? extends Player> team) {
        Random rand = new Random();
        int teamScore = 0;
        Player[] players = team.getMembers(); // Get the members as type Player[]

        for (Player rawPlayer : players) {
            if (rawPlayer instanceof FootballPlayer) { // Check if the player is an instance of FootballPlayer
                FootballPlayer player = (FootballPlayer) rawPlayer; // Now you can safely cast
                int score = rand.nextInt(3 + 1); // Scores are 0 to maxScorePerPlayer
                player.addMatchScore(score); // Update the player's score for this match
                teamScore += score; // Add to the team's total score
            } else {
                CricketPlayer player = (CricketPlayer) rawPlayer; // Now you can safely cast
                int score = rand.nextInt(150 + 1); // Scores are 0 to maxScorePerPlayer
                player.addMatchScore(score); // Update the player's score for this match
                teamScore += score;
            }
        }

        return teamScore;
    }

}

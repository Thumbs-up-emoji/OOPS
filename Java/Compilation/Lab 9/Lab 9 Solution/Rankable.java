public interface Rankable extends Comparable<Rankable> {
    int getRanking();
    String getName(); // Method to get name of the rankable entity
}
public class RecommendationResult {
    private long animeId;
    private float score;

    public RecommendationResult(long animeId, float score) {
        this.animeId = animeId;
        this.score = score;
    }

    public long getAnimeId() {
        return animeId;
    }

    public float getScore() {
        return score;
    }
}

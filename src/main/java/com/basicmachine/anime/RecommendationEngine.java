import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.util.List;

public class RecommendationEngine {
    private DataModel model;
    private UserNeighborhood neighborhood;
    private UserSimilarity similarity;

    public RecommendationEngine(DataModel model, UserNeighborhood neighborhood, UserSimilarity similarity) {
        this.model = model;
        this.neighborhood = neighborhood;
        this.similarity = similarity;
    }

    public List<RecommendedItem> getRecommendations(long userId, int numRecommendations) throws TasteException {
        GenericUserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
        return recommender.recommend(userId, numRecommendations);
    }
}

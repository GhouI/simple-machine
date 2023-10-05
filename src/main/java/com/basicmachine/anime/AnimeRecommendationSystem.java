import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.util.List;

public class AnimeRecommendationSystem {
    public static void main(String[] args) {
        try {
            // Load the user ratings data
            DataModel model = new FileDataModel(new File("anime_ratings.txt"));

            // Define a user similarity metric (e.g., Pearson correlation)
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);

            // Define a neighborhood for users (e.g., Nearest N Users)
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(10, similarity, model);

            // Create a user-based recommender
            GenericUserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

            // Generate recommendations for a user (replace USER_ID with the user's actual ID)
            long userId = USER_ID;
            List<RecommendedItem> recommendations = recommender.recommend(userId, 10); // Get 10 recommendations

            // Print the recommended anime titles and their corresponding scores
            for (RecommendedItem recommendation : recommendations) {
                long animeId = recommendation.getItemID();
                float score = recommendation.getValue();
                System.out.println("Anime ID: " + animeId + ", Score: " + score);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

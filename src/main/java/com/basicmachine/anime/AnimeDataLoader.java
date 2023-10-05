import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;

import java.io.File;

public class AnimeDataLoader {
    public static DataModel loadDataModel(String dataFilePath) {
        try {
            return new FileDataModel(new File(dataFilePath));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

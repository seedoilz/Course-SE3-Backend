package nju.sentistrength.project.service;
import nju.sentistrength.project.model.Data;
import nju.sentistrength.project.core.Service;
import nju.sentistrength.project.model.VO.ScoreSentimentData;
import nju.sentistrength.project.model.VO.TimeSentimentData;

import java.util.List;


/**
 * Created by auto on 2023/05/26.
 */
public interface DataService extends Service<Data> {
    List<Data> getDataByCollection(int collectionId);
    List<TimeSentimentData> getDataByTime(int collectionId, String beginDateStr, String endDateStr);
    List<TimeSentimentData> getDataByVersion(String project);
    List<ScoreSentimentData> getDataByUsername(int collectionId, String username);
}

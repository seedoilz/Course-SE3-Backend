package nju.sentistrength.project.dao;

import nju.sentistrength.project.core.Mapper;
import nju.sentistrength.project.model.Data;
import nju.sentistrength.project.model.VO.ScoreSentimentData;
import nju.sentistrength.project.model.VO.TimeSentimentData;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DataMapper extends Mapper<Data> {
    List<Data> getDataByCollection(@Param("collectionId") int collectionId);

    List<TimeSentimentData> getData(@Param("collectionId") int collectionId,@Param("beginDate") Date beginTime,@Param("endDate") Date endTime);

    List<TimeSentimentData> getDataByVersion(@Param("collectionId") int collectionId);

    List<ScoreSentimentData> getDataByUsername(@Param("collectionId") int collectionId, @Param("username") String username);
}



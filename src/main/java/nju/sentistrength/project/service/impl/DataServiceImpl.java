package nju.sentistrength.project.service.impl;

import nju.sentistrength.project.dao.DataMapper;
import nju.sentistrength.project.model.Data;
import nju.sentistrength.project.model.VO.ScoreSentimentData;
import nju.sentistrength.project.model.VO.TimeSentimentData;
import nju.sentistrength.project.service.DataService;
import nju.sentistrength.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by auto on 2023/05/26.
 */
@Service
@Transactional
public class DataServiceImpl extends AbstractService<Data> implements DataService {
    @Resource
    private DataMapper dataMapper;

    @Override
    public List<TimeSentimentData> getDataByTime(int collectionId, String beginDateStr, String endDateStr) {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date beginTime =dateFormat.parse(beginDateStr);
            Date endTime=dateFormat.parse(endDateStr);
            if(beginTime.compareTo(endTime)>0){
                return null;
            }else{
                List<TimeSentimentData> data = dataMapper.getData(collectionId,beginTime,endTime);
                return data;
            }
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TimeSentimentData> getDataByVersion(int collectionId, String version) {
        return dataMapper.getDataByVersion(collectionId, version);
    }

    @Override
    public List<ScoreSentimentData> getDataByUsername(int collectionId, String username) {
        return dataMapper.getDataByUsername(collectionId, username);
    }


}

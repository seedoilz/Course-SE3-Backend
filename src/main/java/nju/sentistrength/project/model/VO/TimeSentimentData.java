package nju.sentistrength.project.model.VO;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class TimeSentimentData {

    private String project;

    private String username;

    private String version;

    private String beginTime;

    private Integer positiveNumber;

    private Integer negativeNumber;

    private Integer neutralNumber;
}

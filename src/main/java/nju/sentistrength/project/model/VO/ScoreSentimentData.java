package nju.sentistrength.project.model.VO;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ScoreSentimentData {
    private String project;

    private String username;

    private String version;

    @JSONField(format="yyyy/MM/dd")
    private Date createdAt;

    private Integer positiveScore;

    private Integer negativeScore;

}

package nju.sentistrength.project.model.VO;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class ScoreSentimentData {
    private String project;

    private String username;

    private String version;

    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @JSONField(format="yyyy/MM/dd HH:mm:ss")
    private String createdAt;

    private Integer positiveScore;

    private Integer negativeScore;

}

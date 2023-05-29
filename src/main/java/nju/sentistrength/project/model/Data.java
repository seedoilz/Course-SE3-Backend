package nju.sentistrength.project.model;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@lombok.Data
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "issue_number")
    private Integer issueNumber;

    @Column(name = "internal_issue_number")
    private Integer internalIssueNumber;

    private String username;

    @Column(name = "created_at")
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @JSONField(format="yyyy/MM/dd HH:mm:ss")   // 数据库导出页面时json格式化
    private Date createdAt;

    @Column(name = "ended_at")
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @JSONField(format="yyyy/MM/dd HH:mm:ss")
    private Date endedAt;

    @Column(name = "is_pull_request")
    private Boolean isPullRequest;

    private String labels;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "version_number")
    private String versionNumber;

    @Column(name = "positive_score")
    private Integer positiveScore;

    @Column(name = "negative_score")
    private Integer negativeScore;

    private String content;
}

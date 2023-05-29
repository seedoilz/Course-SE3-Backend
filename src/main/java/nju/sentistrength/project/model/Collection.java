package nju.sentistrength.project.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;

@Data
@Alias("DataCollection")
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;
}

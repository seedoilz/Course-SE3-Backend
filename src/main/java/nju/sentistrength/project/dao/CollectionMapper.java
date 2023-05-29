package nju.sentistrength.project.dao;

import nju.sentistrength.project.core.Mapper;
import nju.sentistrength.project.model.Collection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionMapper extends Mapper<Collection> {
    int addToCollection(@Param("dataIds") List<Integer> dataIds,@Param("collectionId")  int collectionId);
}

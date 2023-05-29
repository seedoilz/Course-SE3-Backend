package nju.sentistrength.project.service.impl;

import nju.sentistrength.project.dao.CollectionMapper;
import nju.sentistrength.project.model.Collection;
import nju.sentistrength.project.service.CollectionService;
import nju.sentistrength.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by auto on 2023/05/19.
 */
@Service
@Transactional
public class CollectionServiceImpl extends AbstractService<Collection> implements CollectionService {
    @Resource
    private CollectionMapper collectionMapper;

    @Override
    public void addToCollection(List<Integer> dataIds,int collectionId) {
        if(!dataIds.isEmpty()){
            collectionMapper.addToCollection(dataIds, collectionId);
        }
    }
}

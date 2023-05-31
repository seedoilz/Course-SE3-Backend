package nju.sentistrength.project.service;
import nju.sentistrength.project.model.Collection;
import nju.sentistrength.project.core.Service;

import java.util.List;


/**
 * Created by auto on 2023/05/19.
 */
public interface CollectionService extends Service<Collection> {
    void addToCollection(List<Integer> dataIds, int collectionId);
    void deleteCollectionData(int collectionId);
}

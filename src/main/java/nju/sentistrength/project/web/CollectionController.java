package nju.sentistrength.project.web;
import nju.sentistrength.project.core.Result;
import nju.sentistrength.project.core.ResultGenerator;
import nju.sentistrength.project.model.Collection;
import nju.sentistrength.project.service.CollectionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by auto on 2023/05/19.
*/
@RestController
@RequestMapping("/collection")
public class CollectionController {
    @Resource
    private CollectionService collectionService;

    @PostMapping("/addToCollection")
    public Result addToCollection(@RequestBody List<Integer> dataIds, @RequestParam("collectionId") int collectionId){
        collectionService.addToCollection(dataIds, collectionId);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Collection collection) {
        collectionService.save(collection);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        collectionService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Collection collection) {
        collectionService.update(collection);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Collection collection = collectionService.findById(id);
        return ResultGenerator.genSuccessResult(collection);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Collection> list = collectionService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

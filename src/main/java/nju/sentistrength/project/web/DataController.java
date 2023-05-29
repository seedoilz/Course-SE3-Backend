package nju.sentistrength.project.web;
import nju.sentistrength.project.core.Result;
import nju.sentistrength.project.core.ResultGenerator;
import nju.sentistrength.project.model.Data;
import nju.sentistrength.project.service.DataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by auto on 2023/05/26.
*/
@RestController
@RequestMapping("/data")
public class DataController {
    @Resource
    private DataService dataService;

    @PostMapping("/listSentiDataByTime")
    public Result getDataByTime(@RequestParam("collectionId") int collectionId,@RequestParam("beginDate") String beginDateStr,@RequestParam("endDate") String endDateStr){
        return ResultGenerator.genSuccessResult(
                dataService.getDataByTime(collectionId, beginDateStr, endDateStr));
    }

    @PostMapping("/listDataByCollection")
    public Result getDataByVersion(@RequestParam("collectionId") int collectionId){
        return ResultGenerator.genSuccessResult(
                dataService.getDataByCollection(collectionId));
    }

    @PostMapping("/listSentiDataByVersion")
    public Result getDataByVersion(@RequestParam("collectionId") int collectionId,@RequestParam("version") String version){
        return ResultGenerator.genSuccessResult(
                dataService.getDataByVersion(collectionId, version));
    }

    @PostMapping("/listSentiDataByUsername")
    public Result getDataByUsername(@RequestParam("collectionId") int collectionId,@RequestParam("username") String username){
        return ResultGenerator.genSuccessResult(
                dataService.getDataByUsername(collectionId, username));
    }

    @PostMapping("/add")
    public Result add(Data data) {
        dataService.save(data);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        dataService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Data data) {
        dataService.update(data);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Data data = dataService.findById(id);
        return ResultGenerator.genSuccessResult(data);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Data> list = dataService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

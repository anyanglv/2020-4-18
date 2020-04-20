package com.tensquare.gathering.controller;

import com.tensquare.gathering.pojo.Gathering;
import com.tensquare.gathering.service.GatheringService;
import entity.PageResult;
import entity.ReturnResult;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/4/19
 * Time: 17:02
 * To change this template use File | Settings | File Templates.
 */
@RestController
@CrossOrigin
@RequestMapping("/gathering")
public class GatheringController {

    @Autowired
    private GatheringService gatheringService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ReturnResult findSearch(@RequestBody Map<String, String> map) {
        List<Gathering> list = gatheringService.findSearch(map);
        return new ReturnResult(StatusCode.OK, true, "查询成功", list);
    }

    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public ReturnResult findSearch(@RequestBody Map<String,String> map,@PathVariable int page,@PathVariable int size) {
        Page<Gathering> p = gatheringService.findSearch(map,page,size);
        PageResult pageResult = new PageResult((int) p.getTotalElements(),p.getContent());
        return new ReturnResult(StatusCode.OK, true, "查询成功",pageResult);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ReturnResult findAll() {
        List<Gathering> list = gatheringService.findAll();
        return new ReturnResult(StatusCode.OK, true, "查询成功", list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ReturnResult findById(@PathVariable String id) {
        Gathering Gathering = gatheringService.findById(id);
        return new ReturnResult(StatusCode.OK, true, "查询成功", Gathering);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ReturnResult add(@RequestBody Gathering Gathering) {
        gatheringService.save(Gathering);
        return new ReturnResult(StatusCode.OK, true, "添加成功");
    }

    @RequestMapping(value = "{/id}", method = RequestMethod.PUT)
    public ReturnResult update(@RequestBody Gathering Gathering, @PathVariable String id) {
        Gathering.setId(id);
        gatheringService.update(Gathering);
        return new ReturnResult(StatusCode.OK, true, "修改成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ReturnResult delete(@PathVariable String id) {
        gatheringService.deleteById(id);
        return new ReturnResult(StatusCode.OK, true, "删除成功");
    }
}

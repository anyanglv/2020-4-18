package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.ReturnResult;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/4/18
 * Time: 17:18
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @RequestMapping(method = RequestMethod.GET)
    public ReturnResult findAll() {
        List<Label> list = labelService.findAll();
        return new ReturnResult(StatusCode.OK, true, "查询成功", list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ReturnResult findById(@PathVariable String id) {
        Label label = labelService.findById(id);
        return new ReturnResult(StatusCode.OK, true, "查询成功", label);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ReturnResult add(@RequestBody Label label) {
        labelService.save(label);
        return new ReturnResult(StatusCode.OK, true, "添加成功");
    }

    @RequestMapping(value = "{/id}", method = RequestMethod.PUT)
    public ReturnResult update(@RequestBody Label label, @PathVariable String id) {
        label.setId(id);
        labelService.update(label);
        return new ReturnResult(StatusCode.OK, true, "修改成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ReturnResult delete(@PathVariable String id) {
        labelService.deleteById(id);
        return new ReturnResult(StatusCode.OK, true, "删除成功");
    }
}

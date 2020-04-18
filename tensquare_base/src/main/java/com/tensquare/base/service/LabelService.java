package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import util.IdWorker;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/4/18
 * Time: 17:05
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class LabelService {

    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll() {
        return labelDao.findAll();
    }

    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    public void save(Label label) {
        label.setId(idWorker.nextId() + "");
        labelDao.save(label);
    }

    public void update(Label label) {
        labelDao.save(label);
    }

    public void deleteById(String id) {
        labelDao.deleteById(id);
    }
}

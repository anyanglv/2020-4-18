package com.tensquare.base.service;

import com.sun.org.apache.regexp.internal.RE;
import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public List<Label> findSearch(Map<String, String> map) {
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        };
        List list = labelDao.findAll(specification);
        return list;
    }

    public Specification createSpecification(Map<String, String> map) {
        Specification specification = new Specification() {
            /**
             * @param root  代表 任何javabean
             * @param criteriaQuery 用于生成sql语句
             * @param criteriaBuilder 用于追加条件的
             * @return
             */
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList();
                if (!StringUtils.isEmpty(map.get("labelname"))) {
                    Predicate p_labelname = criteriaBuilder.like(root.get("labelname"), map.get("labelname"));
                    list.add(p_labelname);
                }
                if (!StringUtils.isEmpty(map.get("state"))) {
                    Predicate p_state = criteriaBuilder.equal(root.get("state"), map.get("state"));
                    list.add(p_state);
                }
                if (!StringUtils.isEmpty(map.get("recommend"))) {
                    Predicate p_recommend = criteriaBuilder.equal(root.get("recommend"), map.get("recommend"));
                    list.add(p_recommend);
                }
                Predicate p_count = criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
                return p_count;
            }
        };
        return specification;
    }

    public Page<Label> findSearch(Map<String, String> map, int page, int size) {
        Specification specification = createSpecification(map);
        Pageable pageable = PageRequest.of(page - 1, size);
        return labelDao.findAll(specification,pageable);
    }
}

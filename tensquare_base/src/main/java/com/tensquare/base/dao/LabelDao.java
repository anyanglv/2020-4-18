package com.tensquare.base.dao;

import com.tensquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/4/18
 * Time: 17:04
 * To change this template use File | Settings | File Templates.
 */
public interface LabelDao extends JpaRepository<Label,String> {

}

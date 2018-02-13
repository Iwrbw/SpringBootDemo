package com.ysf.demo.service;

import com.ysf.demo.entity.Area;

/**
 * Create by yangshunfan
 * 2018/2/13 20:26
 */
public interface AreaService {
    boolean deleteByPrimaryKey(Integer areaId);

    boolean insert(Area record);

    boolean insertSelective(Area record);

    Area selectByPrimaryKey(Integer areaId);

    boolean updateByPrimaryKeySelective(Area record);

    boolean updateByPrimaryKey(Area record);
}

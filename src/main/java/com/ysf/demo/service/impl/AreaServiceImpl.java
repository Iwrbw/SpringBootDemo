package com.ysf.demo.service.impl;

import com.ysf.demo.dao.AreaMapper;
import com.ysf.demo.entity.Area;
import com.ysf.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Create by yangshunfan
 * 2018/2/13 20:28
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper mapper;

    @Override
    public boolean deleteByPrimaryKey(Integer areaId) {
        return false;
    }

    @Transactional
    @Override
    public boolean insert(Area record) {
        if(record.getAreaId() != null && !"".equals(record.getAreaId())) {
            record.setCreateTime(new Date());
            record.setLastEditTime(new Date());
            try{
                int effectNum = mapper.insert(record);
                if (effectNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("输入信息不能为空");
        }
    }

    @Override
    public boolean insertSelective(Area record) {
        return false;
    }

    @Override
    public Area selectByPrimaryKey(Integer areaId) {
        return mapper.selectByPrimaryKey(areaId);
    }

    @Override
    public boolean updateByPrimaryKeySelective(Area record) {
        return false;
    }

    @Override
    public boolean updateByPrimaryKey(Area record) {
        return false;
    }
}

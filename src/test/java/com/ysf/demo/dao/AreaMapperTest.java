package com.ysf.demo.dao;


import com.ysf.demo.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Create by yangshunfan
 * 2018/2/13 17:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaMapperTest {

    @Autowired
    private AreaMapper mapper;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        Area area = new Area();
        area.setAreaName("东苑");
        area.setPriority(1);
        int temp = mapper.insert(area);
        assertEquals(1,temp);
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}
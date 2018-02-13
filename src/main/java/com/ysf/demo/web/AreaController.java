package com.ysf.demo.web;

import com.ysf.demo.entity.Area;
import com.ysf.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by yangshunfan
 * 2018/2/13 20:38
 */
@RestController
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    private Map<String,Object> insertArea(@RequestBody Area area) {
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",areaService.insert(area));
        return modelMap;
    }
}

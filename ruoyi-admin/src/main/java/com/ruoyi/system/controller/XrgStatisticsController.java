package com.ruoyi.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.XrgPurchaserecord;
import com.ruoyi.system.domain.XrgStatisticsReq;
import com.ruoyi.system.service.IXrgSellrecordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @name: xxx
 * @description: xxx
 * @param: []
 * @return: java.lang.Object
 * @throws:
 * @author: liurui
 * @create: ${data} ${time}
 */

@Controller
@RequestMapping("/system/xrgStatistics")
public class XrgStatisticsController {

    private String prefix = "system/xrgStatistics";

    @Autowired
    private IXrgSellrecordService xrgSellrecordService;

    @RequiresPermissions("system:xrgStatistics:view")
    @GetMapping()
    public String xrgStatisticsNormalCount()
    {
        return prefix + "/normalCount";
    }

    /**
     * 导出小人国入库记录列表
     */
    @RequiresPermissions("system:xrgStatistics:view")
    @GetMapping("/normalCount")
    @ResponseBody
    public AjaxResult normalCount(@RequestParam(value = "year", required = false) String year,
                                  @RequestParam(value = "month", required = false) String month,
                                  @RequestParam(value = "day", required = false) String day)
    {
        XrgStatisticsReq xrgStatisticsReq = new XrgStatisticsReq();
        if(!StringUtils.isEmpty(year)){
            xrgStatisticsReq.setYear(year);
        }
        if(!StringUtils.isEmpty(month)){
            xrgStatisticsReq.setMonth(month);
        }
        if(!StringUtils.isEmpty(day)){
            xrgStatisticsReq.setDay(day);
        }
        List<JSONObject> list = xrgSellrecordService.normalCount(xrgStatisticsReq);
        if(list.isEmpty()){
            return AjaxResult.error("查询失败");
        }
        else{
            JSONObject object = list.get(0);
            return AjaxResult.success(object);
        }
    }

}

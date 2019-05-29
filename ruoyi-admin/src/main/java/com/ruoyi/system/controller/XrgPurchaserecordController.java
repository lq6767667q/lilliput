package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.XrgPurchaserecord;
import com.ruoyi.system.service.IXrgPurchaserecordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 小人国入库记录 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-05-29
 */
@Controller
@RequestMapping("/system/xrgPurchaserecord")
public class XrgPurchaserecordController extends BaseController
{
    private String prefix = "system/xrgPurchaserecord";
	
	@Autowired
	private IXrgPurchaserecordService xrgPurchaserecordService;
	
	@RequiresPermissions("system:xrgPurchaserecord:view")
	@GetMapping()
	public String xrgPurchaserecord()
	{
	    return prefix + "/xrgPurchaserecord";
	}
	
	/**
	 * 查询小人国入库记录列表
	 */
	@RequiresPermissions("system:xrgPurchaserecord:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(XrgPurchaserecord xrgPurchaserecord)
	{
		startPage();
        List<XrgPurchaserecord> list = xrgPurchaserecordService.selectXrgPurchaserecordList(xrgPurchaserecord);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出小人国入库记录列表
	 */
	@RequiresPermissions("system:xrgPurchaserecord:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XrgPurchaserecord xrgPurchaserecord)
    {
    	List<XrgPurchaserecord> list = xrgPurchaserecordService.selectXrgPurchaserecordList(xrgPurchaserecord);
        ExcelUtil<XrgPurchaserecord> util = new ExcelUtil<XrgPurchaserecord>(XrgPurchaserecord.class);
        return util.exportExcel(list, "xrgPurchaserecord");
    }
	
	/**
	 * 新增小人国入库记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存小人国入库记录
	 */
	@RequiresPermissions("system:xrgPurchaserecord:add")
	@Log(title = "小人国入库记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(XrgPurchaserecord xrgPurchaserecord)
	{		
		return toAjax(xrgPurchaserecordService.insertXrgPurchaserecord(xrgPurchaserecord));
	}

	/**
	 * 修改小人国入库记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		XrgPurchaserecord xrgPurchaserecord = xrgPurchaserecordService.selectXrgPurchaserecordById(id);
		mmap.put("xrgPurchaserecord", xrgPurchaserecord);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存小人国入库记录
	 */
	@RequiresPermissions("system:xrgPurchaserecord:edit")
	@Log(title = "小人国入库记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(XrgPurchaserecord xrgPurchaserecord)
	{		
		return toAjax(xrgPurchaserecordService.updateXrgPurchaserecord(xrgPurchaserecord));
	}
	
	/**
	 * 删除小人国入库记录
	 */
	@RequiresPermissions("system:xrgPurchaserecord:remove")
	@Log(title = "小人国入库记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(xrgPurchaserecordService.deleteXrgPurchaserecordByIds(ids));
	}
	
}

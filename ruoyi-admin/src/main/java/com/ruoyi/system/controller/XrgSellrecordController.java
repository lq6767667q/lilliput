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
import com.ruoyi.system.domain.XrgSellrecord;
import com.ruoyi.system.service.IXrgSellrecordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 出库记录 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-05-28
 */
@Controller
@RequestMapping("/system/xrgSellrecord")
public class XrgSellrecordController extends BaseController
{
    private String prefix = "system/xrgSellrecord";
	
	@Autowired
	private IXrgSellrecordService xrgSellrecordService;
	
	@RequiresPermissions("system:xrgSellrecord:view")
	@GetMapping()
	public String xrgSellrecord()
	{
	    return prefix + "/xrgSellrecord";
	}
	
	/**
	 * 查询出库记录列表
	 */
	@RequiresPermissions("system:xrgSellrecord:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(XrgSellrecord xrgSellrecord)
	{
		startPage();
        List<XrgSellrecord> list = xrgSellrecordService.selectXrgSellrecordList(xrgSellrecord);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出出库记录列表
	 */
	@RequiresPermissions("system:xrgSellrecord:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XrgSellrecord xrgSellrecord)
    {
    	List<XrgSellrecord> list = xrgSellrecordService.selectXrgSellrecordList(xrgSellrecord);
        ExcelUtil<XrgSellrecord> util = new ExcelUtil<XrgSellrecord>(XrgSellrecord.class);
        return util.exportExcel(list, "xrgSellrecord");
    }
	
	/**
	 * 新增出库记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存出库记录
	 */
	@RequiresPermissions("system:xrgSellrecord:add")
	@Log(title = "出库记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(XrgSellrecord xrgSellrecord)
	{		
		return toAjax(xrgSellrecordService.insertXrgSellrecord(xrgSellrecord));
	}

	/**
	 * 修改出库记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		XrgSellrecord xrgSellrecord = xrgSellrecordService.selectXrgSellrecordById(id);
		mmap.put("xrgSellrecord", xrgSellrecord);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存出库记录
	 */
	@RequiresPermissions("system:xrgSellrecord:edit")
	@Log(title = "出库记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(XrgSellrecord xrgSellrecord)
	{		
		return toAjax(xrgSellrecordService.updateXrgSellrecord(xrgSellrecord));
	}
	
	/**
	 * 删除出库记录
	 */
	@RequiresPermissions("system:xrgSellrecord:remove")
	@Log(title = "出库记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(xrgSellrecordService.deleteXrgSellrecordByIds(ids));
	}

	/**
	 * 退货
	 */
	@RequiresPermissions("system:xrgSellrecord:back")
	@Log(title = "退货", businessType = BusinessType.DELETE)
	@PostMapping( "/back")
	@ResponseBody
	public AjaxResult back(String id)
	{
		return toAjax(xrgSellrecordService.back(id));
	}
	
}

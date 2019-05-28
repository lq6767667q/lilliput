package com.ruoyi.system.controller;

import java.util.Date;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.XrgStore;
import com.ruoyi.system.service.IXrgStoreService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 小人国库存 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-05-27
 */
@Controller
@RequestMapping("/system/xrgStore")
public class XrgStoreController extends BaseController
{
    private String prefix = "system/xrgStore";
	
	@Autowired
	private IXrgStoreService xrgStoreService;
	
	@RequiresPermissions("system:xrgStore:view")
	@GetMapping()
	public String xrgStore()
	{
	    return prefix + "/xrgStore";
	}
	
	/**
	 * 查询小人国库存列表
	 */
	@RequiresPermissions("system:xrgStore:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(XrgStore xrgStore)
	{
		startPage();
        List<XrgStore> list = xrgStoreService.selectXrgStoreList(xrgStore);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出小人国库存列表
	 */
	@RequiresPermissions("system:xrgStore:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XrgStore xrgStore)
    {
    	List<XrgStore> list = xrgStoreService.selectXrgStoreList(xrgStore);
        ExcelUtil<XrgStore> util = new ExcelUtil<XrgStore>(XrgStore.class);
        return util.exportExcel(list, "xrgStore");
    }
	
	/**
	 * 新增小人国库存
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存小人国库存
	 */
	@RequiresPermissions("system:xrgStore:add")
	@Log(title = "小人国库存", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(XrgStore xrgStore)
	{
		return toAjax(xrgStoreService.insertXrgStore(xrgStore));
	}

	/**
	 * 修改小人国库存
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		XrgStore xrgStore = xrgStoreService.selectXrgStoreById(id);
		mmap.put("xrgStore", xrgStore);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存小人国库存
	 */
	@RequiresPermissions("system:xrgStore:edit")
	@Log(title = "小人国库存", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(XrgStore xrgStore)
	{		
		return toAjax(xrgStoreService.updateXrgStore(xrgStore));
	}
	
	/**
	 * 删除小人国库存
	 */
	@RequiresPermissions("system:xrgStore:remove")
	@Log(title = "小人国库存", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(xrgStoreService.deleteXrgStoreByIds(ids));
	}


    /**
     * 小人国库存出库
     */
    @GetMapping("/sell/{id}")
    public String sell(@PathVariable("id") String id, ModelMap mmap)
    {
        XrgStore xrgStore = xrgStoreService.selectXrgStoreById(id);
        mmap.put("xrgStore", xrgStore);
        return prefix + "/sell";
    }

    /**
     * 小人国库存补货
     */
    @GetMapping("/addin/{id}")
    public String addin(@PathVariable("id") String id, ModelMap mmap)
    {
        XrgStore xrgStore = xrgStoreService.selectXrgStoreById(id);
        mmap.put("xrgStore", xrgStore);
        return prefix + "/addin";
    }

    /**
     * 小人国库存出库
     */
    @RequiresPermissions("system:xrgStore:sell")
    @Log(title = "小人国库存出库", businessType = BusinessType.UPDATE)
    @PostMapping("/sell")
    @ResponseBody
    public AjaxResult sell(XrgStore xrgStore, @RequestParam("sellnum") String sellnum, @RequestParam("sellprice") String sellprice)
    {
        int sellnumInt = Integer.parseInt(sellnum);
        xrgStore = xrgStoreService.selectXrgStoreById(xrgStore.getId()+"");
        if(xrgStore!=null){
            int remainCount = xrgStore.getCount()-sellnumInt;
            if(remainCount < 0){
                return AjaxResult.error("出库量大于库存数，操作失败");
            }
            xrgStore.setSellCount(xrgStore.getSellCount()+sellnumInt);
            xrgStore.setCount(remainCount);
            xrgStoreService.sell(xrgStore, sellnumInt, sellprice);
        }
        else{
            return AjaxResult.error("未找到id对应的数据");
        }
        return AjaxResult.success();
    }

    /**
     * 小人国库存补货
     */
    @RequiresPermissions("system:xrgStore:addin")
    @Log(title = "小人国库存补货", businessType = BusinessType.UPDATE)
    @PostMapping("/addin")
    @ResponseBody
    public AjaxResult addin(XrgStore xrgStore, @RequestParam("addinnum") String addinnum)
    {
        int addinnumInt = Integer.parseInt(addinnum);
        xrgStore = xrgStoreService.selectXrgStoreById(xrgStore.getId()+"");
        if(xrgStore!=null){
            xrgStore.setPurchaseCount(xrgStore.getPurchaseCount()+addinnumInt);
            xrgStore.setCount(xrgStore.getCount()+addinnumInt);
            xrgStoreService.updateXrgStore(xrgStore);
        }
        else{
            return AjaxResult.error("未找到id对应的数据");
        }
        return AjaxResult.success();
    }
	
}

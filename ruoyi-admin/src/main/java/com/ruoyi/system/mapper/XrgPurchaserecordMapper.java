package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.XrgPurchaserecord;
import java.util.List;	

/**
 * 小人国入库记录 数据层
 * 
 * @author ruoyi
 * @date 2019-05-29
 */
public interface XrgPurchaserecordMapper 
{
	/**
     * 查询小人国入库记录信息
     * 
     * @param id 小人国入库记录ID
     * @return 小人国入库记录信息
     */
	public XrgPurchaserecord selectXrgPurchaserecordById(Integer id);
	
	/**
     * 查询小人国入库记录列表
     * 
     * @param xrgPurchaserecord 小人国入库记录信息
     * @return 小人国入库记录集合
     */
	public List<XrgPurchaserecord> selectXrgPurchaserecordList(XrgPurchaserecord xrgPurchaserecord);
	
	/**
     * 新增小人国入库记录
     * 
     * @param xrgPurchaserecord 小人国入库记录信息
     * @return 结果
     */
	public int insertXrgPurchaserecord(XrgPurchaserecord xrgPurchaserecord);
	
	/**
     * 修改小人国入库记录
     * 
     * @param xrgPurchaserecord 小人国入库记录信息
     * @return 结果
     */
	public int updateXrgPurchaserecord(XrgPurchaserecord xrgPurchaserecord);
	
	/**
     * 删除小人国入库记录
     * 
     * @param id 小人国入库记录ID
     * @return 结果
     */
	public int deleteXrgPurchaserecordById(Integer id);
	
	/**
     * 批量删除小人国入库记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteXrgPurchaserecordByIds(String[] ids);
	
}
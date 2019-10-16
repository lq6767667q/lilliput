package com.ruoyi.system.service;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.domain.XrgSellrecord;
import com.ruoyi.system.domain.XrgStatisticsReq;

import java.util.HashMap;
import java.util.List;

/**
 * 出库记录 服务层
 * 
 * @author ruoyi
 * @date 2019-05-28
 */
public interface IXrgSellrecordService 
{
	/**
     * 查询出库记录信息
     * 
     * @param id 出库记录ID
     * @return 出库记录信息
     */
	public XrgSellrecord selectXrgSellrecordById(Integer id);
	
	/**
     * 查询出库记录列表
     * 
     * @param xrgSellrecord 出库记录信息
     * @return 出库记录集合
     */
	public List<XrgSellrecord> selectXrgSellrecordList(XrgSellrecord xrgSellrecord);
	
	/**
     * 新增出库记录
     * 
     * @param xrgSellrecord 出库记录信息
     * @return 结果
     */
	public int insertXrgSellrecord(XrgSellrecord xrgSellrecord);
	
	/**
     * 修改出库记录
     * 
     * @param xrgSellrecord 出库记录信息
     * @return 结果
     */
	public int updateXrgSellrecord(XrgSellrecord xrgSellrecord);
		
	/**
     * 删除出库记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteXrgSellrecordByIds(String ids);

	public int back(String id);

	List<JSONObject> normalCount(XrgStatisticsReq xrgStatisticsReq );
	
}

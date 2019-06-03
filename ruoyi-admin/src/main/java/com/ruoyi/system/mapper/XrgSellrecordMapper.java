package com.ruoyi.system.mapper;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.domain.XrgSellrecord;
import com.ruoyi.system.domain.XrgStatisticsReq;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * 出库记录 数据层
 * 
 * @author ruoyi
 * @date 2019-05-28
 */
public interface XrgSellrecordMapper 
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
     * 删除出库记录
     * 
     * @param id 出库记录ID
     * @return 结果
     */
	public int deleteXrgSellrecordById(Integer id);
	
	/**
     * 批量删除出库记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteXrgSellrecordByIds(String[] ids);

	List<JSONObject> normalCount(XrgStatisticsReq xrgStatisticsReq);
}
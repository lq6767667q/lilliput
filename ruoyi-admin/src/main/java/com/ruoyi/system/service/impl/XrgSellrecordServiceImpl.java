package com.ruoyi.system.service.impl;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.domain.XrgStatisticsReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XrgSellrecordMapper;
import com.ruoyi.system.domain.XrgSellrecord;
import com.ruoyi.system.service.IXrgSellrecordService;
import com.ruoyi.common.core.text.Convert;

/**
 * 出库记录 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-28
 */
@Service
public class XrgSellrecordServiceImpl implements IXrgSellrecordService 
{
	@Autowired
	private XrgSellrecordMapper xrgSellrecordMapper;

	/**
     * 查询出库记录信息
     * 
     * @param id 出库记录ID
     * @return 出库记录信息
     */
    @Override
	public XrgSellrecord selectXrgSellrecordById(Integer id)
	{
	    return xrgSellrecordMapper.selectXrgSellrecordById(id);
	}
	
	/**
     * 查询出库记录列表
     * 
     * @param xrgSellrecord 出库记录信息
     * @return 出库记录集合
     */
	@Override
	public List<XrgSellrecord> selectXrgSellrecordList(XrgSellrecord xrgSellrecord)
	{
	    return xrgSellrecordMapper.selectXrgSellrecordList(xrgSellrecord);
	}
	
    /**
     * 新增出库记录
     * 
     * @param xrgSellrecord 出库记录信息
     * @return 结果
     */
	@Override
	public int insertXrgSellrecord(XrgSellrecord xrgSellrecord)
	{
	    return xrgSellrecordMapper.insertXrgSellrecord(xrgSellrecord);
	}
	
	/**
     * 修改出库记录
     * 
     * @param xrgSellrecord 出库记录信息
     * @return 结果
     */
	@Override
	public int updateXrgSellrecord(XrgSellrecord xrgSellrecord)
	{
	    return xrgSellrecordMapper.updateXrgSellrecord(xrgSellrecord);
	}

	/**
     * 删除出库记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteXrgSellrecordByIds(String ids)
	{
		return xrgSellrecordMapper.deleteXrgSellrecordByIds(Convert.toStrArray(ids));
	}


	@Override
	public List<JSONObject> normalCount(XrgStatisticsReq xrgStatisticsReq ) {
		return xrgSellrecordMapper.normalCount(xrgStatisticsReq);
	}
}

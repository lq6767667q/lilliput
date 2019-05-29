package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XrgPurchaserecordMapper;
import com.ruoyi.system.domain.XrgPurchaserecord;
import com.ruoyi.system.service.IXrgPurchaserecordService;
import com.ruoyi.common.core.text.Convert;

/**
 * 小人国入库记录 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-29
 */
@Service
public class XrgPurchaserecordServiceImpl implements IXrgPurchaserecordService 
{
	@Autowired
	private XrgPurchaserecordMapper xrgPurchaserecordMapper;

	/**
     * 查询小人国入库记录信息
     * 
     * @param id 小人国入库记录ID
     * @return 小人国入库记录信息
     */
    @Override
	public XrgPurchaserecord selectXrgPurchaserecordById(Integer id)
	{
	    return xrgPurchaserecordMapper.selectXrgPurchaserecordById(id);
	}
	
	/**
     * 查询小人国入库记录列表
     * 
     * @param xrgPurchaserecord 小人国入库记录信息
     * @return 小人国入库记录集合
     */
	@Override
	public List<XrgPurchaserecord> selectXrgPurchaserecordList(XrgPurchaserecord xrgPurchaserecord)
	{
	    return xrgPurchaserecordMapper.selectXrgPurchaserecordList(xrgPurchaserecord);
	}
	
    /**
     * 新增小人国入库记录
     * 
     * @param xrgPurchaserecord 小人国入库记录信息
     * @return 结果
     */
	@Override
	public int insertXrgPurchaserecord(XrgPurchaserecord xrgPurchaserecord)
	{
	    return xrgPurchaserecordMapper.insertXrgPurchaserecord(xrgPurchaserecord);
	}
	
	/**
     * 修改小人国入库记录
     * 
     * @param xrgPurchaserecord 小人国入库记录信息
     * @return 结果
     */
	@Override
	public int updateXrgPurchaserecord(XrgPurchaserecord xrgPurchaserecord)
	{
	    return xrgPurchaserecordMapper.updateXrgPurchaserecord(xrgPurchaserecord);
	}

	/**
     * 删除小人国入库记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteXrgPurchaserecordByIds(String ids)
	{
		return xrgPurchaserecordMapper.deleteXrgPurchaserecordByIds(Convert.toStrArray(ids));
	}
	
}

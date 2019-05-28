package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.system.domain.XrgSellrecord;
import com.ruoyi.system.service.IXrgSellrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XrgStoreMapper;
import com.ruoyi.system.domain.XrgStore;
import com.ruoyi.system.service.IXrgStoreService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 小人国库存 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-27
 */
@Service
public class XrgStoreServiceImpl implements IXrgStoreService 
{
	@Autowired
	private XrgStoreMapper xrgStoreMapper;

	@Autowired
	private IXrgSellrecordService xrgSellrecordService;

	/**
     * 查询小人国库存信息
     * 
     * @param id 小人国库存ID
     * @return 小人国库存信息
     */
    @Override
	public XrgStore selectXrgStoreById(String id)
	{
	    return xrgStoreMapper.selectXrgStoreById(id);
	}
	
	/**
     * 查询小人国库存列表
     * 
     * @param xrgStore 小人国库存信息
     * @return 小人国库存集合
     */
	@Override
	public List<XrgStore> selectXrgStoreList(XrgStore xrgStore)
	{
	    return xrgStoreMapper.selectXrgStoreList(xrgStore);
	}
	
    /**
     * 新增小人国库存
     * 
     * @param xrgStore 小人国库存信息
     * @return 结果
     */
	@Override
	public int insertXrgStore(XrgStore xrgStore)
	{
        xrgStore.setSellCount(0);
        xrgStore.setCount(xrgStore.getPurchaseCount());
	    return xrgStoreMapper.insertXrgStore(xrgStore);
	}
	
	/**
     * 修改小人国库存
     * 
     * @param xrgStore 小人国库存信息
     * @return 结果
     */
	@Override
	public int updateXrgStore(XrgStore xrgStore)
	{
	    return xrgStoreMapper.updateXrgStore(xrgStore);
	}

	/**
     * 删除小人国库存对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteXrgStoreByIds(String ids)
	{
		return xrgStoreMapper.deleteXrgStoreByIds(Convert.toStrArray(ids));
	}

    @Override
	@Transactional
    public int sell(XrgStore xrgStore, int sellnumInt, String sellprice) {
		int updateFlag = xrgStoreMapper.updateXrgStore(xrgStore);
		if(updateFlag>=0){
			XrgSellrecord xrgSellrecord = new XrgSellrecord();
			xrgSellrecord.setItemNumber(xrgStore.getItemNumber());
			xrgSellrecord.setSupplier(xrgStore.getSupplier());
			xrgSellrecord.setSupplierAddress(xrgStore.getSupplierAddress());
			xrgSellrecord.setSize(xrgStore.getSize());
			xrgSellrecord.setStoreNumber(xrgStore.getStoreNumber());
			xrgSellrecord.setSellCount(sellnumInt);
			xrgSellrecord.setSellPrice(sellprice);
			xrgSellrecord.setSelltime(new Date());
			return xrgSellrecordService.insertXrgSellrecord(xrgSellrecord);
		}
		return -1;
    }
}

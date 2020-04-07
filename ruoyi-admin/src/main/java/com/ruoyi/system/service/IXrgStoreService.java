package com.ruoyi.system.service;

import com.ruoyi.system.domain.XrgStore;
import java.util.List;

/**
 * 小人国库存 服务层
 * 
 * @author ruoyi
 * @date 2019-05-27
 */
public interface IXrgStoreService 
{
	/**
     * 查询小人国库存信息
     * 
     * @param id 小人国库存ID
     * @return 小人国库存信息
     */
	public XrgStore selectXrgStoreById(String id);
	
	/**
     * 查询小人国库存列表
     * 
     * @param xrgStore 小人国库存信息
     * @return 小人国库存集合
     */
	public List<XrgStore> selectXrgStoreList(XrgStore xrgStore);
	
	/**
     * 新增小人国库存
     * 
     * @param xrgStore 小人国库存信息
     * @return 结果
     */
	public int insertXrgStore(XrgStore xrgStore);
	
	/**
     * 修改小人国库存
     * 
     * @param xrgStore 小人国库存信息
     * @return 结果
     */
	public int updateXrgStore(XrgStore xrgStore);
		
	/**
     * 删除小人国库存信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteXrgStoreByIds(String ids);


    /**
     * 出库
     */
	public int sell(XrgStore xrgStore, int sellnumInt, String sellprice, String sellsize, String payType);

    /**
     * 补货
     */
	public int addin(XrgStore xrgStore, int addinnumInt);
}

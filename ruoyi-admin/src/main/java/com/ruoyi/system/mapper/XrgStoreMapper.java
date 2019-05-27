package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.XrgStore;
import java.util.List;	

/**
 * 小人国库存 数据层
 * 
 * @author ruoyi
 * @date 2019-05-27
 */
public interface XrgStoreMapper 
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
     * 删除小人国库存
     * 
     * @param id 小人国库存ID
     * @return 结果
     */
	public int deleteXrgStoreById(String id);
	
	/**
     * 批量删除小人国库存
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteXrgStoreByIds(String[] ids);
	
}
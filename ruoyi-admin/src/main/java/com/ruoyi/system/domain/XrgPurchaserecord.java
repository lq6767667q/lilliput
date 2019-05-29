package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 小人国入库记录表 xrg_purchaserecord
 * 
 * @author ruoyi
 * @date 2019-05-29
 */
public class XrgPurchaserecord extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Integer id;
	/** 出库时间 */
	private Date purchasetime;
	/** 供应商 */
	private String supplier;
	/** 供应商地址 */
	private String supplierAddress;
	/** 货号 */
	private String itemNumber;
	/** 货架号 */
	private String storeNumber;
	/** 码数 */
	private String size;
	/** 进价 */
	private String purchasePrice;
	/** 入库数量 */
	private Integer count;


	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setPurchasetime(Date purchasetime) 
	{
		this.purchasetime = purchasetime;
	}

	public Date getPurchasetime() 
	{
		return purchasetime;
	}
	public void setSupplier(String supplier) 
	{
		this.supplier = supplier;
	}

	public String getSupplier() 
	{
		return supplier;
	}
	public void setSupplierAddress(String supplierAddress) 
	{
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierAddress() 
	{
		return supplierAddress;
	}
	public void setItemNumber(String itemNumber) 
	{
		this.itemNumber = itemNumber;
	}

	public String getItemNumber() 
	{
		return itemNumber;
	}
	public void setStoreNumber(String storeNumber) 
	{
		this.storeNumber = storeNumber;
	}

	public String getStoreNumber() 
	{
		return storeNumber;
	}
	public void setSize(String size) 
	{
		this.size = size;
	}

	public String getSize() 
	{
		return size;
	}
	public void setPurchasePrice(String purchasePrice) 
	{
		this.purchasePrice = purchasePrice;
	}

	public String getPurchasePrice() 
	{
		return purchasePrice;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("purchasetime", getPurchasetime())
            .append("supplier", getSupplier())
            .append("supplierAddress", getSupplierAddress())
            .append("itemNumber", getItemNumber())
            .append("storeNumber", getStoreNumber())
            .append("size", getSize())
            .append("purchasePrice", getPurchasePrice())
            .toString();
    }
}

package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 小人国库存表 xrg_store
 * 
 * @author ruoyi
 * @date 2019-05-27
 */
public class XrgStore extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/**  */
	private Date addtime;
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
	/** 历史进货数 */
	private Integer purchaseCount;
	/** 历史出货数 */
	private Integer sellCount;
	/** 余量 */
	private Integer count;
	/** 进价 */
	private String purchasePrice;
	/** 定价 */
	private String setPrice;
	/** 定价 */
	private String cat;

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId()
	{
		return id;
	}
	public void setAddtime(Date addtime) 
	{
		this.addtime = addtime;
	}

	public Date getAddtime() 
	{
		return addtime;
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
	public void setSize(String size) 
	{
		this.size = size;
	}

	public String getSize() 
	{
		return size;
	}
	public void setPurchaseCount(Integer purchaseCount) 
	{
		this.purchaseCount = purchaseCount;
	}

	public Integer getPurchaseCount() 
	{
		return purchaseCount;
	}
	public void setSellCount(Integer sellCount) 
	{
		this.sellCount = sellCount;
	}

	public Integer getSellCount() 
	{
		return sellCount;
	}
	public void setCount(Integer count) 
	{
		this.count = count;
	}

	public Integer getCount() 
	{
		return count;
	}
	public void setPurchasePrice(String purchasePrice) 
	{
		this.purchasePrice = purchasePrice;
	}

	public String getPurchasePrice() 
	{
		return purchasePrice;
	}
	public void setSetPrice(String setPrice) 
	{
		this.setPrice = setPrice;
	}

	public String getSetPrice() 
	{
		return setPrice;
	}

    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("addtime", getAddtime())
            .append("supplier", getSupplier())
            .append("supplierAddress", getSupplierAddress())
            .append("itemNumber", getItemNumber())
            .append("size", getSize())
            .append("purchaseCount", getPurchaseCount())
            .append("sellCount", getSellCount())
            .append("count", getCount())
            .append("purchasePrice", getPurchasePrice())
            .append("setPrice", getSetPrice())
            .append("cat", getCat())
            .toString();
    }
}

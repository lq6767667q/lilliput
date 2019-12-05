package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.persistence.Transient;
import java.util.Date;

/**
 * 出库记录表 xrg_sellrecord
 * 
 * @author ruoyi
 * @date 2019-05-28
 */
public class XrgSellrecord extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Integer id;
	/** 出库时间 */
	private Date selltime;
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
	/** 出库数 */
	private Integer sellCount;
	/** 出库价 */
	private String sellPrice;
	/** 定价 */
	private String setPrice;
	/** 类别 */
	private String cat;
	/** storeid */
	private Integer storeid;

	@Transient
	private String purchasePrice;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setSelltime(Date selltime) 
	{
		this.selltime = selltime;
	}

	public Date getSelltime() 
	{
		return selltime;
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
	public void setSellCount(Integer sellCount) 
	{
		this.sellCount = sellCount;
	}

	public Integer getSellCount() 
	{
		return sellCount;
	}

	public String getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
	}

    public String getSetPrice() {
        return setPrice;
    }

    public void setSetPrice(String setPrice) {
        this.setPrice = setPrice;
    }

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}


	public Integer getStoreid() {
		return storeid;
	}

	public void setStoreid(Integer storeid) {
		this.storeid = storeid;
	}

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("selltime", getSelltime())
            .append("supplier", getSupplier())
            .append("supplierAddress", getSupplierAddress())
            .append("itemNumber", getItemNumber())
            .append("storeNumber", getStoreNumber())
            .append("size", getSize())
            .append("sellCount", getSellCount())
            .append("cat", getCat())
            .append("storeid", getStoreid())
            .toString();
    }
}

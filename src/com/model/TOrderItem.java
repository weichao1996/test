package com.model;

/**
 * TOrderItem generated by MyEclipse Persistence Tools
 */

public class TOrderItem implements java.io.Serializable
{

	private Integer orderItemId;
	private Integer orderId;
	private Integer goodsId;
	private Integer goodsQuantity;
	
	private String zt;//因为是注册的店铺可以发布图书。这里设置zt，已受理和未受理
	
	private TGoods goods;//表里没有。自己加的
	private TOrder order;

	public Integer getOrderItemId()
	{
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId)
	{
		this.orderItemId = orderItemId;
	}

	public Integer getOrderId()
	{
		return orderId;
	}

	public void setOrderId(Integer orderId)
	{
		this.orderId = orderId;
	}

	public Integer getGoodsId()
	{
		return goodsId;
	}

	public void setGoodsId(Integer goodsId)
	{
		this.goodsId = goodsId;
	}

	public Integer getGoodsQuantity()
	{
		return goodsQuantity;
	}

	public void setGoodsQuantity(Integer goodsQuantity)
	{
		this.goodsQuantity = goodsQuantity;
	}

	public String getZt()
	{
		return zt;
	}

	public TOrder getOrder()
	{
		return order;
	}

	public void setOrder(TOrder order)
	{
		this.order = order;
	}

	public void setZt(String zt)
	{
		this.zt = zt;
	}

	public TGoods getGoods()
	{
		return goods;
	}

	public void setGoods(TGoods goods)
	{
		this.goods = goods;
	}

}
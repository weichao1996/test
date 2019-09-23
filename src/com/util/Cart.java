package com.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.model.TGoods;
import com.model.TOrderItem;

public class Cart
{

	protected Map<Integer, TOrderItem> items;//集合类 键是goodsId 值是TOrderItem

	public Cart()
	{

		if (items == null)
		{
			items = new HashMap<Integer, TOrderItem>();
		}
	}

	public void addGoods(Integer goodsId, TOrderItem orderItem)//添加商品 更新订单map
	{

		if (items.containsKey(goodsId))
		{

			TOrderItem _orderitem = items.get(goodsId);
			_orderitem.setGoodsQuantity(_orderitem.getGoodsQuantity()+ orderItem.getGoodsQuantity());
			items.put(goodsId, _orderitem);
		} else
		{

			items.put(goodsId, orderItem);
		}
	}
	
	public void delGoods(Integer goodsId)
	{
		items.remove(goodsId);
	}
	

	public void updateCart(Integer goodsId, int quantity)
	{

		TOrderItem orderItem = items.get(goodsId);
		orderItem.setGoodsQuantity(quantity);
		items.put(goodsId, orderItem);
	}

	public int getTotalPrice()
	{

		int totalPrice = 0;
		for (Iterator it = items.values().iterator(); it.hasNext();)//迭代器
		{

			TOrderItem orderItem = (TOrderItem) it.next();
			TGoods goods = orderItem.getGoods();
			int quantity = orderItem.getGoodsQuantity();
			totalPrice += goods.getGoodsTejia() * quantity;
		}
		return totalPrice;
	}

	public Map<Integer, TOrderItem> getItems()
	{
		return items;
	}

}

package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dao.TCatelogDAO;
import com.dao.TGoodsDAO;
import com.dao.TOrderDAO;
import com.dao.TOrderItemDAO;


import com.model.TGoods;
import com.model.TOrderItem;

import com.model.TUser;
import com.opensymphony.xwork2.ActionSupport;

public class xiaoshouAction extends ActionSupport
{
	private TOrderItemDAO orderItemDAO;
	private TGoodsDAO goodsDAO;
	private TOrderDAO orderDAO;
	private int type;
	private int orderItemId;

	
	private String message;
	private String path;
	public String xiaoshouMine()
	{
		Map session= ServletActionContext.getContext().getSession();

	    String sql="from TOrderItem  order by zt";
	    List orderItemList=orderItemDAO.getHibernateTemplate().find(sql);
	    for(int i=0;i<orderItemList.size();i++)
	    {
	    	TOrderItem orderItem=(TOrderItem)orderItemList.get(i);
	    	orderItem.setOrder(orderDAO.findById(orderItem.getOrderId()));
	    	orderItem.setGoods(goodsDAO.findById(orderItem.getGoodsId()));
	    }
	    
	    System.out.println(orderItemList.size()+"**");
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("orderItemList", orderItemList);
		return ActionSupport.SUCCESS;
		
	}
	

	public String shouli()
	{	
		TOrderItem orderItem=orderItemDAO.findById(orderItemId);
		orderItem.setZt("已受理");
		
		orderItemDAO.attachDirty(orderItem);

		//修改库存
		TGoods g=goodsDAO.findById(orderItem.getGoodsId());
		g.setGoodsNum(g.getGoodsNum()-orderItem.getGoodsQuantity());
		goodsDAO.attachDirty(g);
		
		this.setMessage("受理成功");
		this.setPath("xiaoshouMine.action");
		return "succeed";
		
		
		
	}


	public TOrderItemDAO getOrderItemDAO()
	{
		return orderItemDAO;
	}


	public void setOrderItemDAO(TOrderItemDAO orderItemDAO)
	{
		this.orderItemDAO = orderItemDAO;
	}


	public TGoodsDAO getGoodsDAO()
	{
		return goodsDAO;
	}


	public void setGoodsDAO(TGoodsDAO goodsDAO)
	{
		this.goodsDAO = goodsDAO;
	}


	public TOrderDAO getOrderDAO()
	{
		return orderDAO;
	}


	public void setOrderDAO(TOrderDAO orderDAO)
	{
		this.orderDAO = orderDAO;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}


	public int getOrderItemId() {
		return orderItemId;
	}


	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	
	
}

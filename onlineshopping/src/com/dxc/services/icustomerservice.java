package com.dxc.services;

import java.util.List;

import com.dxc.pojos.customer;
import com.dxc.pojos.product;

public interface icustomerservice {
	public boolean logincustomer(customer c);
	public List<product> getallproducts();
	void addtocart(int cid,int productid);
	public boolean paybill(product p, double finalcost, int cid);
	public void addmoneytowallet(int cid, double balance);
	public double showbalance(int cid);

}

package com.dxc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.dxc.pojos.customer;
import com.dxc.pojos.product;

import com.dxc.services.customerservice;

@Controller
@RequestMapping("/views")

public class customercontroller {
	     	customerservice service=new customerservice();
	     	String message=" ";
	     	int cid;
	     	private product prod;
	     	String status=" ";
			@RequestMapping("/clogin")
			public String login(@ModelAttribute customer c,Model m)
			{   cid=c.getCustomerid();
				boolean b=service.logincustomer(c);
				if (b)
				{
					return "customeroptions";
				}
				else 
				{
					status="incorrect login credentials";
					m.addAttribute("status",status);
					return "message1";
				}
			} 
			@RequestMapping("/addtocart")
			public String addtocart(@RequestParam int productid,Model m)
			{service.addtocart(cid,productid);
			return "message";
			  
			}
			@RequestMapping("/displaylist")
			public String getallproducts(Model m)
			{
			
			List<product> list=service.getallproducts();
			m.addAttribute("list", list);
			return "displaylist";
		
		}
			@RequestMapping("/displayfromcart")
			public String displayfromcart(Model m)
			{
				List<product> list=service.displayfromcart(cid);
				m.addAttribute("list",list);
				return "displayfromcart";
			}
			@RequestMapping("/paybill")
			public String paybill(@ModelAttribute product p)
			{
				prod=p;
				return "quantitycount";
			}

			
				@RequestMapping("/quantitycount")
				public String quantitycount(@RequestParam int productquantity,Model m)
				{
					if (productquantity<prod.getProductquantity())
					{
						prod.setProductquantity(productquantity);
						m.addAttribute(productquantity);
						m.addAttribute("product",prod);
						return"displaybill";
					}
					else 
					{
						message="quantity is exceeded";
						m.addAttribute("message",message);
						return "messaget";
					}
					
				}
				@RequestMapping("/confirmpaybill")
				public String confirmpaybill(@ModelAttribute product p,@RequestParam double finalcost,Model m)
				{
					boolean b=service.paybill(p,finalcost,cid);
					if (b==true)
					{
						message="bill paid successfully";
					m.addAttribute("message",message);
					return "messaget";
						
					}
					else 
					{
						message="insufficient balance";
					m.addAttribute("message",message);
					return "messaget";
						
						
					}
				}
				@RequestMapping("/addmoneytowallet")
				public String addmoneytowallet(@RequestParam double balance,Model m)
				{
					service.addmoneytowallet(cid,balance);
					message="Successfully amount added to wallet";
					m.addAttribute("message",message);
					return"messaget";
				}
	
				@RequestMapping("/showbalance")
				public String  showbalance(Model m)
				{
					double balance1=service.showbalance(cid);
					m.addAttribute("balance",balance1);
					return "showbalance";
				
				}
}
			



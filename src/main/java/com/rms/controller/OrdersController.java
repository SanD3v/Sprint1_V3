package com.rms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rms.model.Orders;
import com.rms.service.OrdersService;
import java.util.List;

@RestController
public class OrdersController {
	@Autowired
	private OrdersService ordersService;
	
	@RequestMapping(value="/orders", method= RequestMethod.POST) 
	public Orders createOrder(@RequestBody Orders orders) {
		return ordersService.createOrders(orders);
}
	
	@RequestMapping(value="/orders", method= RequestMethod.GET) 
	public List<Orders> getAllOrders() {
		return ordersService.getAllOrders();
	}
		
	@RequestMapping(value="/orders/{ordersId}", method= RequestMethod.GET) 
	public Orders getOrdersDetailsById(@PathVariable("ordersId") int oId){
		return ordersService.getOrdersDetailsById(oId);
			
}
	
	@RequestMapping(value="/orders/{ordersId}", method= RequestMethod.POST) 
	public Orders createOrder(@PathVariable("ordersId") int oId) {
		return ordersService.getOrdersDetailsById(oId);
}
	
	@RequestMapping(value="/orders", method= RequestMethod.PUT) 
	public Orders updateOrdersDetails(@RequestBody Orders orders) {
		return ordersService.updateOrders(orders);
}
	
	@RequestMapping(value="/orders/{ordersId}", method= RequestMethod.DELETE) 
	public String deleteOrdersDetails(@PathVariable("ordersId") int oId) {
		Orders o = ordersService.getOrdersDetailsById(oId);
		if(o!=null) {
			ordersService.deleteOrdersDetailsById(oId);
			return "The Order details deleted with the orderId: "+oId;
		}
		else {
		return "The Order details not deleted with the orderId: "+oId;
}
}
		
}

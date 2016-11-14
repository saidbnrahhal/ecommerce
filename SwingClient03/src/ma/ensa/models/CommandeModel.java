package ma.ensa.models;

import java.util.List;

import ma.ensa.models.entity.CartItem;
import ma.ensa.services.interfaces.OrderService;

public class CommandeModel {
	private OrderService orderService ;
	
	public CommandeModel(ConnectionModel connectionModel) {
		this.orderService=connectionModel.getOrderService();
	}

	public List<CartItem> getAllProduct() {
		return orderService.getAllOrder();
	}
}

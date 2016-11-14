package ma.ensa.services.interfaces;

import java.util.List;

import ma.ensa.models.entity.CartItem;

public interface OrderService {

	public List<CartItem> getAllOrder();
	public void updateOrder(Long id,CartItem cartItem);
	
	
}

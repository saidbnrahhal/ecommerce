package ma.ensa.models;

import java.util.Properties;

import javax.naming.InitialContext;

import ma.ensa.services.interfaces.OrderService;
import ma.ensa.services.interfaces.ProductService;
import ma.ensa.services.interfaces.UsersService;

public class ConnectionModel {

	
	private UsersService userService ;
	private ProductService productService;
	private OrderService orderService ;
	
	public ConnectionModel() {
		connection();
	}
	public void connection(){
		try {
			  Properties props = new Properties();
			  props.setProperty("java.naming.factory.initial",
			                    "com.sun.enterprise.naming.SerialInitContextFactory");
			  props.setProperty("java.naming.factory.url.pkgs",
			                    "com.sun.enterprise.naming");
			  props.setProperty("java.naming.factory.state",
			                    "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
			  props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
			  props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
			  InitialContext ctx =new InitialContext(props);
			  setUserService((UsersService) ctx.lookup("java:global/Atlas01/UserManager"));
			  setProductService((ProductService) ctx.lookup("java:global/Atlas01/ProductManager"));
			  setOrderService((OrderService) ctx.lookup("java:global/Atlas01/OrderManager"));
			  System.out.println("cnx fi aman allah");
			
		} catch (Exception e) {
			System.out.println("kain mouchkil fi connextion");
		}
	}
	public UsersService getUserService() {
		return userService;
	}
	
	public ProductService getProductService() {

		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
		
	}
	public void setUserService(UsersService userService) {
		this.userService = userService;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
}

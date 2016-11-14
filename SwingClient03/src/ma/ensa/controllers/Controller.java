package ma.ensa.controllers;
import ma.ensa.controllers.interfaces.PageController;
import ma.ensa.models.Model;
import ma.ensa.views.View;
import ma.ensa.views.commande.CommandeTest;
import ma.ensa.views.commande.OrderPanel;
import ma.ensa.views.home.HomePanel;
import ma.ensa.views.login.ConnectionPanel;
import ma.ensa.views.product.ProductPanel;
import ma.ensa.views.product.ProductTest;
import ma.ensa.views.user.UserPanel;


public class Controller implements PageController{

	// Models
	Model model ;
	View view ;

	public Controller(Model model) {
		
		this.model=model; 
		view =new View(model,this);
		view.setVisible(true);
		homePage() ;
	}

	@Override
	public void connectPage() {
		
		ConnectionPanel homePanel = new ConnectionPanel(this) ;
		view.chargeView(homePanel,"Connection : ");
	}
	@Override
	public void homePage() {
		
		HomePanel homePanel = new HomePanel(this) ;
		view.chargeView(homePanel,"Home sweet home");

	}
	@Override
	public void userPage() {

		UserPanel userPanel =new UserPanel(model.getUserModel(), this) ;
		view.chargeView(userPanel,"Users ");
	}
	@Override
	public void productPage() {


		ProductPanel productPanel =new ProductPanel(model.getProductModel(), this) ;
		view.chargeView(productPanel,"Users ");
	}
	@Override
	public void commandePage() {

		OrderPanel orderPanel =new OrderPanel(model.getCommandeModel(),this);
		view.chargeView(orderPanel,"Commandes :");
		
	}
	
}

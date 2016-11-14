package ma.ensa.views.commande;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ma.ensa.models.entity.CartItem;

public class OrderListView extends JPanel {

	List<OneOrderPanel> oneOrderPanels;

	private List<CartItem> orderslist;
	private JPanel container;
	
	
	int numberOfItemes=0 ;
	int numberOfPages ;
	int numberOfItemesByPage= 6 ;
	int actualPage =0 ;
	OrderListViewActionListner orderListViewActionListner;
	
	public OrderListView(List<CartItem> orderslist,OrderListViewActionListner orderListViewActionListner) {
		container = new JPanel();
		this.orderslist =orderslist ;
		this.orderListViewActionListner =orderListViewActionListner;
		refrech();
	}
	public void calculateNumberOfPages(){
		
		numberOfItemes=orderslist.size();
		numberOfPages =(int) numberOfItemes/numberOfItemesByPage ;
		int restItems =numberOfItemes-numberOfPages * numberOfItemesByPage ;
		
		if (restItems >0) {
			numberOfPages ++ ;
		}
		
	}
	public void nextPage(){
		
		if (actualPage< numberOfPages-1) {
			actualPage++;
			refrech();
		}
	}
	
	public void prevPage(){
		
		if (actualPage>0) {
			actualPage--;
			refrech();
		}
	}	
	public void refrech() {
		calculateNumberOfPages();
		orderListViewActionListner.sendDiscription(""+(actualPage+1)+"/"+(numberOfPages));
		container.setLayout(new GridLayout(3,2,20,20));
		container.removeAll();
		container.repaint();
		for (int i = 0; i < numberOfItemesByPage; i++) {
			int indexInArray = actualPage*numberOfItemesByPage +i;
			if (indexInArray >= numberOfItemes) {
				container.add(new JLabel(""));
			}
			else {
				CartItem order = orderslist.get(indexInArray);
				OneOrderPanel oneOrderPanel = new OneOrderPanel();

				// the id of the panel will be equal to the order of it's user in
				// userList
				oneOrderPanel.setIdLabel(order.getId()+"") ;
				oneOrderPanel.setDateLabel(order.getDate()+"");
				oneOrderPanel.setBuyerNameLabel(order.getUser().getFirstName()+" "+order.getUser().getLastName());
				oneOrderPanel.setPhoneLabel(order.getUser().getTelephone()) ;
				oneOrderPanel.setEmailLabel(order.getUser().getEmail()) ;
				oneOrderPanel.setAddressLabel(order.getAddress()) ;
				oneOrderPanel.setProductNameLabel(order.getProduct().getName());
				oneOrderPanel.setPriceLabel(order.getProduct().getPrice()+"") ;

				oneOrderPanel.setQuantityLabel(order.getQuantity()+"");
				
				oneOrderPanel.setTotalPriceLablel((order.getProduct().getPrice()*order.getQuantity())+"") ;

				oneOrderPanel.setOrderStateLabel(order.getStateOfOrder()) ;
				container.add(oneOrderPanel);
				
				}
			
		}
		container.repaint();
        container.updateUI();
        
        this.add(container);
	}


	
}

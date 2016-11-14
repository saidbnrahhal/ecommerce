package ma.ensa.views.commande;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OneOrderPanel extends JPanel {

 	private int panelId;


	private JPanel container;
	
	
	//buyer
	private JLabel idLabel;
	private JLabel dateLabel;
	private JLabel buyerNameLabel;
	private JLabel phoneLabel;
	private JLabel emailLabel;
	private JLabel addressLabel;

	//Product
	
	private JLabel productNameLabel;
	private JLabel priceLabel ;
	private JLabel quantityLabel ;
	private JLabel totalPriceLablel ;
	private JLabel orderStateLabel ;

	public OneOrderPanel() {

		intUI();

	}

	public void intUI() {

	
		 idLabel =new JLabel();
		 dateLabel=new JLabel();
		 buyerNameLabel=new JLabel();
		 phoneLabel=new JLabel();
		 emailLabel=new JLabel();
		 addressLabel=new JLabel();

		//Product
		
		 productNameLabel=new JLabel();
		 priceLabel =new JLabel();
		 quantityLabel =new JLabel();
		 totalPriceLablel=new JLabel() ;
		 orderStateLabel=new JLabel() ;
		ArrayList<JLabel> jPanels =new ArrayList<JLabel>();
		jPanels.add(idLabel);
		jPanels.add(dateLabel);
		jPanels.add(buyerNameLabel);
		jPanels.add(phoneLabel);
		jPanels.add(emailLabel);
		jPanels.add(addressLabel);
		jPanels.add(productNameLabel);
		jPanels.add(priceLabel);
		jPanels.add(quantityLabel);
		jPanels.add(totalPriceLablel);
		jPanels.add(orderStateLabel);
		
		ArrayList<String> names =new ArrayList<String>();
		names.add("id");
		names.add("date");
		names.add("buyerName");
		names.add("phone");
		names.add("email");
		names.add("address");
		names.add("productName");
		names.add("price");
		names.add("quantity");
		names.add("totalPrice");
		names.add("orderState");
		
		JPanel container =new JPanel();
		int size =names.size();
		container.setLayout(new GridLayout(size,2));
		for (int i = 0; i < names.size(); i++) {
			container.add(new JLabel(names.get(i)));
			container.add(jPanels.get(i));
		}
		container.setBorder(BorderFactory.createEtchedBorder());
		this.add(container);
	}





	public void setIdLabel(String id) {
		this.idLabel.setText(id+"");
	}

	public void setDateLabel(String date) {
		this.dateLabel .setText(date);
	}

	public void setBuyerNameLabel(String buyerName) {
		this.buyerNameLabel.setText(buyerName);
	}

	public void setPhoneLabel(String phone) {
		this.phoneLabel.setText(phone);
	}

	public void setEmailLabel(String email) {
		this.emailLabel.setText(email);
	}

	public void setAddressLabel(String address) {
		this.addressLabel.setText(address);
	}

	public void setProductNameLabel(String productName) {
		this.productNameLabel.setText(productName);
	}

	public void setPriceLabel(String price) {
		this.priceLabel.setText(price);
	}

	public void setQuantityLabel(String quantity) {
		this.quantityLabel.setText(quantity);
	}

	public void setTotalPriceLablel(String totalPrice) {
		this.totalPriceLablel.setText(totalPrice);
	}

	public void setOrderStateLabel(String orderState) {
		this.orderStateLabel.setText(orderState);
	}
	
	public int getPanelId() {
		return panelId;
	}

	public void setPanelId(int panelId) {
		this.panelId = panelId;
	}
	
}

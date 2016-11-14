package ma.ensa.views.product;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ma.ensa.models.entity.Product;

public class ProductListView extends JPanel implements OneProductActionListner {

	List<OneProductPanel> oneUserPanelList;
	private ProductListViewActionListner productListViewActionListner;
	private List<Product> productslist;
	private JPanel container;
	
	
	int numberOfItemes=0 ;
	int numberOfPages ;
	int numberOfItemesByPage= 4 ;
	int actualPage =0 ;
	
	public ProductListView(List<Product> productslist,ProductListViewActionListner productListViewActionListner) {
		container = new JPanel();
		this.productslist =productslist ;
		this.productListViewActionListner =productListViewActionListner ;
		refrech();
	}
	public void calculateNumberOfPages(){
		
		numberOfItemes=productslist.size();
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
	
	public Long userIdFromPanelId(int panelId){
		
		int indexInProductList  =actualPage*numberOfItemesByPage +panelId ; 
		long productId =productslist.get(indexInProductList).getId();
		return productId;
	}
	
	
	
	
	public void refrech() {
		calculateNumberOfPages();
		productListViewActionListner.sendDiscription(""+(actualPage+1)+"/"+(numberOfPages));
		container.setLayout(new GridLayout(numberOfItemesByPage,4,20,20));
		container.removeAll();
		container.repaint();
		for (int i = 0; i < numberOfItemesByPage; i++) {
			int indexInArray = actualPage*numberOfItemesByPage +i;
			if (indexInArray >= numberOfItemes) {
				container.add(new JLabel(""));
			}
			else {
				Product product = productslist.get(indexInArray);
				OneProductPanel oneProductPanel = new OneProductPanel();

				// the id of the panel will be equal to the order of it's user in
				// userList
				oneProductPanel.setPanelId(i);
				oneProductPanel.setName(product.getName());
				oneProductPanel.setQtyInstock(product.getQtyInstock());
				oneProductPanel.setAvailable(product.getAvailable());
				oneProductPanel.setPrice(product.getPrice());
				oneProductPanel.setGameGenre(product.getGameGenre());
				oneProductPanel.setImageLink("http://localhost:8080/Atlas01/DownloadServlet?id="+product.getImageLink()+"");
				oneProductPanel.setShortDiscreption(product.getShortDiscreption());
				container.add(oneProductPanel);
				oneProductPanel.setOneProductActionListner(this);
				}
			
		}
		container.repaint();
        container.updateUI();
        
        this.add(container);
	}

	@Override
	public void delete(int idPanel) {
		
		productListViewActionListner.sendTodeleting(userIdFromPanelId(idPanel));
		
	}

	@Override
	public void update(int idPanel) {
		
		productListViewActionListner.sendToupdating(userIdFromPanelId(idPanel));
	}

	
}

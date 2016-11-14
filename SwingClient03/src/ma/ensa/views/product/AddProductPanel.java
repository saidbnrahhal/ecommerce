package ma.ensa.views.product;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import ma.ensa.controllers.interfaces.ProductController;
import ma.ensa.models.entity.Category;
import ma.ensa.models.entity.Product;

public class AddProductPanel extends JPanel implements ActionListener {

	private String path ="";
	private ImagePanel imagePanel =new ImagePanel() ;
	private JTextField nameTextField = new JTextField();
	private JTextField qtyInstockTextField = new JTextField();
	
	private JTextField priceTextField = new JTextField();

	
	private JButton imageLinkButton= new JButton("image");
	private JTextField shortDiscreptionTextField= new JTextField();
	private JTextField searchDiscreptionTextField= new JTextField();
	
	private ProductController productController ;
	
	private JButton validerButton = new JButton("valider");
	private JButton annulerButton = new JButton("annuler");
	private JPanel container;

	String [] categoriesNames ={"Sport","War","Educational","Card","Logic","Racing","Strategy","Life","Fantasy","Survival" ,"Fighting" ,"Shooter" };
	private JComboBox<String> gameGenreComboBox = new JComboBox<String>(categoriesNames);
	String [] availableNames={"true","false"};
	private JComboBox<String> availableComboBox = new JComboBox<String>(availableNames);
	
	public AddProductPanel(ProductController  productController) {
		
		this.productController =productController;
		intUI();
		validerButton.addActionListener(this);
		annulerButton.addActionListener(this);
		imageLinkButton.addActionListener(this);
	}

	public void intUI() {
		container = new JPanel();
		
		JPanel container1 =new JPanel();
		container1.add(imagePanel);
		
		container1.setPreferredSize(new Dimension(250,350));
		
		JPanel container2 =new JPanel();
		container2.setLayout(new GridLayout(1,2,2,2));
		container2.add(new JLabel("ProductName"));
		container2.add(nameTextField);
		
		JPanel container3 =new JPanel();
		container3.setLayout(new GridLayout(1,2,2,2));
		container3.add(new JLabel("quantiy of the product"));
		container3.add(qtyInstockTextField);

		JPanel container4 =new JPanel();
		container4.setLayout(new GridLayout(1,2,2,2));
		container4.add(new JLabel("availabale"));
		container4.add(availableComboBox);

		JPanel container5 =new JPanel();
		container5.setLayout(new GridLayout(1,2,2,2));
		container5.add(new JLabel("Price"));
		container5.add(priceTextField);

		JPanel container6 =new JPanel();
		container6.setLayout(new GridLayout(1,2,2,2));
		container6.add(new JLabel("game Genre"));
		container6.add(gameGenreComboBox);

		JPanel container7 =new JPanel();
		container7.setLayout(new GridLayout(1,2,2,2));
		container7.add(new JLabel("image"));
		container7.add(imageLinkButton);
		
		JPanel container8 =new JPanel();
		container8.setLayout(new GridLayout(1,2,2,2));
		container8.add(new JLabel("short discr"));
		container8.add(shortDiscreptionTextField);

		JPanel container9 =new JPanel();
		container9.setLayout(new GridLayout(1,2,2,2));
		container9.add(new JLabel("search descri"));
		container9.add(searchDiscreptionTextField);
		
		
		JPanel container10 =new JPanel();
		container10.setLayout(new GridLayout(1,2,2,2));
		container10.add(validerButton);
		container10.add(annulerButton);
		container.setLayout(new GridLayout(9, 1, 20, 20));
		container.add(container2);
		container.add(container3);
		container.add(container4);
		container.add(container5);
		container.add(container6);
		container.add(container7);
		container.add(container8);
		container.add(container9);
		container.add(container10);
		
		this.setLayout(new BorderLayout());
		this.add(container1,BorderLayout.NORTH);
		this.add(container,BorderLayout.CENTER);
		container
				.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		this.add(container);
	}

	public static boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("valider")) {
			validation();
		}
		if (e.getActionCommand().equals("annuler")) {
			annulation();
		}
		if (e.getActionCommand().equals("image")) {
			praintImage();
		}

	}

	private void praintImage() {
		// TODO Auto-generated method stub
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileFilter() {
			 @Override
		        public boolean accept(File f) {
		            if (f.isDirectory()) {
		                return true;
		            }
		            final String name = f.getName();
		            return name.endsWith(".png");
		        }

		        @Override
		        public String getDescription() {
		            return "*.png";
		        }
		});
		
		
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try {
               path=file.getAbsolutePath().toString();
               imagePanel.loadImage(path);
               
            } catch (Exception em) {
            	em.printStackTrace();
            	System.out.println(em.getMessage());
            }
        }
		
	}

	public void validation() {
		
		try {
			 String name =nameTextField.getText();
			 int qtyInstock =Integer.parseInt(qtyInstockTextField.getText());
			 Boolean available =Boolean.parseBoolean(availableComboBox.getSelectedItem().toString());
			 Double price =Double.parseDouble(priceTextField.getText()) ;
			 Category  gameGenre = Category.valueOf(gameGenreComboBox.getSelectedItem().toString());
			// TODO
			 String shortDiscreption=shortDiscreptionTextField.getText();
			 String  searchDiscreption=searchDiscreptionTextField.getText();
			
			 Product product =new Product() ;
			 product.setAvailable(available);
			 product.setGameGenre(gameGenre);
			 product.setName(name);
			 product.setPrice(price);
			 product.setQtyInstock(qtyInstock);
			 product.setSearchDiscreption(searchDiscreption);
			 product.setShortDiscreption(shortDiscreption);
			 product.setImageLink(path);
			 productController.adddProduct(product);
			 
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JPanel(),
					"veriferi votre mot de passe", "mot de passe",
					JOptionPane.WARNING_MESSAGE);
		}
		
	}

	public void annulation() {
		nameTextField.setText("");
		qtyInstockTextField.setText("");
		priceTextField.setText("");
		shortDiscreptionTextField.setText("");
		searchDiscreptionTextField.setText("");
		path="";
		imagePanel.loadImage(path);
		
	}


}

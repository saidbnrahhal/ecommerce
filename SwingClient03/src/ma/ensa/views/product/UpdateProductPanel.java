package ma.ensa.views.product;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

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

public class UpdateProductPanel extends JPanel implements ActionListener {

	private String path ="";
	private ImagePanel imagePanel  ;
	private JButton imageLinkButton= new JButton("image");
	
	private JTextField nameTextField = new JTextField();
	private JTextField qtyInstockTextField = new JTextField();

	private JTextField priceTextField = new JTextField();
	
	private JTextField shortDiscreptionTextField= new JTextField();
	private JTextField searchDiscreptionTextField= new JTextField();
	
	private ProductController productController ;
	
	private JButton validerButton = new JButton("valider");
	private JButton annulerButton = new JButton("annuler");
	private JPanel container;

	private Product productIn ;
	
	String [] categoriesNames ={"Sport","War","Educational","Card","Logic","Racing","Strategy","Life","Fantasy","Survival" ,"Fighting" ,"Shooter" };
	private JComboBox<String> gameGenreComboBox = new JComboBox<String>(categoriesNames);
	String [] availableNames={"true","false"};
	private JComboBox<String> availableComboBox = new JComboBox<String>(availableNames);
	
	
	
	public UpdateProductPanel(ProductController  productController ,Product productIn) {
		
		this.productController =productController;
		validerButton.addActionListener(this);
		annulerButton.addActionListener(this);
		imageLinkButton.addActionListener(this);
		this.productIn=productIn ;
		intUI();
	}

	public void intUI() {
		container = new JPanel();
		container.setLayout(new BorderLayout());
		imagePanel =new ImagePanel() ;
		container.add(imagePanel,BorderLayout.NORTH);
		try {
			imagePanel.loadImage(new URL("http://localhost:8080/Atlas01/DownloadServlet?id="+productIn.getImageLink()));
			//http://localhost:8080/Atlas01/DownloadServlet?id="+product.getImageLink()
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JPanel container1 =new JPanel() ;
		container1.setLayout(new GridLayout(1,2,10,10));
		container1.add(new JLabel("ProductName"));
		container1.add(nameTextField);
		nameTextField.setText(productIn.getName());
		
		JPanel container2 =new JPanel() ;
		container2.setLayout(new GridLayout(1,2,10,10));
		container2.add(new JLabel("quantiy of the product"));
		container2.add(qtyInstockTextField);
		qtyInstockTextField.setText(productIn.getQtyInstock()+"");
		
		JPanel container3 =new JPanel() ;
		container3.setLayout(new GridLayout(1,2,10,10));
		container3.add(new JLabel("availabale"));
		container3.add(availableComboBox);
		availableComboBox.setSelectedItem(productIn.getAvailable());
		

		JPanel container4 =new JPanel() ;
		container4.setLayout(new GridLayout(1,2,10,10));
		container4.add(new JLabel("Price"));
		container4.add(priceTextField);
		priceTextField.setText(productIn.getPrice()+"");

		
		JPanel container5 =new JPanel() ;
		container5.setLayout(new GridLayout(1,2,10,10));
		container5.add(new JLabel("game Genre"));
		container5.add(gameGenreComboBox);
		gameGenreComboBox.setSelectedItem(productIn.getGameGenre().toString());  

		JPanel container6 =new JPanel() ;
		container6.setLayout(new GridLayout(1,2,10,10));
		container6.add(new JLabel("image"));
		container6.add(imageLinkButton);
		
		
		JPanel container7 =new JPanel() ;
		container7.setLayout(new GridLayout(1,2,10,10));
		container7.add(new JLabel("short discr"));
		container7.add(shortDiscreptionTextField);
		shortDiscreptionTextField.setText(productIn.getShortDiscreption());
		
		JPanel container8 =new JPanel() ;
		container8.setLayout(new GridLayout(1,2,10,10));
		container8.add(new JLabel("search descri"));
		container8.add(searchDiscreptionTextField);
		searchDiscreptionTextField.setText(productIn.getSearchDiscreption());
		
		
		
		JPanel container9 =new JPanel() ;
		container9.setLayout(new GridLayout(1,2,10,10));
		container9.add(validerButton);
		container9.add(annulerButton);
		
		JPanel paralelPanel =new JPanel();
		paralelPanel.setLayout(new GridLayout(8,1,20,20));
		paralelPanel.add(container1);
		paralelPanel.add(container2);
		paralelPanel.add(container3);
		paralelPanel.add(container4);
		paralelPanel.add(container5);
		paralelPanel.add(container6);
		paralelPanel.add(container7);
		paralelPanel.add(container8);
		paralelPanel.add(container9);
		
		container.add(paralelPanel,BorderLayout.CENTER);
		this.setLayout(new GridLayout(1, 1, 20, 20));
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
			 
			 String shortDiscreption=shortDiscreptionTextField.getText();
			 String  searchDiscreption=searchDiscreptionTextField.getText();
			
			 Product product =new Product() ;
			 product.setAvailable(available);
			 product.setGameGenre(gameGenre);
			 product.setImageLink(path);
			 product.setName(name);
			 product.setPrice(price);
			 product.setQtyInstock(qtyInstock);
			 product.setSearchDiscreption(searchDiscreption);
			 product.setShortDiscreption(shortDiscreption);
			 
			 productController.updateProduct(productIn.getId(), product);
			 
			
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


































//
//public class UpdateUserPanel extends JPanel implements ActionListener {
//
//	private UserController userController ;
//	
//	private JPanel container;
//	
//	private User userIn ;
//
//	private JTextField firstNameTextField = new JTextField();
//
//	private JTextField lastNameTextField = new JTextField();
//
//	private JTextField emailTextField = new JTextField();
//
//	private JPasswordField passwordTextField = new JPasswordField();
//
//	private JPasswordField passwordTextField2 = new JPasswordField();
//
//	private JButton validerButton = new JButton("valider");
//
//	private JButton annulerButton = new JButton("annuler");
//
//	private JTextField telephoneTextField = new JTextField();
//
//	private String[] types = new String[] { "Admin", "Simple user" };
//
//	private JComboBox<String> isAdminComboBox = new JComboBox<String>(types);
//
//	public UpdateUserPanel(UserController  userController,User userIn) {
//		
//		this.userController =userController;
//		this.userIn=userIn;
//		intUI();
//		validerButton.addActionListener(this);
//		annulerButton.addActionListener(this);
//		this.userIn =userIn;
//	}
//
//	public void intUI() {
//		
//		container = new JPanel();
//		container.setLayout(new GridLayout(9, 2, 20, 20));
//
//		container.add(new JLabel("first Name"));
//		container.add(firstNameTextField);
//		firstNameTextField.setText(userIn.getFirstName());
//		
//		container.add(new JLabel("last Name"));
//		container.add(lastNameTextField);
//		lastNameTextField.setText(userIn.getLastName());
//		
//		
//		container.add(new JLabel("email"));
//		container.add(emailTextField);
//		emailTextField.setText(userIn.getEmail());
//
//		container.add(new JLabel("password"));
//		container.add(passwordTextField);
//		passwordTextField.setText(userIn.getPassword());
//
//		container.add(new JLabel("password 2"));
//		container.add(passwordTextField2);
//		passwordTextField2.setText(userIn.getPassword());
//		
//		container.add(new JLabel("Telephone"));
//		container.add(telephoneTextField);
//		telephoneTextField.setText(userIn.getTelephone());
//		
//		container.add(new JLabel("Type of user"));
//		container.add(isAdminComboBox);
//		
//
//		container.add(validerButton);
//		container.add(annulerButton);
//
//		this.setLayout(new GridLayout(1, 1, 20, 20));
//		container
//				.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
//		this.add(container);
//	}
//
//	public static boolean isValidEmailAddress(String email) {
//		boolean result = true;
//		try {
//			InternetAddress emailAddr = new InternetAddress(email);
//			emailAddr.validate();
//		} catch (AddressException ex) {
//			result = false;
//		}
//		return result;
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//
//		if (e.getActionCommand().equals("valider")) {
//			validation();
//		}
//		if (e.getActionCommand().equals("annuler")) {
//			annulation();
//		}
//
//	}
//
//	public void validation() {
//		String firstName = firstNameTextField.getText();
//		String lastName = lastNameTextField.getText();
//		String email = emailTextField.getText();
//
//		char[] pass = passwordTextField.getPassword();
//		String password = new String(pass);
//
//		char[] pass2 = passwordTextField2.getPassword();
//		String password2 = new String(pass2);
//
//		String telephone = telephoneTextField.getText();
//
//		if (firstName.equals("") || lastName.equals("") || email.equals("")
//				|| password2.equals("") || password.equals("")
//				|| telephone.equals("")) {
//			System.out.println("rah chi 7aja ma 3amrach ");
//			JOptionPane.showMessageDialog(new JPanel(),
//					"des chanps qui monque", "kaina kaina",
//					JOptionPane.WARNING_MESSAGE);
//		} else if (!password2.equals(password)) {
//			JOptionPane.showMessageDialog(new JPanel(),
//					"veriferi votre mot de passe", "mot de passe",
//					JOptionPane.WARNING_MESSAGE);
//		} else if (!isValidEmailAddress(email)) {
//			JOptionPane.showMessageDialog(new JPanel(), "email", "email",
//					JOptionPane.WARNING_MESSAGE);
//		} else {
//
//			User user = new User();
//			user.setFirstName(firstName);
//			user.setLastName(lastName);
//			user.setPassword(password);
//			user.setEmail(email);
//			user.setTelephone(telephone);
//			
//			userController.updateUser(userIn.getId(), user);;
//		
//
//		}
//	}
//
//	public void annulation() {
//		firstNameTextField.setText("");
//		lastNameTextField.setText("");
//		emailTextField.setText("");
//		passwordTextField.setText("");
//		passwordTextField2.setText("");
//		telephoneTextField.setText("");
//	}
//
//}

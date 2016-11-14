package ma.ensa.views.user;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ma.ensa.controllers.interfaces.UserController;
import ma.ensa.models.entity.User;

public class UpdateUserPanel extends JPanel implements ActionListener {

	private UserController userController ;
	
	private JPanel container;
	
	private User userIn ;

	private JTextField firstNameTextField = new JTextField();

	private JTextField lastNameTextField = new JTextField();

	private JTextField emailTextField = new JTextField();

	private JPasswordField passwordTextField = new JPasswordField();

	private JPasswordField passwordTextField2 = new JPasswordField();

	private JButton validerButton = new JButton("valider");

	private JButton annulerButton = new JButton("annuler");

	private JTextField telephoneTextField = new JTextField();

	private String[] types = new String[] { "Admin", "Simple user" };

	private JComboBox<String> isAdminComboBox = new JComboBox<String>(types);

	public UpdateUserPanel(UserController  userController,User userIn) {
		
		this.userController =userController;
		this.userIn=userIn;
		intUI();
		validerButton.addActionListener(this);
		annulerButton.addActionListener(this);
		this.userIn =userIn;
	}

	public void intUI() {
		
		container = new JPanel();
		container.setLayout(new GridLayout(9, 2, 20, 20));

		container.add(new JLabel("first Name"));
		container.add(firstNameTextField);
		firstNameTextField.setText(userIn.getFirstName());
		
		container.add(new JLabel("last Name"));
		container.add(lastNameTextField);
		lastNameTextField.setText(userIn.getLastName());
		
		
		container.add(new JLabel("email"));
		container.add(emailTextField);
		emailTextField.setText(userIn.getEmail());

		container.add(new JLabel("password"));
		container.add(passwordTextField);
		passwordTextField.setText(userIn.getPassword());

		container.add(new JLabel("password 2"));
		container.add(passwordTextField2);
		passwordTextField2.setText(userIn.getPassword());
		
		container.add(new JLabel("Telephone"));
		container.add(telephoneTextField);
		telephoneTextField.setText(userIn.getTelephone());
		
		container.add(new JLabel("Type of user"));
		container.add(isAdminComboBox);
		

		container.add(validerButton);
		container.add(annulerButton);

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
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals("valider")) {
			validation();
		}
		if (e.getActionCommand().equals("annuler")) {
			annulation();
		}

	}

	public void validation() {
		String firstName = firstNameTextField.getText();
		String lastName = lastNameTextField.getText();
		String email = emailTextField.getText();

		char[] pass = passwordTextField.getPassword();
		String password = new String(pass);

		char[] pass2 = passwordTextField2.getPassword();
		String password2 = new String(pass2);

		String telephone = telephoneTextField.getText();

		if (firstName.equals("") || lastName.equals("") || email.equals("")
				|| password2.equals("") || password.equals("")
				|| telephone.equals("")) {
			System.out.println("rah chi 7aja ma 3amrach ");
			JOptionPane.showMessageDialog(new JPanel(),
					"des chanps qui monque", "kaina kaina",
					JOptionPane.WARNING_MESSAGE);
		} else if (!password2.equals(password)) {
			JOptionPane.showMessageDialog(new JPanel(),
					"veriferi votre mot de passe", "mot de passe",
					JOptionPane.WARNING_MESSAGE);
		} else if (!isValidEmailAddress(email)) {
			JOptionPane.showMessageDialog(new JPanel(), "email", "email",
					JOptionPane.WARNING_MESSAGE);
		} else {

			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setPassword(password);
			user.setEmail(email);
			user.setTelephone(telephone);
			
			userController.updateUser(userIn.getId(), user);;
		

		}
	}

	public void annulation() {
		firstNameTextField.setText("");
		lastNameTextField.setText("");
		emailTextField.setText("");
		passwordTextField.setText("");
		passwordTextField2.setText("");
		telephoneTextField.setText("");
	}

}

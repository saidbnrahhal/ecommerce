package ma.ensa.views;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MyMenuPanel extends JPanel {

	// 180
	JButton conexionButton;
	JButton loginButton;
	JButton usersButton;
	JButton productsButton;

	public MyMenuPanel() {
		this.setLayout(null);

		conexionButton = new JButton("Connexion");
		loginButton = new JButton("Login");
		usersButton = new JButton("Users");
		productsButton = new JButton("Products");

	}

}

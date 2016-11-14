package ma.ensa.views.login;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ma.ensa.controllers.interfaces.PageController;

public class ConnectionPanel extends JPanel {
	JPanel container ;
	JTextField serverAdresseTextField ;
	JButton connecteButton ;
	public ConnectionPanel() {
		// TODO Auto-generated constructor stub
		intUI();
	}
	public ConnectionPanel(PageController controller) {
		// TODO Auto-generated constructor stub
		
	}
	public void intUI(){
		container =new JPanel() ;
		serverAdresseTextField =new JTextField("localhost");
		connecteButton =new JButton("connect to server");
		container.setLayout(new GridLayout(2,2,20,20));
		
		
		container.add(new JLabel("server address :"));
		container.add(serverAdresseTextField);
		
		container.add(new JLabel("OK"));
		container.add(connecteButton);
		
		this.setLayout(new GridLayout(1,1,20,20));
		container.setBorder(BorderFactory.createEmptyBorder(100, 200, 400, 200));
		this.add(container);
	}
}

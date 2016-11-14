package ma.ensa.views.user;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OneUserPanel extends JPanel {

	// id of the panel
	private int panelId;
	//
	private OneUserActionListner oneUserActionListner;
	
	private JPanel container;
	
	private JLabel firstNameLabel;
	private JLabel lastNameLable;
	private JLabel emailLabel;
	private JLabel passwordLabel;
	private JLabel telephoneLabel;
	private JLabel adminLabel;

	private JButton deleteButton;
	private JButton updateButton;

	

	public OneUserPanel() {

		intUI();

	}


	
	public void intUI() {

		firstNameLabel = new JLabel();
		lastNameLable = new JLabel();
		emailLabel = new JLabel();
		passwordLabel = new JLabel();
		telephoneLabel = new JLabel();
		adminLabel = new JLabel();

		deleteButton = new JButton("delete");
		updateButton = new JButton("update");

		container = new JPanel();

		container.setLayout(new GridLayout(4, 4, 20, 20));

		container.add(new JLabel("first Name"));
		container.add(firstNameLabel);

		container.add(new JLabel("last Name"));
		container.add(lastNameLable);

		//

		container.add(new JLabel("email"));
		container.add(emailLabel);

		container.add(new JLabel("password"));
		container.add(passwordLabel);

		//

		container.add(new JLabel("Telephone"));
		container.add(telephoneLabel);

		container.add(new JLabel("Type of user"));
		container.add(adminLabel);

		//

		container.add(new JLabel());
		container.add(deleteButton);

		container.add(updateButton);
		container.add(new JLabel());

		this.setLayout(new GridLayout(1, 1, 20, 20));
		container
				.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.add(container);
		this.setBorder(BorderFactory.createEtchedBorder());
		initControlle();
		this.setPreferredSize(new Dimension(1000,200));

	}
	
	public void initControlle(){
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				oneUserActionListner.delete(panelId);
			}
		});
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				oneUserActionListner.update(panelId);
			}
		});
	}
	
	public void setOneUserActionListner(OneUserActionListner oneUserActionListner) {
		this.oneUserActionListner = oneUserActionListner;
	}
	
	public void setFirstName(String firstName) {
		this.firstNameLabel.setText(firstName);
	}

	public void setLastName(String lastName) {
		this.lastNameLable.setText(lastName);
	}

	public void setEmail(String email) {
		this.emailLabel.setText(email);
	}

	public void setPassword(String password) {
		this.passwordLabel.setText(password);
	}

	public void setTelephone(String telephone) {
		this.telephoneLabel.setText(telephone);
	}

	public void setAdmin(boolean admin) {
		this.adminLabel.setText(admin + "");
	}

	
	public void setPanelId(int panelId) {
		this.panelId = panelId;
	}

}

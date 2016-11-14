package ma.ensa.views.home;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChoisePanel extends JPanel{

	JPanel container ;
	JLabel taskLabel ;
	private JButton actionButton ;
	
	public ChoisePanel(String iconlink ,String textForButton) {
		// TODO Auto-generated constructor stub
		container =new JPanel();
		container.setBorder(BorderFactory.createEtchedBorder());
		container.setLayout(new BorderLayout());
		taskLabel =new JLabel(textForButton);
		actionButton =new JButton() ;
		ImageIcon imageIcon = new ImageIcon(getClass().getResource(iconlink));
		imageIcon.setDescription(textForButton);
		actionButton.setIcon(imageIcon);
		actionButton.setPreferredSize(new Dimension(300,240));
		container.add(taskLabel,BorderLayout.NORTH);
		container.add(actionButton,BorderLayout.CENTER);
		this.add(container);
	}
	
	public JButton getActionButton() {
		return actionButton;
	}
}

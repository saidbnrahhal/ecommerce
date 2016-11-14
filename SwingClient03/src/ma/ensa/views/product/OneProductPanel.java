package ma.ensa.views.product;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ma.ensa.models.entity.Category;

public class OneProductPanel extends JPanel {

	// id of the panel
 	private int panelId;

	private OneProductActionListner oneProductActionListner;

	private JPanel container;
	private ImagePanel imagePanel  ;
	private JLabel nameLabel;
	private JLabel qtyInstockLabel;
	private JLabel availableLabel;
	private JLabel priceLabel;
	private JLabel gameGenreLabel;
	private JLabel shortDiscreptionLabel;

	private JButton deleteButton;
	private JButton updateButton;

	public OneProductPanel() {

		intUI();

	}

	public void intUI() {

		// TODO
		nameLabel = new JLabel();
		qtyInstockLabel = new JLabel();
		availableLabel = new JLabel();
		priceLabel = new JLabel();
		gameGenreLabel = new JLabel();
		imagePanel =new ImagePanel() ;
		shortDiscreptionLabel = new JLabel();

		deleteButton = new JButton("delete");
		updateButton = new JButton("update");

		container = new JPanel();

		container.setLayout(new BorderLayout());
		
		//
		container.add(imagePanel,BorderLayout.WEST);
		//
		JPanel containerParalel =new JPanel() ;
		containerParalel.setLayout(new GridLayout(2,2,20,20));
		
		JPanel container1 =new JPanel();
		container1.setLayout(new GridLayout(1,4,2,2));
		
		container1.add(new JLabel("Name"));
		container1.add(nameLabel);

		container1.add(new JLabel("Quantity"));
		container1.add(qtyInstockLabel);

		//
		JPanel container2 =new JPanel();
		container2.setLayout(new GridLayout(1,4,2,2));
		
		container2.add(new JLabel("availableLabel"));
		container2.add(availableLabel);

		container2.add(new JLabel("price"));
		container2.add(priceLabel);

		//
		JPanel container3 =new JPanel();
		container3.setLayout(new GridLayout(1,4,2,2));
		container3.add(new JLabel("game Genre"));
		container3.add(gameGenreLabel);

		container3.add(new JLabel("shortDiscreptionLabel"));
		container3.add(shortDiscreptionLabel);

		//
		JPanel container4 =new JPanel();
		container4.setLayout(new GridLayout(1,4,2,2));
		container4.add(new JLabel());
		
		
		JPanel paneldeleteButton =new JPanel();
		paneldeleteButton.add(deleteButton);
		
		JPanel panelupdateButton =new JPanel();
		panelupdateButton.add(updateButton);
		
		container4.add(paneldeleteButton);
		container4.add(panelupdateButton);
		
		container4.add(new JLabel());
		container4.setPreferredSize(new Dimension(100,50));
		
		containerParalel.add(container1);
		containerParalel.add(container2);
		containerParalel.add(container3);
		containerParalel.add(container4);
		
		this.setLayout(new GridLayout(1, 1, 20, 20));
		container
		.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		container.add(containerParalel,BorderLayout.CENTER);
		this.add(container);
		this.setBorder(BorderFactory.createEtchedBorder());
		initControlle();
		this.setPreferredSize(new Dimension(1000, 300));
		
	}

	public void initControlle() {
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				oneProductActionListner.delete(panelId);
			}
		});
		updateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				oneProductActionListner.update(panelId);
			}
		});
	}

	public void setOneProductActionListner(
			OneProductActionListner oneProductActionListner) {
		this.oneProductActionListner = oneProductActionListner;
	}

	public void setName(String name) {
		this.nameLabel.setText(name);
	}

	public void setQtyInstock(int qtyInstock) {
		this.qtyInstockLabel.setText(qtyInstock+"");
	}
	
	public void setAvailable(Boolean available) {
		this.availableLabel.setText(available+"");
	}

	public void setPrice(Double price) {
		this.priceLabel.setText(price+"");
	}

	public void setGameGenre(Category gameGenre) {
		this.gameGenreLabel.setText(gameGenre+"");
	}
	
	public void setImageLink(String imageLink) {
		try {
			imagePanel.loadImage(new URL(imageLink));
		} catch (MalformedURLException e) {
			imagePanel.loadImage("");
		}
	}

	public void setShortDiscreption(String shortDiscreption) {
		this.shortDiscreptionLabel.setText(shortDiscreption+"");
	}

	public int getPanelId() {
		return panelId;
	}

	public void setPanelId(int panelId) {
		this.panelId = panelId;
	}
	
}

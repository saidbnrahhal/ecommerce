package ma.ensa.views;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import ma.ensa.controllers.interfaces.PageController;
import ma.ensa.models.Model;

public class View extends JFrame implements ActionListener{

	Model model;
	JPanel centerPanel;
	JPanel ContainerPanel = new JPanel();
	PageController pageController ;
	
	JMenuItem connectPage = new JMenuItem("connection page");
	JMenuItem homePage = new JMenuItem("home page");
	JMenuItem commandePage =new JMenuItem("commande page");
	JMenuItem userPage =new JMenuItem("user page") ;
	JMenuItem productPage =new JMenuItem("product page");

	public View(Model model2 ,PageController pageController) {

		this.model = model2;
		this.pageController =pageController ;
		createMenuBar();
		initGUI();
		initControlle();
	}


	public void initGUI() {
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1, 1, 10, 10));
		this.setTitle("*************");
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ContainerPanel.setLayout(null);
		centerPanel.setBorder(BorderFactory
				.createTitledBorder("Home :"));
		centerPanel.setBounds(new Rectangle(20, 20, 1150, 620));
		
		ContainerPanel.add(centerPanel);
		this.setContentPane(ContainerPanel);
		this.setVisible(true);

	}

	public void addPageController(PageController pageController){
		this.pageController =pageController ;
	}
	private void createMenuBar() {
		JMenuBar menubar = new JMenuBar();
		JMenu pageMenu = new JMenu("Pages :");
		pageMenu.add(connectPage);
		pageMenu.add(homePage);
		pageMenu.add(userPage);
		pageMenu.add(commandePage);
		pageMenu.add(productPage);
		menubar.add(pageMenu);
		this.setJMenuBar(menubar);
	}
	public void chargeView(JPanel view,String viewTitle) {

			
			
			
			centerPanel.removeAll();
			centerPanel.repaint();
			centerPanel.setLayout(new GridLayout(1, 1, 10, 10));
			centerPanel.setBorder(BorderFactory
					.createTitledBorder(viewTitle));
			centerPanel.add(view);
			
			
			
			centerPanel.repaint();
			centerPanel.updateUI();
		
	}	
	
	public void initControlle(){
		 connectPage.addActionListener(this);
		 homePage.addActionListener(this); 
		 commandePage.addActionListener(this);
		 userPage.addActionListener(this);
		 productPage.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==homePage) {
			pageController.homePage();
		}
		if (e.getSource()==commandePage) {
			pageController.commandePage();
		}
		if (e.getSource()==userPage) {
			pageController.userPage();
		}
		if (e.getSource()==productPage) {
			pageController.productPage();
		}
	}
}






















// JMenuBar menubar = new JMenuBar();
//
// ImageIcon iconNew = new ImageIcon("new.png");
// ImageIcon iconOpen = new ImageIcon("open.png");
// ImageIcon iconSave = new ImageIcon("save.png");
// ImageIcon iconExit = new ImageIcon("exit.png");
//
// JMenu fileMenu = new JMenu("File");
//
// JMenu impMenu = new JMenu("Import");
//
// JMenuItem newsfMi = new JMenuItem("Import newsfeed list...");
// JMenuItem bookmMi = new JMenuItem("Import bookmarks...");
// JMenuItem mailMi = new JMenuItem("Import mail...");
//
// impMenu.add(newsfMi);
// impMenu.add(bookmMi);
// impMenu.add(mailMi);
//
// JMenuItem newMi = new JMenuItem("New", iconNew);
// JMenuItem openMi = new JMenuItem("Open", iconOpen);
// JMenuItem saveMi = new JMenuItem("Save", iconSave);
//
// JMenuItem exitMi = new JMenuItem("Exit", iconExit);
// exitMi.setToolTipText("Exit application");
//
// exitMi.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent event) {
// System.exit(0);
// }
// });
// fileMenu.add(newMi);
// fileMenu.add(openMi);
// fileMenu.add(saveMi);
// fileMenu.addSeparator();
// fileMenu.add(impMenu);
// fileMenu.addSeparator();
// fileMenu.add(exitMi);
//
// menubar.add(fileMenu);
//
// setJMenuBar(menubar);

/*
 * //centerPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
 * //ContainerPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
 * JScrollPane vertical; vertical = new JScrollPane(GraphPanel); //
 * vertical.setPreferredSize(new Dimension(1000,600));
 * //vertical.setHorizontalScrollBarPolicy
 * (JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); //Panel.add(vertical);
 */
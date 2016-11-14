package ma.ensa.views.product;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	
	private BufferedImage image;
	
	public ImagePanel() {
		this.setPreferredSize(new Dimension(200,300));
		this.setBorder(BorderFactory.createEtchedBorder());
		
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image!=null) {
        	 g.drawImage(image, 0, 0, this.getWidth(),this.getHeight(), null);
		}
               
    }
		
	public void loadImage(String Path) {
		BufferedImage imageTemp =null ;
		try {
			imageTemp = ImageIO.read(new File(Path));
		} catch (IOException ex) {
			try {
				imageTemp = ImageIO.read(new File("C:/Users/rahhal/Desktop/ImageOut/game.png"));
			} catch (IOException ex2) {

			}
		}
		this.image=imageTemp;
		this.repaint();
	}

	public void loadImage(URL url ) {
		BufferedImage imageTemp =null ;
		try {
			imageTemp = ImageIO.read(url);
			
		} catch (IOException ex) {
			System.out.println("image loding fail"+url.toString());
			try {
				imageTemp = ImageIO.read(new File("C:/Users/rahhal/Desktop/ImageOut/game.png"));
			} catch (IOException ex2) {
				
			}
		}
		this.image=imageTemp;
		this.repaint();
	}
	
	
	
}

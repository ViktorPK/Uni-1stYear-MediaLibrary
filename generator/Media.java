package viktor.generator;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Media {
	private String name;
	private JLabel image;
	public Media( String name, String url, boolean fromURL ) {
		this.name = name;
		JLabel picture = new JLabel();
		try {
			if ( fromURL ) {
				picture.setIcon(new ImageIcon(ImageIO.read(new URL(url))));
			
			} else {
				
				picture.setIcon(new ImageIcon(ImageIO.read(new File(url))));
				
			}
			
		} catch (IOException e) {
			
			picture.setText("No image available.");
			
		}
		
		this.image = picture;
		
	}
	
	public Media(String name, JLabel image) {
		
		this.name = name;
		
		this.image = image;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public JLabel getImage() {
		
		return image;
		
	}
	
	public String toString() {
		
		return name;
		
	}

}

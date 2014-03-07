import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Main3Sauv {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedImage image= new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
		int couleur1 = (200 << 16) + (0 << 8) + 0;
		int vert = (11 << 16) + (67 << 8) + 0 ;
		
		for(int i=0 ; i<200 ; i++){
			for(int j=0 ; j<200 ; j++){
				if(((i+j)%2)==0){image.setRGB(i,j,couleur1);
			}
				else {image.setRGB(i, j, 255);
			
		}
				
						
	}
			
	int m1 = (int) (Math.random() * (200));
				int m2 = (int) (Math.random() * (200));
				image.setRGB(m1, m2, vert);		
			
			try {
				
			    File fic= new File("im3.png");
			    ImageIO.write(image, "png", fic);}
			catch (IOException e) {
			    e.printStackTrace();
			}
			
}
		Plante p = new Plante(null);
		BufferedImage br = ImageIO.read(new File("im3.png"));
		ArrayList<Pixel> tab = p.photoToPlant(br);
		p.setPlante(tab);
		p.setEpsilon(0.1);
		p.setK(3);
		p.kmoyenne();
		System.out.println("fin");

	}
	

}

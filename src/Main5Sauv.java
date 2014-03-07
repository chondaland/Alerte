import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Main5Sauv {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/******************* Création d'une image rayée bleue et rouge **********/		
		BufferedImage image= new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
		int rouge = (200 << 16) + (0 << 8) + 0;
		int violet = (67 << 16) + (0 << 8) + 58 ;

		
		for(int i=0 ; i<50 ; i++){
			for(int j=0 ; j<50 ; j++){
				if((i%2)==0){image.setRGB(i,j,rouge);
			}
				else {image.setRGB(i, j, 255);
			
		}
	}
			
			
			
}	
		try {
			    File fic= new File("bicolore.png");
			    ImageIO.write(image, "png", fic);
			} catch (IOException e) {
			    e.printStackTrace();
			}
		
		Plante p = new Plante(null);
		BufferedImage br = ImageIO.read(new File("bicolore.png"));
		ArrayList<Pixel> tab = p.photoToPlant(br);
		p.setPlante(tab);
		p.setEpsilon(0.001);
		p.setK(2);
		p.kmoyenne();
		
		BufferedImage resultat= new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
		for(int i=0 ; i<p.getPlante().size(); i++){
			int m2 = i%50 ;
			int m1 = i/50;
		if(p.getPlante().get(i).getnumGroupe()==0){
			
			resultat.setRGB(m1,m2,(200 << 16) + (200<< 8) + 20);
			
			}
		else {resultat.setRGB(m1, m2, image.getRGB(m1,m2));
			try {
			    File fic= new File("res2.png");
			    ImageIO.write(resultat, "png", fic);
			} catch (IOException e) {
			    e.printStackTrace();
			}
		}
		}
		}}

	
	
	

	



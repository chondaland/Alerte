import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import pactutils.Rectangle;

public class MainSauv {

	/**
	 * @param args : 
	 * 		[0] : filename : le fichier avec la photo RG(IR)
	 * 		[1] : filename pour photo ndvi
	 * 		[2] : filename pour photo bin
	 * 		[3] : filename pour rectangle
	 * 		[4] : adresse du serveur
	 */
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		
		Plante p;
		ArrayList<Rectangle> rectangle;
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(args[3]));
			rectangle = (ArrayList<Rectangle>) ois.readObject();
			
			p = new Plante(parseImages(ImageIO.read(new File(args[0])), ImageIO.read(new File(args[1])), ImageIO.read(new File(args[2])), rectangle.get(0)));
			p.setPlante3("data/saine.jpeg", "data/malade.jpg");
			p.getSante();
			
			int intsante = -1;
			switch(p.getSante()){
			case SAIN:
				intsante = 1;
				break;
			case MALADE : 
				intsante = 0;
				break;
			}
			
			URL urlserver = new URL(args[1] + "/rpztix/plants/1/set/sante/"+intsante); // TODO package par le module serveur pour modifier plus de données que ça.
			HttpURLConnection conn = (HttpURLConnection) urlserver.openConnection();
			System.out.println(conn.getResponseCode());
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally{
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	public static ArrayList<Pixel> parseImages(BufferedImage rgbimage, BufferedImage ndvimage, BufferedImage binimage, Rectangle rectangle){
		
		ArrayList<Pixel> list = new ArrayList<Pixel>();
		for(int x=rectangle.getP1().x; x < rectangle.getP3().x; x++){
			for(int y=rectangle.getP1().y; y < rectangle.getP3().y; y++){
				if(binimage.getRGB(x, y) > 10){
					
					Color c = new Color(rgbimage.getRGB(x,y));
					Color ndvi = new Color(rgbimage.getRGB(x, y));
					
					list.add(new Pixel(c.getRed(), c.getBlue(), ndvi.getRed(), c.getBlue())); // le canal IR est sur le bleu, et l'image NDVI est en niveaux de gris
						// donc on peut prendre n'importe quel canal
				}
			}
		}
		return list;
	}

}

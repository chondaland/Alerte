import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.media.jai.RenderedImageAdapter;
import javax.media.jai.PlanarImage;
import javax.media.jai.JAI;


public class MainTestKppv {
	public static void main(String args[]) throws IOException{

/************** 1ère série de test simple    *************************************************
	
		//Critère de bonne santé : valeur de rouge élevé
		//Autres valeurs non prises en compte
		
		ArrayList<Pixel> baseDApprentissage = new ArrayList<Pixel>(4);
		Pixel p1 = new Pixel(1000,0,0,0);   //très bonne santé
		Pixel p2 = new Pixel(600,0,0,0);   //bonne santé
		Pixel p3 = new Pixel(10,0,0,0);   //très mauvaise santé
		Pixel p4 = new Pixel(400,0,0,0);  //mauvaise santé
		
		//Etiquetter les pixels
		
		p1.setGroupe2(1);
		p2.setGroupe2(1);
		p3.setGroupe2(-1);
		p4.setGroupe2(-1);
		
		//Ajouter à arraylist pour créer la base d apprentissage
		
		baseDApprentissage.add(p1);
		baseDApprentissage.add(p2);
		baseDApprentissage.add(p3);
		baseDApprentissage.add(p4);
		
		//Créer pixels à trier
		
		Pixel m1 = new Pixel(900,0,0,0);   //très bonne santé
		Pixel m2 = new Pixel(650,0,0,0);   //bonne santé
		Pixel m3 = new Pixel(20,0,0,0);   //très mauvaise santé
		Pixel m4 = new Pixel(350,0,0,0);  //mauvaise santé

		//Ajouter pixel à trier dans ArrayAist photol
		
		ArrayList<Pixel> photol = new ArrayList<Pixel>(4);
		photol.add(m1);
		photol.add(m2);
		photol.add(m3);
		photol.add(m4);
		
		ArrayList<Pixel> base = new ArrayList<Pixel>(4);
		base.add(p1);
		base.add(p2);
		base.add(p3);
		base.add(p4);
		
		for(int i=0; i<photol.size(); i++){
			photol.get(i).setBase(base);
		}
		
		//Application de l algo avec k = 3
		 
		for(int i=0;i<photol.size();i++){
			System.out.println("pixel à trier "+ i +" : "+ "Rouge "+ photol.get(i).getR());
			photol.get(i).setBase(baseDApprentissage);
			photol.get(i).kppvPixel(3);
		}
	
	//Code du kPPV à adapter à cette phase de tests dans Pixel.java
		int p=0;
		for(int i=0;i<k;i++){
			System.out.println("pixel trié "+ i +" : "+ "etiquette "+ baseDApprentissageTest.get(i).getnumGroupe2()+ ", Rouge "+ baseDApprentissageTest.get(i).getR());
			p=((Pixel) baseDApprentissageTest.get(i)).getnumGroupe2()+p;
		}
		System.out.println("Etiquette du pixel à trier : " + p);
		if(p>0) this.setGroupe2(1);
		if(p<0) this.setGroupe2(-1);
		if(p==0) this.kppvPixel(k+1);
		
	//Fonction distance du kPPV à adapter à cette phase de test dans Pixel.java
		public double distance1(Pixel m){
			return Math.abs(this.getR()-m.getR())/2;
			}

***************************** Fin de la 1ere phase de test simple ********************************************************/
		
/************* 2nd série de test : image coupee en 2 deux : partie haute en rouge, partie basse en blanche ***************
		
		//Pour transformer l image "test2.png" situe dans folder en un ArrayList plant2
		
		BufferedImage newImage = ImageIO.read(new File("folder/test2.png"));
		BufferedImage sortieNDVI = ImageIO.read(new File("folder/test2.png"));
		int m = 0;
		ArrayList<Pixel> tableau2 = new ArrayList<Pixel>();
		for (int i = 0; i < 200; i++) {
		for (int j = 0; j < 200; j++) {
		Color c = new Color(newImage.getRGB(i, j));
		tableau2.add(m,
		new Pixel(c.getRed(), c.getBlue(), c.getBlue(),
		sortieNDVI.getRGB(i, j)));
		m++;
	}
}

		Plante plant2 = new Plante(tableau2);		
		
				//Valeur prise en compte : bleu
				//Autres valeurs non prises en compte
				//Plus le bleu est fort et proche de 255, plus le pixel est blanc
				//Plus le bleu est petit et proche de 0, plus le pixel est rouge
				
				ArrayList<Pixel> baseDApprentissage = new ArrayList<Pixel>(4);
				Pixel p1 = new Pixel(0,10,0,0);   //très rouge
				Pixel p2 = new Pixel(0,50,0,0);   //assez rouge
				Pixel p3 = new Pixel(0,180,0,0);  //assez blanc
				Pixel p4 = new Pixel(0,250,0,0);  //très blanc
				
				//Etiquetter les pixels
				
				p1.setGroupe2(1);
				p2.setGroupe2(1);
				p3.setGroupe2(-1);
				p4.setGroupe2(-1);
				
				//Ajouter à arraylist pour créer la base d apprentissage
				
				baseDApprentissage.add(p1);
				baseDApprentissage.add(p2);
				baseDApprentissage.add(p3);
				baseDApprentissage.add(p4);
				
				//Intermédiaire d'arraylist base
				
				ArrayList<Pixel> base = new ArrayList<Pixel>(4);
				base.add(p1);
				base.add(p2);
				base.add(p3);
				base.add(p4);
				
				for(int i=0; i<plant2.getPlante().size(); i++){
					plant2.getPlante().get(i).setBase(baseDApprentissage);
				}
				
				//Application de l algo avec k = 3
				 
				for(int i=0;i<plant2.getPlante().size();i++){
					plant2.getPlante().get(i).setBase(baseDApprentissage);
					plant2.getPlante().get(i).kppvPixel(3);
				}		
				
				//On recupere en sortie une image dont les pixels d etiquette 1 sont rouge et les pixels d etiquette -1 sont blanc
				
				for(int i=0;i<plant2.getPlante().size();i++){
					if(plant2.getPlante().get(i).getnumGroupe2()==1){
						int m2 = i%200 ;
						int m1 = i/200;
						newImage.setRGB(m1,m2,255);
						}
					}
					
					File outputfile = new File("folder/testsortie2.png");
					ImageIO.write(newImage, "png", outputfile);
						
		//Code du kPPV à adapter à cette phase de tests : code de base
		
		//Fonction distance du kPPV à adapter à cette phase de test
			public double distance1(Pixel m){
				return Math.abs(this.getB()-m.getB())/2;
		}
****************************** Fin de la 2nde phase de test simple ***********************************************************************/

//************* 3eme série de test simple : photo avec alternance de pixels rouge et bleu *************************************************

		//Pour transformer l image "test3.png" situe dans folder en un ArrayList plant2
		
		BufferedImage newImage = ImageIO.read(new File("folder/test3.png"));
		BufferedImage sortieNDVI = ImageIO.read(new File("folder/test3.png"));
		int m = 0;
		ArrayList<Pixel> tableau2 = new ArrayList<Pixel>();
		for (int i = 0; i < 200; i++) {
		for (int j = 0; j < 200; j++) {
		Color c = new Color(newImage.getRGB(i, j));
		tableau2.add(m,
		new Pixel(c.getRed(), c.getBlue(), c.getBlue(),
		sortieNDVI.getRGB(i, j)));
		m++;
	}
}

		Plante plant2 = new Plante(tableau2);		

		//Valeur prise en compte : rouge et bleu
		//Autres valeurs non prises en compte
		
		ArrayList<Pixel> baseDApprentissage = new ArrayList<Pixel>(4);
		Pixel p1 = new Pixel(190,10,0,0);   //très rouge
		Pixel p2 = new Pixel(150,10,0,0);   //assez rouge
		Pixel p3 = new Pixel(200,100,0,0);  //assez rouge
		Pixel p4 = new Pixel(80,250,0,0);  //assez bleu
		Pixel p5 = new Pixel(10,180,0,0);   //assez bleu
		Pixel p6 = new Pixel(10,250,0,0);   //très bleu
		
		//Etiquetter les pixels
		
		p1.setGroupe2(1);
		p2.setGroupe2(1);
		p3.setGroupe2(1);
		p4.setGroupe2(-1);
		p5.setGroupe2(-1);
		p6.setGroupe2(-1);
		
		//Ajouter à arraylist pour créer la base d apprentissage
		
		baseDApprentissage.add(p1);
		baseDApprentissage.add(p2);
		baseDApprentissage.add(p3);
		baseDApprentissage.add(p4);
		baseDApprentissage.add(p5);
		baseDApprentissage.add(p6);
		
		//Intermédiaire d'arraylist base
		
		ArrayList<Pixel> base = new ArrayList<Pixel>(4);
		base.add(p1);
		base.add(p2);
		base.add(p3);
		base.add(p4);
		base.add(p5);
		base.add(p6);
		
		for(int i=0; i<plant2.getPlante().size(); i++){
			plant2.getPlante().get(i).setBase(baseDApprentissage);			
}

		//Application de l algo avec k = 3
		
		for(int i=0;i<plant2.getPlante().size();i++){
			System.out.println("pixel à trier "+ i +" : "+ "Rouge "+ plant2.getPlante().get(i).getR()+ ", Bleu "+ plant2.getPlante().get(i).getB());
			plant2.getPlante().get(i).setBase(baseDApprentissage);
			plant2.getPlante().get(i).kppvPixel(4);
		}
	}
}

		//On recupere en sortie une image dont les pixels d etiquette 1 sont rouge et les pixels d etiquette -1 sont blanc
/******************************** NE MARCHE PAS ICI *********************************************************************
		for(int i=0;i<plant2.getPlante().size();i++){
			if(plant2.getPlante().get(i).getnumGroupe2()==1){
				int m2 = i%200 ;
				int m1 = i/200;
				newImage.setRGB(m1,m2,255);
				}
			}
			
			File outputfile = new File("folder/testsortie3.png");
			ImageIO.write(newImage, "png", outputfile);

***************************** Fin du code NE MARCHANT PAS *********************************************************************/


/******************************************************************************************************************************
	//Code du kPPV à adapter à cette phase de tests : code de base

	//Fonction distance du kPPV à adapter à cette phase de test
		public double distance1(Pixel m){
			return Math.sqrt((this.getB()-m.getB())*(this.getB()-m.getB())+(this.getR()-m.getR())*(this.getR()-m.getR()));
		}

********************************** Fin de la 3eme phase de test simple *****************************************************************/
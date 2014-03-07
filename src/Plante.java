import java.util.ArrayList;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.*;

import javax.imageio.ImageIO;

 class Plante {
	
		private ArrayList<Pixel> plante = new ArrayList<Pixel>();
		private int k;
		private double epsilon;
		private ArrayList<ArrayList<Pixel>> H = new ArrayList<ArrayList<Pixel>>(k);
		private ArrayList<Moyenne> H2 = new ArrayList<Moyenne>(k);

		public void setPlante(ArrayList<Pixel> newplante){
			this.plante = newplante;
		}
		
		public ArrayList<Moyenne> getH2(){
			return this.H2;
		}
		
		public void setK(int newk){
			k=newk;
		}
		
		public void setEpsilon(double epsilon){
			this.epsilon=epsilon;
		}
		
		public ArrayList<ArrayList<Pixel>> getH(){
			return this.H;
		}
		
		public ArrayList<Pixel> getPlante(){
			return this.plante;
		}
		
		
		public Plante(ArrayList<Pixel> plante){
			this.plante=plante;
		}
		
		public void kmoyenne(){
			int nbPixel = plante.size();
			ArrayList<Integer> random = new ArrayList<Integer>();
			while(random.size()<k){
				int m1 = (int)(Math.random() * (nbPixel));
				if(random.contains(m1)==false){
					random.add(m1); 
				}
			}
			
			
			ArrayList<Pixel> R1 = new ArrayList<Pixel>(k);
			for(int i=0;i<k;i++){
				R1.add(this.plante.get((random.get(i)).intValue()));
			}
			
			
					
			ArrayList<Pixel> R = new ArrayList<Pixel>(k);
			
				
			for(int i=0; i<k ; i++){
				R.add(i,R1.get(i)); // initialisation des représentants des groupes
			}
						
			Representants R3 = new Representants(R, this.k);
			
			int lanceurAlgo = 0;
			
			for(int j=0 ; j<plante.size(); j++){
				plante.get(j).setGroupe(0);
				plante.get(j).setEloignement(plante.get(j).distance(R1.get(0)));
				
				
			}
			
			
			while((lanceurAlgo==0) | (R3.test(R1, epsilon)==true)){
				System.out.println("boucle");
				for(int i=0 ; i<k ; i++){
					R3.remove(i);
					R3.add(i,R1.get(i)); 
					}
				
				
				
				for(int j=0 ; j<plante.size(); j++){
					for(int u=0 ; u<k ; u++){
						if(plante.get(j).distance(R1.get(u))<plante.get(j).getEloignement()){
							plante.get(j).setEloignement(plante.get(j).distance(R1.get(u)));
							plante.get(j).setGroupe(u);
						}
					}
				}
				
				ArrayList<Pixel> a = new ArrayList<Pixel>(k);
				for(int u=0 ; u<k; u++){
					H.add(a);
				}
				
				
				for(int u=0 ; u<k; u++){
					for(int j=0; j<this.plante.size();j++){
						if(this.plante.get(j).getnumGroupe()==u){
							H.get(u).add(this.plante.get(j));
						}
					}
				}
				
				
				for(int u=0 ; u<k; u++){
					H2.add(u,new Moyenne(H.get(u)));
				}
				
				for(int u=0 ; u<k; u++){
					R1.add(H2.get(u).getCentroide());
				}
				
				lanceurAlgo++;
				
			}
			
			
			
		System.out.println("results");	
		for(int j=0 ; j<plante.size(); j++){
				System.out.println(plante.get(j).getnumGroupe());
			}
			
			System.out.println(R3.test(R1, epsilon));
			
			
			
		}
		
		public Sante kmoyenne2(Pixel temoinSain, Pixel temoinMalade, int entier){
			this.k =entier;
			int nbPixel = plante.size();
			ArrayList<Integer> random = new ArrayList<Integer>();
			while(random.size()<k){
				int m1 = (int)(Math.random() * (nbPixel));
				if(random.contains(m1)==false){
					random.add(m1); 
				}
			}
			
			
			ArrayList<Pixel> R1 = new ArrayList<Pixel>(k);
			for(int i=0;i<k;i++){
				R1.add(this.plante.get((random.get(i)).intValue()));
			}
			
			
					
			ArrayList<Pixel> R = new ArrayList<Pixel>(k);
			
				
			for(int i=0; i<k ; i++){
				R.add(i,R1.get(i)); // initialisation des représentants des groupes
			}
						
			Representants R3 = new Representants(R, this.k);
			
			int lanceurAlgo = 0;
			
			for(int j=0 ; j<plante.size(); j++){
				plante.get(j).setGroupe(0);
				plante.get(j).setEloignement(plante.get(j).distance(R1.get(0)));
				
				
			}
			
			
			while((lanceurAlgo==0) | (R3.test(R1, epsilon)==true)){
				System.out.println("boucle");
				for(int i=0 ; i<k ; i++){
					R3.remove(i);
					R3.add(i,R1.get(i)); // sauvegarde des représentants de la boucle précédente dans R3
					// on peut ensuite modifier R1 dans ce nouveau passage de la boucle
					}
				
				
				
				for(int j=0 ; j<plante.size(); j++){
					for(int u=0 ; u<k ; u++){
						if(plante.get(j).distance(R1.get(u))<plante.get(j).getEloignement()){
							plante.get(j).setEloignement(plante.get(j).distance(R1.get(u)));
							plante.get(j).setGroupe(u);
						}
					}
				}
				
				ArrayList<Pixel> a = new ArrayList<Pixel>(k);
				for(int u=0 ; u<k; u++){
					H.add(a);
				}
				
				
				for(int u=0 ; u<k; u++){
					for(int j=0; j<this.plante.size();j++){
						if(this.plante.get(j).getnumGroupe()==u){
							H.get(u).add(this.plante.get(j));
						}
					}
				}
				
				
				for(int u=0 ; u<k; u++){
					H2.add(u,new Moyenne(H.get(u)));
				}
				
				for(int u=0 ; u<k; u++){
					R1.add(H2.get(u).getCentroide());
				}
				
				lanceurAlgo++;
				
			}
			
		int taille =0;
		int indic =-1 ;
		for(int u=0 ; u< k; u++){
			if(H.get(u).size()> taille){
				taille = H.get(u).size();
				indic = u;
			}
		}
		
		double d1 = H2.get(indic).getCentroide().distance(temoinSain);
		double d2 = H2.get(indic).getCentroide().distance(temoinMalade);

		if(d1<=d2){System.out.println("Votre plante est en bonne santé");
		return Sante.SAIN ;
		}
		else {System.out.println("Votre plante est malade");
		return Sante.MALADE ;
		
			
		System.out.println("results");	
		for(int j=0 ; j<plante.size(); j++){
				System.out.println(plante.get(j).getnumGroupe());
			}
			
			System.out.println(R3.test(R1, epsilon));
			
			
			
		}
		}
		
		
		
		public Sante getSante(String NomPhotoRVB, String NomPhotoNDVI, Pixel temoinSain, Pixel temoinMalade, int entier) throws IOException{
			
				BufferedImage newImage = ImageIO.read(new File(NomPhotoRVB));
				BufferedImage sortieNDVI = ImageIO.read(new File(NomPhotoNDVI));
						
			
			int m=0;
			ArrayList<Pixel> tableau2 = new ArrayList<Pixel>();
			for(int i=0; i<200;i++){
				for(int j=0; j<200;j++){
					Color c = new Color(newImage.getRGB(i, j));
					tableau2.add(m, new Pixel(c.getRed(), c.getBlue(), c.getBlue() , sortieNDVI.getRGB(i, j)));
					m++;
				}
			}
			
			Plante plant2 = new Plante(tableau2);
			plant2.setK(2);
			plant2.setEpsilon(0.0001);
			Sante A = plant2.kmoyenne2(temoinSain, temoinMalade, 2);
			if(A==Sante.MALADE){return Sante.MALADE;}
			else {return Sante.SAIN ;}
			
		}
		
		

		public void kppvPlante(int k){
		
		for(int i=0;i<plante.size()-1;i++){
			((Pixel) plante.get(i)).kppvPixel(k);
		}
	}
 }
 
 //IL RESTE A DEFINIR UNE FONCTION COMMUNE AUX 2 ALGOS A PRIORI QUI DIT SI, APRES AVOIR TRIE LES PIXELS D UNE PLANTE
 //,SI ELLE EST MALADE OU NON (choisir un seuil)

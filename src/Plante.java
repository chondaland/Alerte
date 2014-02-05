import java.util.ArrayList;
import java.math.*;

 class Plante {
	
		private ArrayList plante = new ArrayList<Pixel>();
		private int k;
		private double epsilon;
		
		public ArrayList getA(){
			return this.plante;
		}
		
		
		public Plante(ArrayList<Pixel> plante){
			this.plante=plante;
		}
		
		public void kmoyenne(){
			
		}
		
		public void kppvPlante(int k){
		
		for(int i=0;i<plante.size()-1;i++){
			((Pixel) plante.get(i)).kppvPixel(k);    //pk faire du cast ici ?
		}
	}
 }
 
 //IL RESTE A DEFINIR UNE FONCTION COMMUNE AUX 2 ALGOS A PRIORI QUI DIT SI, APRES AVOIR TRIE LES PIXELS D UNE PLANTE
 //,SI ELLE EST MALADE OU NON (choisir un seuil)
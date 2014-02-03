import java.util.ArrayList;
import java.util.Collections;


public class Pixel implements Comparable{
	private double R;
	private double B;
	private double NDVI;
	private double IR;
	private int numgroupe;
	private int numgroupe2;
	
	public Pixel(double R, double B, double NDVI, double IR){
		this.R=R;
		this.B=B;
		this.NDVI=NDVI;
		this.IR=IR;
	}
	
	public void setGroupe(int newnum){
		this.numgroupe=newnum;
	}
	
	public void setGroupe2(int newnum){
			this.numgroupe2=newnum;
	}
	
	public int getnumGroupe(){
		return this.numgroupe;
	}
		
	public int getnumGroupe2(){
			return this.numgroupe2;
	}
	
	public double getR(){
		return this.R;
	}
	
	public double getB(){
		return this.B;
	}
	
	public double getNDVI(){
		return this.NDVI;
	}
	
	public double getIR(){
		return this.IR;
	}
	
	public double distance(Pixel m){
		return (this.NDVI-m.getNDVI())/2;  // EXEMPLE DE DISTANCE
	}
	
	public void kppvPixel(int k){
		//pour chaque pixel appartenant à la base d'apprentissage (=bc de photos jor 100, 200)
		// base d'apprentissage = arraylist contenant tous les pixels de la base d'apprentissage
		
		for(int i=0;i<baseDApprentissage.size-1;i++){
			baseDApprentissage.get(i).distance(this);
			
			
			//utiliser une fonction qui classe les pixels dans le tableau
			//en fonction de la distance (ordre croissant)
			
//****************** Tentative *****************************************//
			// ArrayList tableaudistance = new ArrayList<Pixel>();
			// Collections.sort(tableaudistance);
			
			// public int compareTo(Pixel l, Pixel j){ 
			//    double nombre1 = this.distance(l); 
			//    double nombre2 = this.distance(j); 
			//    if (nombre1<nombre2) return -1; 
			//    else if(nombre1 == nombre2) return 0; 
			//    else return 1; 
			// } 
			
//***************************************************************************//
			
		}
		
		int p=0;
		for(int i=0;i<k-1;i++){
			p=((Pixel) tableaudistance.get(i)).getnumGroupe2()+p;   //pk du cast ici ?
		}
		if(p>0) this.setGroupe2(1);
		if(p<0) this.setGroupe2(-1);
		if(p==0) this.kppvPixel(k+1);
	}
	
}
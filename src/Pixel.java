import java.util.ArrayList;
import java.util.Collections;


public class Pixel implements Comparable{

	private double R;
	private double B;
	private double NDVI;
	private double IR;
	private int numgroupe = -1;
	private double eloignement;
	
	public double getEloignement(){
		return this.eloignement;
	}
	
	public void setEloignement(double d){
		this.eloignement =d;
	}

	private int numgroupe2;
	private double distance = 0;
	
	public Pixel(double R, double B, double NDVI, double IR){
		this.R=R;
		this.B=B;
		this.NDVI=NDVI;
		this.IR=IR;
	}
	
	
	public double distance(Pixel pixel){
		return Math.abs(this.B-pixel.getB());
	}
	
	public void setGroupe(int newnum){
		this.numgroupe=newnum;
	}
	
	public void setGroupe2(int newnum){
			this.numgroupe2=newnum;
			
	}
	public void setDistance(double newdistance){
			this.distance=newdistance;
	}
	
	public int getnumGroupe(){
		return this.numgroupe;
	}
		
	public int getnumGroupe2(){
		return this.numgroupe2;
	}
	
	public double getDistance(){
		return distance;
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
	
	public int compareTo(Object p){	
		Pixel m = (Pixel) p;
		if (this.distance<m.getDistance()) return -1; 
		else if(this.distance == m.getDistance()) return 0; 
		else return 1;
	}
	
	public double distance1(Pixel m){
		return (this.NDVI-m.getNDVI())/2;  // EXEMPLE DE DISTANCE
	}
	
	public int kppvPixel(int k){
		
		//CREATION DUN ARRAYLIST baseDApprentissage QUI SERVIRA D EXEMPLE
		
		ArrayList baseDApprentissage = new ArrayList<Pixel>();
			
		//pour chaque pixel i appartenant � la base d'apprentissage (=bc de photos jor 100, 200)
		//on calcule la distance au pixel fixe et on change l'attribut distance du pixel i
		//base d'apprentissage = arraylist contenant tous les pixels de la base d'apprentissage
					
	for(int i=0;i<baseDApprentissage.size()-1;i++)
		baseDApprentissage.get(i).setDistance(baseDApprentissage.get(i).distance(this));
			
		//on doit copier la base d'apprentissage d'abord (car on va trier le tableau)
			
		ArrayList<Pixel> baseDApprentissageTest = new ArrayList<Pixel>(baseDApprentissage);
			
		//on trie les pixels de la base d'apprentissage test avec Collections.sort
			
		Collections.sort(baseDApprentissageTest);		
		
		int p=0;
		for(int i=0;i<k-1;i++){
			p=((Pixel) baseDApprentissageTest.get(i)).getnumGroupe2()+p;   //pk du cast ici ?
		}
		
		if(p>0) this.setGroupe2(1);
		if(p<0) this.setGroupe2(-1);
		if(p==0) this.kppvPixel(k+1);
	}

}

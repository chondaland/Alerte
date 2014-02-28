import java.util.ArrayList;
import java.util.Collections;

import javax.media.jai.JAI;
import javax.imageio.ImageIO;


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
	
	private ArrayList<Pixel> baseDApprentissage;
	
	public void setBase(ArrayList<Pixel> base){
		this.baseDApprentissage = base;
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
	
	public double distance1(Pixel m){
		return Math.sqrt((this.getB()-m.getB())*(this.getB()-m.getB())+(this.getR()-m.getR())*(this.getR()-m.getR()));  //Fc distance du test 3
	}
	
	public void kppvPixel(int k){
			
		//Pour chaque pixel i appartenant a la base d'apprentissage, on calcule la distance au pixel fixe et on change l'attribut distance du pixel i
					
	for(int i=0;i<baseDApprentissage.size();i++)
		baseDApprentissage.get(i).setDistance(baseDApprentissage.get(i).distance(this));
			
		//On doit copier la base d apprentissage d'abord car on va la trier et on ne doit jamais modifier la base d apprentissage
			
		ArrayList<Pixel> baseDApprentissageTest = (ArrayList<Pixel>) baseDApprentissage.clone();
			
		//On trie les pixels de la base d apprentissage test avec Collections.sort
			
		Collections.sort(baseDApprentissageTest, new PixelComparator(this));
		
		//On considere les etiquettes des k PPV qui correspondent ici aux k premiers pixels de baseDApprentissageTest
		
		int p=0;
		for(int i=0;i<k;i++){
			p=((Pixel) baseDApprentissageTest.get(i)).getnumGroupe2()+p;    //On somme les etiquettes (1 et -1) pour connaitre l etiquette majoritaire
	}
		if(p>0) this.setGroupe2(1);
		if(p<0) this.setGroupe2(-1);
		if(p==0) this.kppvPixel(k+1);   // en cas d egalite, on recommence en prenant un PPV suppplementaire pour trancher
	}
	

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

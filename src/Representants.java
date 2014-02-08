import java.util.ArrayList;


public class Representants {
	private ArrayList<Pixel> centroides;
	
	public Representants(ArrayList<Pixel> centroides){
		this.centroides = centroides ;
	}
	
	public ArrayList<Pixel> getCentroides(){
		return centroides;
	}
	
	public void add(Pixel p){
		this.centroides.add(p);
	}
	
	public void set(int i, Pixel p){
		this.set(i, p);
	}
	
	public ArrayList<Double> buildComparison(ArrayList<Pixel> A){
		ArrayList<Double> comp= new ArrayList<Double>();
		for(int i=0 ; i<this.centroides.size()-1 ; i++ ){
			comp.add(i,A.get(i).distance(this.centroides.get(i)));
		}
		
		return comp;
		
	}
	
	public boolean test(ArrayList<Pixel> A, double epsilon){
		int indic=-1 ;
		ArrayList<Double> comp = this.buildComparison(A);
		
		for(int i=0;i<=this.centroides.size()-1;i++){
			if(comp.get(i)>epsilon){
				indic = indic + 1;
			}
		}
		

		if(indic>0){
			return true;
		}
		
		else {return false;}
	}
	
	
	

}

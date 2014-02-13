import java.util.ArrayList;


public class Representants {
	private ArrayList<Pixel> centroides;
	
	public Representants(ArrayList<Pixel> centroides){
		this.centroides = centroides ;
	}
	
	public ArrayList<Pixel> getCentroides(){
		return centroides;
	}
	
	public void add(int i,Pixel p){
		this.centroides.add(i,p);
	}
	
	public void remove(int i){
		this.centroides.remove(i);
	}
	
	public void set(int i, Pixel p){
		this.set(i, p);
	}
	
	public ArrayList<Double> buildComparison(ArrayList<Pixel> A){
		ArrayList<Double> comp= new ArrayList<Double>();
		for(int i=0 ; i<2 ; i++ ){
			comp.add(i, new Double(A.get(i).distance(this.centroides.get(i))));	
			System.out.println(A.get(i).distance(this.centroides.get(i)));
}
		
		return comp;
		
	}
	
	public boolean test(ArrayList<Pixel> A, double epsilon){
		int indic=-1 ;
		ArrayList<Double> comp = this.buildComparison(A);
		
		for(int i=0;i<this.centroides.size();i++){
			System.out.println(comp.get(i).doubleValue()>epsilon);
			if(comp.get(i).doubleValue()>epsilon){
				indic = indic + 1;
			}
		}
		

		if(indic>-1){
			return true;
		}
		
		else {return false;}
	}
	
	
	

}

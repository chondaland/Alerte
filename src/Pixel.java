
public class Pixel {
	private double R;
	private double B;
	private double NDVI;
	private double IR;
	private int numgroupe = -1;
	
	public Pixel(double R, double B, double NDVI, double IR){
		this.R=R;
		this.B=B;
		this.NDVI=NDVI;
		this.IR=IR;
	}
	
	public void setGroupe(int newnum){
		this.numgroupe=newnum;
	}
	
	public int getnumGroupe(){
		return this.numgroupe;
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
}

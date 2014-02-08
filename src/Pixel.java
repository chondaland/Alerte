public class Pixel {
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
	
	public Pixel(double R, double B, double NDVI, double IR){
		this.R=R;
		this.B=B;
		this.NDVI=NDVI;
		this.IR=IR;
	}
	
	
	public double distance(Pixel pixel){
		return Math.abs(this.NDVI-pixel.getNDVI());
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

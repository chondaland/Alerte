import java.util.Comparator;


public class PixelComparator implements Comparator<Pixel> {
	
	Pixel pixelRef;
	
	public PixelComparator(Pixel q){
		pixelRef = q;
	}
	
	public int compare(Pixel p, Pixel l){	
		if (p.distance1(pixelRef)<l.distance1(pixelRef)) return -1; 
		else if(p.distance1(pixelRef) == l.distance1(pixelRef)) return 0; 
		else return 1;
	}
	
	public boolean equals(Pixel p, Pixel l){
		return compare(p,l) == 0;
	}
	
}
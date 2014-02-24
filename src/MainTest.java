import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.media.jai.RenderedImageAdapter;
import javax.media.jai.PlanarImage;
import javax.media.jai.JAI;





public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			PlanarImage image = new RenderedImageAdapter(ImageIO.read(new File("data/test.jpg")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		
		ArrayList<Pixel> a = new ArrayList<Pixel>(10);
		Pixel p1 = new Pixel(1000,1100,120,120);
		Pixel p2 = new Pixel(1000,1100,150,120);
		Pixel p3 = new Pixel(1,1,1,30);
		Pixel p4 = new Pixel(1,1,1,30);
		Pixel p5 = new Pixel(0,0,0,0);
		Pixel p6 = new Pixel(5,5,6,30);
		Pixel p7 = new Pixel(1,2,4,5);
		Pixel p8 = new Pixel(100,200,100,200);
		Pixel p9 = new Pixel(1000,1000,1000,100);
		
		a.add(p1);
		a.add(p2);
		a.add(p3);
		a.add(p4);
		a.add(p5);
		a.add(p6);
		a.add(p7);
		a.add(p8);
		a.add(p9);
		
		Plante plant=new Plante(a);
		plant.setK(2);
		plant.setEpsilon(0.0001);
		
		plant.kmoyenne();
		
		

	}

}

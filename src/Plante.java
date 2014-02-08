import java.util.ArrayList;

public class Plante {
	
		private ArrayList<Pixel> plante = new ArrayList<Pixel>();
		private int k;
		private double epsilon;
		private ArrayList<ArrayList<Pixel>> H = new ArrayList<ArrayList<Pixel>>(k);
		private ArrayList<Moyenne> H2 = new ArrayList<Moyenne>(k);

		public ArrayList<Moyenne> getH2(){
			return this.H2;
		}
		
		public ArrayList<ArrayList<Pixel>> getH(){
			return this.H;
		}
		
		public ArrayList<Pixel> getPlante(){
			return this.plante;
		}
		
		
		public Plante(ArrayList<Pixel> plante){
			this.plante=plante;
		}
		
		public void kmoyenne(){
			int nbPixel = plante.size()+1;
			ArrayList<Integer> random = new ArrayList<Integer>();
			while(random.size()<k){
				int m1 = (int)(Math.random() * (nbPixel + 1));
				if(random.contains(m1)==false){
					random.add(m1); 
				}
			}
			
			ArrayList<Pixel> R1 = new ArrayList<Pixel>(k);
			for(int i=1;i<k;i++){
				R1.add(i,this.plante.get((random.get(i)).intValue()));
			}
			
			
					
			ArrayList<Pixel> R = new ArrayList<Pixel>(k);
			
				
			for(int i=0; i<k ; i++){
				R.add(i,R1.get(i)); // initialisation des représentants des groupes
			}
						
			Representants R3 = new Representants(R);
			
			int lanceurAlgo = 0;
			
			while((lanceurAlgo==0) | (R3.test(R1, epsilon)==false)){
				for(int i=0 ; i<k ; i++){
					R3.set(i, R.get(i)); 
					}
				
				for(int j=0 ; j<plante.size(); j++){
					plante.get(j).setGroupe(1);
					plante.get(j).setEloignement(plante.get(j).distance(R.get(0)));
					
					
				}
				
				for(int j=0 ; j<plante.size(); j++){
					for(int u=0 ; u<k ; u++){
						if(plante.get(j).distance(R.get(u))<plante.get(j).getEloignement()){
							plante.get(j).setEloignement(plante.get(j).distance(R.get(u)));
							plante.get(j).setGroupe(u);
						}
					}
				}
				
				for(int u=0 ; u<k; u++){
					for(int j=0; j<this.plante.size();j++){
						if(this.plante.get(j).getnumGroupe()==k){
							H.get(u).add(this.plante.get(j));
						}
					}
				}
				
				for(int u=0 ; u<k; u++){
					H2.add(u,new Moyenne(H.get(u)));
				}
				
				for(int u=0 ; u<k; u++){
					R.set(u, H2.get(u).getCentroide());
				}
				
				lanceurAlgo++;
				
			}
			
			
			
			
			
			
			
			
		}
		
		public void kPPV(){
			
		
		}

	}

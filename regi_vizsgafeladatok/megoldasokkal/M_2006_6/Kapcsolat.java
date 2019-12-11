import java.util.ArrayList;

public class Kapcsolat{
	private String nev;
	private double sebesseg; //kbit/s
	private boolean kapcsolattipus; //false = modem, true = �lland�
	private ArrayList <Fajl>fajlok;
	
	
	public Kapcsolat( String ujnev, double seb, boolean isallando){
		nev = ujnev;
		sebesseg = seb;
		kapcsolattipus = isallando;		
		fajlok= new ArrayList<Fajl>();
	}
	
	public String toString(){
		return " A kapcsolat adatai:" + nev+" \tsebess�g: " + sebesseg
			+ " t�pusa: "+(kapcsolattipus?"�lland�":"modem")+ " jelleg�.\n";
	}
	
	
	//itt j�n a sz�mol� met�dus
	public int getIdo(Fajl forras){
		//let�roljuk az objektumot is
		fajlok.add(forras);
		return (int)((forras.getMeret()*8)/(sebesseg*1024));
	}
	
	//adatforgalom lek�rdez�se
	public long getOsszadatforgalom(){
		long ossz=0;
		for(Fajl aktualis : fajlok){
			ossz += aktualis.getMeret();
		}			
		/*
		//2.
		for (int i=0; i< fajlok.size(); i++){
			ossz += fajlok.get(i).getMeret();
		}
		
		//3.
		Iterator it = fajlok.iterator();
		while(it.hasNext()){
			ossz+=it.next().getMeret();
		}
		*/
		return ossz;
		
	}
	
	
	
	
	
}
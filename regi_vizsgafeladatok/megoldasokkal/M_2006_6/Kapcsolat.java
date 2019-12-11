import java.util.ArrayList;

public class Kapcsolat{
	private String nev;
	private double sebesseg; //kbit/s
	private boolean kapcsolattipus; //false = modem, true = állandó
	private ArrayList <Fajl>fajlok;
	
	
	public Kapcsolat( String ujnev, double seb, boolean isallando){
		nev = ujnev;
		sebesseg = seb;
		kapcsolattipus = isallando;		
		fajlok= new ArrayList<Fajl>();
	}
	
	public String toString(){
		return " A kapcsolat adatai:" + nev+" \tsebesség: " + sebesseg
			+ " típusa: "+(kapcsolattipus?"állandó":"modem")+ " jellegû.\n";
	}
	
	
	//itt jön a számoló metódus
	public int getIdo(Fajl forras){
		//letároljuk az objektumot is
		fajlok.add(forras);
		return (int)((forras.getMeret()*8)/(sebesseg*1024));
	}
	
	//adatforgalom lekérdezése
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
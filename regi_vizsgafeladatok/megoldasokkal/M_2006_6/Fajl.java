public class Fajl{
	private String nev;
	private long meret; // byte-ban mérünk ezért long
	
	public Fajl(String ujnev, long ujmeret){
		nev = ujnev;
		if(ujmeret >0) {
			meret = ujmeret;
		}else {
			meret =0;
		}
	}
	
	public String toString(){
		return "Fájl: "+nev+ " mérete: "+meret +"(byte)\n";
	}
	
	
	//méret lekérdezése
	public long getMeret(){return meret;}
	
}
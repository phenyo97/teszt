public class Fajl{
	private String nev;
	private long meret; // byte-ban m�r�nk ez�rt long
	
	public Fajl(String ujnev, long ujmeret){
		nev = ujnev;
		if(ujmeret >0) {
			meret = ujmeret;
		}else {
			meret =0;
		}
	}
	
	public String toString(){
		return "F�jl: "+nev+ " m�rete: "+meret +"(byte)\n";
	}
	
	
	//m�ret lek�rdez�se
	public long getMeret(){return meret;}
	
}
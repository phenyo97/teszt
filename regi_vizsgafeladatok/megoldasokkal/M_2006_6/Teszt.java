import java.io.*;
public class Teszt{
	public static void main(String[] arg){
		
		if(arg.length!=1){
			System.err.println("futtat�s: java Teszt fajlnev");
			System.exit(1);
		}
		
		
		String kimenet = arg[0] ;
			
		try{
			PrintWriter out = new PrintWriter(new FileWriter(kimenet));			
			
			Fajl f1 = new Fajl(" elso.txt", 220000);
			Fajl f2 = new Fajl("masodik.txt", 5620000);
			
			Kapcsolat kapcs1= new Kapcsolat("otthoni", 230.0, false);
			Kapcsolat kapcs2= new Kapcsolat("egyetemi", 13000.0, true);
			
			//ki�r�s
			
			
			out.println(f1); 
			out.println(f2);
			out.println(kapcs1);
			out.println(kapcs2);
			
			out.println(" f1 let�lt�si ideje otthon: "+kapcs1.getIdo(f1) +"s."); 
			out.println(" f2 let�lt�si ideje otthon: "+kapcs1.getIdo(f2)+"s."); 
			out.println(" f1 let�lt�si ideje egyetem: "+kapcs2.getIdo(f1)+"s."); 
			out.println(" f2 let�lt�si ideje egyetem: "+kapcs2.getIdo(f2)+"s."); 
			//System.out.println(" f2 let�lt�si ideje egyetem: "+kapcs2.getIdo(f2)+"s."); 
			
			out.println("kapcs 1 �ssz forgalma: " + kapcs1.getOsszadatforgalom() +" byte");
			out.println("kapcs 2 �ssz forgalma: " + kapcs2.getOsszadatforgalom() +" byte");
			
			//f�jl lez�r�s 
			out.close();
			
		}catch(IOException ioe){
			System.err.println("F�jl hiba! "+ioe);
		}
		
		
		
	}
}
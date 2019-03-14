import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

class ThreadClass2 extends Thread{
public void run() {
	try {
		long timerStartT=0,timerEndT=0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		
		timerStartT=System.currentTimeMillis();
		Date now = new Date();
	    
	    String strDate1 = sdf.format(now);
		System.out.println("Thread " + 
	            Thread.currentThread().getId()+"Started at "+(timerStartT)+" Date : "+strDate1);
		
		
		
		File file=new File("Input Big 450p.txt");
		//System.out.println("FIlecontents : ");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String line;
		while((line = br.readLine()) != null){
		    //System.out.println("	"+line);
		    if(line.contains("e")) {
		    	ReadFilesPTFile.charcount += line.length() - line.replace("e", "").length();
		    }
		}
		
		timerEndT=System.currentTimeMillis();
		Date nowEnd = new Date();
		String strDate2 = sdf.format(nowEnd);
		System.out.println("Thread " + 
	            Thread.currentThread().getId()+"Finished at "+(timerEndT)+" Date : "+strDate2);
		System.out.println("Thread " + 
	            Thread.currentThread().getId()+"ran for "+(timerEndT-timerStartT)+"ms");
		//System.out.println((System.currentTimeMillis() - ReadFilesPTFile.timerStart) + " ms & Thread = "+Thread.currentThread().getId());
		}catch(Exception e) {System.out.println(e);}
}
}

public class ReadFilesPTFile {
public static long timerStart;
public static long timerEnd;
public static int charcount=0;

public static void main(String args[]) {
	
//Start Timer
timerStart=System.currentTimeMillis();

//Code Start
	ThreadClass2 TC=new ThreadClass2();
	TC.start();
	ThreadClass2 TC2=new ThreadClass2();
	TC2.start();
	ThreadClass2 TC3=new ThreadClass2();
	TC3.start();
	ThreadClass2 TC4=new ThreadClass2();
	TC4.start();
	ThreadClass2 TC5=new ThreadClass2();
	TC5.start();
//Code End.
	
//End Timer
timerEnd=System.currentTimeMillis();

}

}

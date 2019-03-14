import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class ThreadClass3{
public void mymethod() {
	try {
		System.out.println ("Thread " + 
	            Thread.currentThread().getId() + 
	            " is running");
		File file=new File("Input Big 450p.txt");
		System.out.println("FIlecontents : ");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String line;
		while((line = br.readLine()) != null){
		    //System.out.println("	"+line);
		    if(line.contains("e")) {
		    	ReadFTSEqualThreaded.charcount += line.length() - line.replace("e", "").length();
		    }
		}
		System.out.println((ReadFilesNPTFile2.timerEnd - ReadFilesNPTFile2.timerStart) + " ms");
		}catch(Exception e) {System.out.println(e);}

}

}

public class ReadFilesNPTFile2 {
public static long timerStart;
public static long timerEnd;
public static int charcount=0;

public static void main(String args[]) {
//Start Timer
timerStart=System.currentTimeMillis();

//Code Start
	ThreadClass3 TC=new ThreadClass3();
	TC.mymethod();
	ThreadClass3 TC2=new ThreadClass3();
	TC2.mymethod();
	ThreadClass3 TC3=new ThreadClass3();
	TC3.mymethod();
	ThreadClass3 TC4=new ThreadClass3();
	TC4.mymethod();
	ThreadClass3 TC5=new ThreadClass3();
	TC5.mymethod();
//Code End.

//End Timer
timerEnd=System.currentTimeMillis();

System.out.println("Real Time is "+(timerEnd-timerStart)+"ms");

}

}

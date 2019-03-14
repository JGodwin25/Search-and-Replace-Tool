import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class ThreadedFile extends Thread{
public void run() {
	try {
	System.out.println ("Thread " + 
            Thread.currentThread().getId() + 
            " is running");
	File file=new File("Input Big 150p.txt");
	System.out.println("FIlecontents : ");
	FileReader fr=new FileReader(file);
	BufferedReader br=new BufferedReader(fr);
	String line;
	while((line = br.readLine()) != null){
	    System.out.println("	"+line);
	    if(line.contains("e")) {
	    	ReadFTSEqualThreaded.charcount += line.length() - line.replace("e", "").length();
	    }
	}
	System.out.println((ReadFTSEqualThreaded.timerEnd - ReadFTSEqualThreaded.timerStart) + " ms");
	}catch(Exception e) {}
}

static void readFileData(File file) throws Exception {
	System.out.println("FIlecontents : ");
	FileReader fr=new FileReader(file);
	BufferedReader br=new BufferedReader(fr);
	String line;
	while((line = br.readLine()) != null){
	    System.out.println("	"+line);
	    if(line.contains("e")) {
	    	ReadFTSEqualThreaded.charcount += line.length() - line.replace("e", "").length();
	    }
	}
}

}

public class ReadFTSEqualThreaded {
	public static int charcount=0;
	public static long timerStart;
	public static long timerEnd;
	public static void main(String args[]) throws Exception {
//Start timer
timerStart = System.currentTimeMillis();
				
				String path="";
				File root=new File(path);
				ReadFTSEqualThreaded.listFiles(root);
				System.out.println("Char Count of e is : "+charcount);
				ThreadedFile TF=new ThreadedFile();
				TF.start();
				ThreadedFile TF2=new ThreadedFile();
				TF2.start();
//End Timer
timerEnd = System.currentTimeMillis();
			    
			    System.out.println((timerEnd - timerStart) + " ms");
			}

				static void listFiles(File directory) throws Exception {
				File[] rootFiles=directory.listFiles();

				for (File file : rootFiles) {
					//System.out.println(file);
					if(file.isDirectory()) {
						System.out.println("Within dir "+file.getName());
						ReadFTSEqualThreaded.listFiles(file);
					}
					else {
						System.out.println("	\\_ "+file);
						//ThreadedFile.readFileData(file);
						//ThreadedFile TF3=new ThreadedFile();
						//TF3.readFileData(file);
					}
				}

				}
}

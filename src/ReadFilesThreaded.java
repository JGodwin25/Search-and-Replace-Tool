import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFilesThreaded {
	public static void main(String args[]) throws Exception {
//Start timer
long timerStart = System.currentTimeMillis();
		
		String path="";
		File root=new File(path);
		ReadFilesThreaded.listFiles(root);
		
//End Timer
	    long timerEnd = System.currentTimeMillis();

	    System.out.println((timerEnd - timerStart) + " ms");
	}

		static void listFiles(File directory) throws Exception {
		File[] rootFiles=directory.listFiles();

		for (File file : rootFiles) {
			//System.out.println(file);
			if(file.isDirectory()) {
				System.out.println("Within dir "+file.getName());
				ReadFilesThreaded.listFiles(file);
			}
			else {
				System.out.println("	\\_ "+file);
				ReadFilesThreaded.readFileData(file);
			}
		}

		}

		static void readFileData(File file) throws Exception {
			System.out.println("FIlecontents : ");
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null){
			    System.out.println("	"+line);
			}
		}

}

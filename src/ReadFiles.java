import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadFiles {
	
public static void main(String args[]) throws Exception {

String path="";
File root=new File(path);
ReadFiles.listFiles(root);
}

static void listFiles(File directory) throws Exception {
File[] rootFiles=directory.listFiles();

for (File file : rootFiles) {
	//System.out.println(file);
	if(file.isDirectory()) {
		System.out.println("Within dir "+file.getName());
		ReadFiles.listFiles(file);
	}
	else {
		System.out.println("	\\_ "+file);
		ReadFiles.readFileData(file);
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CsvToMapSearch2 {
	public static String xmlLine;
	public static int lineCounter=0;
public static void main(String args[]) throws IOException {
	long timerStart,timerEnd;
	timerStart=System.currentTimeMillis();
	File xmlFile=new File("xml.txt");
	File csvFile=new File("testxml.csv");
	
	FileReader frcsv=new FileReader(csvFile);
	//FileReader frxml=new FileReader(xmlFile);
	
	BufferedReader brcsv=new BufferedReader(frcsv);
	//BufferedReader brxml=new BufferedReader(frxml);
	
	String csvLine;
	
	
	String fileName,filePath;
	fileName=xmlFile.getName();
	filePath=xmlFile.getAbsolutePath();
	
	
	HashMap<String, String> map=new HashMap<String,String>();
	
	brcsv.readLine();
	while((csvLine= brcsv.readLine()) != null){
		String[] inputs=csvLine.split(",");
	    map.put(inputs[0], inputs[1]);
		//searchPattern(xmlLine,map,fileName,filePath,lineCounter);
	}
	
	map.forEach((key,value)->{
		//System.out.println("Key = "+key);
		
		try {
			FileReader frxml=new FileReader(xmlFile);
			BufferedReader brxml=new BufferedReader(frxml);
			while((xmlLine = brxml.readLine()) != null){
			lineCounter++;
			if(xmlLine.contains(key)) {
				
				System.out.println("Found : ");
				System.out.println("File Name "+fileName+" |FilePath "+filePath+" | Line No "+lineCounter+" | Line Content "+xmlLine);
				System.out.println("Key : "+key+" Value : "+value);
				}
		}}catch(Exception e) {System.out.print(e);}
	
	});
	timerEnd=System.currentTimeMillis();
	System.out.println("Time "+(timerEnd-timerStart));
}
}

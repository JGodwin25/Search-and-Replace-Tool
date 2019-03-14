import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

class myBreakException extends RuntimeException{

}

public class CsvToMapSearch {
	public static void main(String args[]) throws IOException {
		long timerStart,timerEnd;
		timerStart=System.currentTimeMillis();
		File serverMap=new File("testxml.csv");
		FileReader fr=new FileReader(serverMap);
		BufferedReader br=new BufferedReader(fr);
		String line;
		br.readLine();
		HashMap<String,String> map = new HashMap<String, String>();

		while((line = br.readLine()) != null){
		    String[] inputs=line.split(",");
		    map.put(inputs[0], inputs[1]);
		}


		//map.forEach((key,value)->{
			//System.out.println("Key = "+key+" , value = "+value);
		//});

		String search="<connection-url>myserver.myapp</connection-url>";

		File xmlFile=new File("xml.txt");
		
		
		FileReader frxml=new FileReader(xmlFile);
		BufferedReader brxml=new BufferedReader(frxml);
		String xmlLine;
		String fileName,filePath;
		fileName=xmlFile.getName();
		filePath=xmlFile.getAbsolutePath();
		int lineCounter=0;
		while((xmlLine = brxml.readLine()) != null){
			lineCounter++;
		    searchPattern(xmlLine,map,fileName,filePath,lineCounter);
		}
		
		timerEnd=System.currentTimeMillis();
		System.out.println("Time "+(timerEnd-timerStart));

		}
	
	public static void searchPattern(String line,HashMap<String, String> map,String fileName,String filePath,int lineCounter) {
try {
		map.forEach((key,value)->{
			if(line.contains(key)) {
			System.out.println("Found : ");
			System.out.println("File Name "+fileName+" |FilePath "+filePath+" | Line No "+lineCounter+" | Line Content "+line);
			System.out.println("Key : "+key+" Value : "+value);
			throw new myBreakException();
			}
			});
}catch(myBreakException be) {}
		}
}

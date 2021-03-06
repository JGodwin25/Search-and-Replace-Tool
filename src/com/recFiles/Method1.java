package com.recFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Method1 {
	public static void main(String args[]) throws Exception {
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

		String path="";
		File root=new File(path);

		File xmlFile=new File("xml.txt");
		
		//searchPattern(xmlFile,map);
		listFiles(root,map);
		
		timerEnd=System.currentTimeMillis();
		System.out.println("Time "+(timerEnd-timerStart));

		}
	
	static void listFiles(File directory,HashMap<String,String> map) throws Exception {
		File[] rootFiles=directory.listFiles();

		for (File file : rootFiles) {
			//System.out.println(file);
			if(file.isDirectory()) {
				System.out.println("Within dir "+file.getName());
				Method1.listFiles(file,map);
			}
			else {
				System.out.println("	\\_ "+file);
				Method1.searchPattern(file,map);
			}
		}

		}	
	
	public static void searchPattern(File xmlFile,HashMap<String, String> map) {
		try {

///Mycode
FileReader frxml=new FileReader(xmlFile);
BufferedReader brxml=new BufferedReader(frxml);
String xmlLine;
String fileName,filePath;
fileName=xmlFile.getName();
filePath=xmlFile.getAbsolutePath();
int lineCounter=0;
String key,value;
while((xmlLine = brxml.readLine()) != null){
	lineCounter++;
//searchPattern(xmlLine,map,fileName,filePath,lineCounter);
	
	//Insert Fn	
for(Map.Entry<String,String> entry:map.entrySet()) {
key=entry.getKey();
value=entry.getValue();
	if(xmlLine.contains(key)) {
		System.out.println("File Name "+fileName+" |FilePath "+filePath+" | Line No "+lineCounter+" | Line Content "+xmlLine);
		break;
		}
}	
//End Fn	

}

}catch (FileNotFoundException e) {} catch (IOException e) {}

}
}

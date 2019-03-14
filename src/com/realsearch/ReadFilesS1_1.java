package com.realsearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class myBreakException extends RuntimeException{

}

public class ReadFilesS1_1 {
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


		map.forEach((key,value)->{
			//System.out.println("Key = "+key+" , value = "+value);
		});

		String search="<connection-url>myserver.myapp</connection-url>";

		File xmlFile=new File("xml.txt");
		
		iterFile(xmlFile,map);
		
		
		timerEnd=System.currentTimeMillis();
		System.out.println("Time "+(timerEnd-timerStart));

		}
	
	
	public static void iterFile(File xmlFile,HashMap<String, String> map) {
		///Mycode
		FileReader frxml;
		try {
			frxml = new FileReader(xmlFile);
		
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
		} catch (FileNotFoundException e) {} catch (IOException e) {}
	}

	public static void searchPattern(String xmlLine,HashMap<String, String> map,String fileName,String filePath,int lineCounter) {

try {
for(Map.Entry<String,String> entry:map.entrySet()) {
	String key,value;
	key=entry.getKey();
value=entry.getValue();
//System.out.println("Keyy = "+entry.getKey()+" Valuee = "+entry.getValue());
	if(xmlLine.contains(key)) {
		System.out.println("Found : ");
		System.out.println("File Name "+fileName+" |FilePath "+filePath+" | Line No "+lineCounter+" | Line Content "+xmlLine);
		System.out.println("Key : "+key+" Value : "+value);
		throw new myBreakException();
		}
}}catch(myBreakException be) {}	
	
//Insert Fn
	/*map.forEach((key,value)->{
		if(xmlLine.contains(key)) {
		System.out.println("Found : ");
		System.out.println("File Name "+fileName+" |FilePath "+filePath+" | Line No "+lineCounter+" | Line Content "+xmlLine);
		System.out.println("Key : "+key+" Value : "+value);
		throw new myBreakException();
		}
		});*/
//End Fn

//End

				


}
}

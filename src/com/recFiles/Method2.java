package com.recFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Method2 {
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



		File xmlFile=new File("xml.txt");
		iterFile(map,xmlFile);

		timerEnd=System.currentTimeMillis();
		System.out.println("Time "+(timerEnd-timerStart));	
		}


		public static void iterFile(HashMap<String, String> map,File xmlFile) {
		map.forEach((key,value)->{
			//System.out.println("Key = "+key);
		String xmlLine;
		int lineCounter=0;
		String fileName,filePath;
		fileName=xmlFile.getName();
		filePath=xmlFile.getAbsolutePath();

		try {
				FileReader frxml=new FileReader(xmlFile);
				BufferedReader brxml=new BufferedReader(frxml);

		lineCounter=0;

				while((xmlLine = brxml.readLine()) != null){
				lineCounter++;
				if(xmlLine.contains(key)) {
					
					//System.out.println("Found : ");
					System.out.println("File Name "+fileName+" |FilePath "+filePath+" | Line No "+lineCounter+" | Line Content "+xmlLine);
					//System.out.println("Key : "+key+" Value : "+value);
					}
			}}catch(Exception e) {System.out.print(e);}

		});
		}
}

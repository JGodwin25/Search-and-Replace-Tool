package com.recFiles2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Mtd2 {
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

		String path="";
		File root=new File(path);

		File xmlFile=new File("xml.txt");
		iterFile(map,xmlFile,root);

		timerEnd=System.currentTimeMillis();
		System.out.println("Time "+(timerEnd-timerStart));	
		}


		public static void iterFile(HashMap<String, String> map,File xmlFile,File directory) {
		map.forEach((key,value)->{
			//System.out.println("Key = "+key);
		String xmlLine;
		int lineCounter=0;
		String fileName,filePath;
		fileName=xmlFile.getName();
		filePath=xmlFile.getAbsolutePath();

		
try {

//New
	
File[] rootFiles=directory.listFiles();

for (File file : rootFiles) {
	//System.out.println(file);
	if(file.isDirectory()) {
		System.out.println("Within dir "+file.getName());
		Mtd2.iterFile(map,xmlFile,file);
	}
	else {
		System.out.println("	\\_ "+file);

//myelse start
		
FileReader frxml=new FileReader(file);
BufferedReader brxml=new BufferedReader(frxml);

lineCounter=0;

while((xmlLine = brxml.readLine()) != null){
lineCounter++;
if(xmlLine.contains(key)) {
			
//System.out.println("Found : ");
System.out.println("File Name "+fileName+" |FilePath "+filePath+" | Line No "+lineCounter+" | Line Content "+xmlLine);
//System.out.println("Key : "+key+" Value : "+value);
}
}
//myelse end
}

}
}catch(Exception e) {System.out.print(e);}

		});
		}
}

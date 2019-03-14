import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsvToMap {

public static void main(String args[]) throws IOException {

File serverMap=new File("test.csv");
FileReader fr=new FileReader(serverMap);
BufferedReader br=new BufferedReader(fr);
String line;
br.readLine();
HashMap<String,String> map = new HashMap<String, String>();

while((line = br.readLine()) != null){
    System.out.println("	"+line);
    String[] inputs=line.split(",");
    map.put(inputs[0], inputs[1]);
}


map.forEach((key,value)->{
	System.out.println("Key = "+key+" , value = "+value);
});

String search="<connection-url>myserver.myapp</connection-url>";

map.forEach((key,value)->{
if(search.contains(key)) {
System.out.println("Found : ");
System.out.println("Key : "+key+" Value : "+value);
}
});

}
	
}

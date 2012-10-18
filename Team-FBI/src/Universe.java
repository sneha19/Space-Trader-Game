import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


public class Universe {
	private String[] planetNames;
	private Planet[] planet;
	private Random rand;
	public Universe(){
		try {
			writeFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	planet = new Planet[122];
	
	for(int i=0;i<122;i++){
		String name = planetNames[i];
		planet[i]= new Planet(name);
	}
	
	rand = new Random();
	Planet p []= new Planet[122];
	int counter = 122;
	for(int i=0;i<122;i++){
		int index = rand.nextInt(counter);
		p[i]=planet[index];
		i++;
		counter--;
	}
	
	planet = p;
	
	for(int x=0;x<25;x++){
		
		
		
		
		
	}
	
	
	}
	
	
	
	
	public void writeFile() throws IOException
	{
		File file = new File("src/planets.txt");
		  FileReader fr = new FileReader(file);
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  BufferedReader in = new BufferedReader(fr);
		  String line;
		  String[] record = new String[122];
		  int i = 0;
		  while ((line = in.readLine()) != null){
			  record[i] = line.trim();
			  i++;
		  }
		  planetNames = record;
	}
	
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;


public class TpDoorConverter extends Plugin{
ArrayList<String> alist = new ArrayList<String>();
Logger log = Logger.getLogger("Minecraft");
	public void disable() {
	}

	public void enable() {
	}
	
	public void initialize(){
		log.info("[TpDoorConverter] - converting file!");
		File f = new File("plugins/config/TpDoor/tpdoor.txt");
		if (f.exists()){
			 try {
				 try {
				BufferedReader in = new BufferedReader(new FileReader(f));
				String key;
				String value;
				String world = etc.getServer().getDefaultWorld().getName();
				String dimension = "0";
				String addtoline = ","+world+","+dimension;
				String line;
				String[] l;
				String[] l0;
				String[] l1;
					while ((line = in.readLine()) != null) {
						if (!line.equals("")){
							if (line.startsWith("#")){alist.add(line);}else{
			    	   l = line.split("=");
			    	  l0 = l[0].split(",");
			    	  l1 = l[1].split(",");
			    	  if (l0.length == 3){
			    		  key = l[0]+addtoline;
			    	  }else{
			    	  key = l[0];
			    	  }
			    	  if (l1.length == 5){
			    		 value = l[1]+addtoline;
			    	  }else{
			    	  value = l[1];
			    	  }
			    	  alist.add(key+"="+value);
			    	  }
						}
					}
			      in.close();
			      f.delete();
			      String lineSep = System.getProperty("line.separator");
			      File f1 = new File("plugins/config/TpDoor/tpdoor.txt");
			    	  BufferedWriter out = new BufferedWriter(new FileWriter(f1));
			    	  for(String toWrite : alist){
							out.write(toWrite);
							out.write(lineSep);
						}
						out.close();
						log.info("[TpDoorConverter] - file converted!");
			} catch (FileNotFoundException e) {
				log.info("[TpDoorConverter] - critical error while conferting file!");
				e.printStackTrace();
			}		
			 } catch (IOException e) {
				 log.info("[TpDoorConverter] - critical error while conferting file!");
			e.printStackTrace();
		}
	}
}
}

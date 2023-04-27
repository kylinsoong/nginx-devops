package io.github.cloudadc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainTest {

	public static void main(String[] args) throws IOException {
		
		System.out.println("module,level,message");

		File file = new File("error.txt");
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	if(line.length() > 0) {
		    		String module = line.substring(0, line.indexOf(","));
		    		module = module.substring(4);
		    		module = module.substring(0, module.indexOf("/"));
		    		
		    		String left = line.substring(line.indexOf(",") + 1);
		    		String level = left.substring(0, left.indexOf(",")).trim();
		    		if(level.equals("NGX_LOG_EMERG")) {
		    			level = "emerg";
		    		} else if(level.equals("NGX_LOG_CRIT")) {
		    			level = "crit";
		    		} else if(level.equals("NGX_LOG_ALERT")) {
		    			level = "alert";
		    		}  else if(level.equals("NGX_LOG_ERR")) {
		    			level = "error";
		    		}
		    		
		    		String msg = left.substring(left.indexOf(",") + 1).replace(",", " ").replace(":", " ");
		    		msg = trimmsg(msg);
		    		msg = msg.trim();
		    		
			    	System.out.println(module + "," + level + "," + msg);
		    	}
		    	
		    	    
		    }
		}
		
		
	}

	private static String trimmsg(String msg) {
		for (int i = 50 ; i > 2 ; i --) {
			String old = formString(i);
			msg = msg.replace(old, " ... ");
		}
		return msg;
	}

	private static String formString(int size) {
		
		String msg = "";
		for(int i = 0 ; i < size ; i ++) {
			msg += " ";
		} 
		return msg;
	}

}

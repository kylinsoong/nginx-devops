package io.github.cloudadc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
	
	Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		args = new String[] {"/Users/ksong/tmp/test/nginx-1.23.3"};
		log.info("NGINX Log Grepper Start");
		
		if(args.length != 1 || !Files.exists(Paths.get(args[0])) || !Paths.get(args[0]).toFile().isDirectory()) {
			throw new Exception("Run greer with folder name");
		}
		
		iterateFiles(Paths.get(args[0]).toFile().listFiles());
	}
		
	public  void iterateFiles(File[] files) throws IOException {
        for (File file : files) {
            if (file.isDirectory()) {
                iterateFiles(file.listFiles()); 
            } else {
            	if(file.getName().endsWith(".c")) {
            		List<String> list = new ArrayList<>();
            		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            		    String line;
            		    while ((line = br.readLine()) != null) {
            		    	if(line.length() > 0)
            		    	    list.add(line);
            		    }
            		}
            		for (int i = 0 ; i < list.size() ; i++) {
            			if(list.get(i).contains("ngx_log_error")) {
            				String log = list.get(i);
            				if(log.contains(";")) {
            					dumplines(log);
            				} else {
            					List<String> all = new ArrayList<>();
            					extractAll(all, list, i + 1);
            					i = i + all.size();
            					for(int j = 0 ; j < all.size() ; j ++) {
            						log = log + all.get(j) + " ";
            					}
            					dumplines(log);
            				}
            			}
            		}
            	}
            }
        }
    }

	private void extractAll(List<String> all, List<String> list, int i) {
		String l = list.get(i);
		all.add(l);
		if(l.contains(";")) {
			return;
		} else {
			extractAll(all, list, i + 1);
		}
	}

	private void dumplines(String log) {
		if(log.contains("\"")) {
			log = log.substring(log.indexOf("\"") + 1, log.lastIndexOf("\""));
			log = log.replace("%V", "").replace("%s", "").replace("%c", "").replace("%d", "").replace("%p", "").replace("%uz", "").replace("%P", "").replace("\"", "");
			log = log.replace("\\", "").replace("%ui", "").replace("%ud", "").replace("%i", "").replace("%Xl", "").replace("%l", "");
			System.out.println(log);
		}	
	}
}

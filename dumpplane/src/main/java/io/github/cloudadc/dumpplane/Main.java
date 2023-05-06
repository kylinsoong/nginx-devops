package io.github.cloudadc.dumpplane;

import java.io.File;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import io.github.cloudadc.dumpplane.hander.CrossplaneHander;
import io.github.cloudadc.dumpplane.hander.DumpPersistHander;
import io.github.cloudadc.dumpplane.hander.ParseHander;
import io.github.cloudadc.dumpplane.hander.DumpSplitHander;
import io.github.cloudadc.dumpplane.hander.Hander;
import io.github.cloudadc.dumpplane.model.Configuration;

@SpringBootApplication
public class Main implements CommandLineRunner {
	
	Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		
		//args = new String[] {"dump", "/Users/ksong/Downloads/conf"};
		
		//args = new String[] {"parse", "/Users/ksong/Downloads/conf"};

		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		if(args.length < 2) {
			usage();
		}
		
		String uri = "mongodb://127.0.0.1:27017";
		String input = args[args.length - 1];
		String output = Hander.DISK_PATH;
		String crossplanoutput = output;
		
		for(int i = 0 ; i < args.length ; i++) {
			if(args[i].equals("-h") || args[i].equals("--help"))  {
				usage();
			} else if (args[i].equals("-V") || args[i].equals("--version"))  {
				System.out.println("dumpplane 0.0.1");
				System.exit(0);
			} else if(args[i].equals("--uri")) {
				uri = args[++i];
			}  else if(args[i].equals("--output")) {
				output = args[++i];
			} else if(args[i].equals("--cpout")) {
				crossplanoutput = args[++i];
			}
		}
		
		if(!Paths.get(input).toFile().isDirectory()) {
			usage();
		}
		
		if(args[0].equals("parse")) {
			log.info("parse " + input);
			ParseHander parse = ParseHander.newInstance(new File(input));
			parse.execute();
			DumpSplitHander.newInstance().execute(parse.getConfigs());
		} else if(args[0].equals("dump")) {
			
			log.info("dump " + crossplanoutput);
			
			ParseHander parse = ParseHander.newInstance(new File(input));
			parse.execute();
			
			DumpPersistHander dump = DumpPersistHander.newInstance();
			
			try (MongoClient mongoClient = MongoClients.create(uri)) {
				
				for(Configuration config : parse.getConfigs()) {
					
					File file = Paths.get(crossplanoutput, config.getDumpFileName()+ ".json").toFile();
					CrossplaneHander.newInstance(file).execute(config);
					
					dump.dumpToMongoDB(config, mongoClient);
				}
			}			

		}
	
		
	}

	private void usage() {
		System.out.println("usage: dumpplane <commands> [options] [input]");
		System.out.println();
		System.out.println("commands:");
		System.out.println("  parse                 parse a nginx dump(nginx -T) file to raw object");
		System.out.println();
		System.out.println("  dump                  dump nginx crossplane result to mongodb");
		System.out.println();
		System.out.println("options:");
		System.out.println("  -h, --help            show this help message and exit");
		System.out.println("  -V, --version         show program's version number and exit");
		System.out.println("  --output              set dumpplane output file path. default " + Hander.DISK_PATH);
		System.out.println("  --cpout               set crossplane(https://github.com/nginxinc/crossplane) parse output file path. default same as dumpplane output");
		System.out.println("                            suggest crossplane commands is for i in $(ls data/) ; do crossplane parse -o data/$i.json data/$i/nginx.conf; done ");
		System.out.println("  --uri                 mongodb connection string, default mongodb://127.0.0.1:27017, refer to https://www.mongodb.com/docs/manual/reference/connection-string/ for details" );
		System.out.println();
		System.out.println("input:");
		System.out.println("                        set nginx -T dump file directory, input is mandatory");

		System.exit(0);
	}

}

package io.github.cloudadc.dumpplane;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cloudadc.dumpplane.hander.DumpHander;
import io.github.cloudadc.dumpplane.hander.ParseHander;
import io.github.cloudadc.dumpplane.hander.PersistHander;

@SpringBootApplication
public class Main implements CommandLineRunner {
	
	Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		
		//args = new String[] {"dump", "/Users/ksong/Downloads/nginx.conf_15.55.240.8", "/Users/ksong/src/nginx-devops/dumpplane/data/15.55.240.8.json"};
		
		args = new String[] {"parse", "/Users/ksong/Downloads/nginx.conf_15.55.240.8"};

		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		if(args.length < 2) {
			usage();
		}
		
		for(int i = 0 ; i < args.length ; i++) {
			if(args[i].equals("-h") || args[i].equals("--help"))  {
				usage();
			} else if (args[i].equals("-V") || args[i].equals("--version"))  {
				System.out.println("0.0.1");
				System.exit(0);
			}
		}
		
		String uri = "mongodb://127.0.0.1:27017";
		
		if(args[0].equals("parse")) {
			String file = args[args.length - 1];
			log.info("parse " + file);
			ParseHander parse = new ParseHander(new File(file));
			PersistHander.newInstance().execute(parse.getConfig());
			DumpHander.newInstance().execute(parse.getConfig());
		} else if(args[0].equals("dump")) {
			String rawFile = args[args.length - 2];
			String crossFile = args[args.length - 1];
			log.info("dump " + crossFile);
			ParseHander parse = new ParseHander(new File(rawFile));
//			DumpHander dump = new DumpHander(new File(crossFile));
//			dump.execute(parse.getConfig());
		}
	
		
	}

	private void usage() {
		System.out.println("usage: dumpplane <command> [options]");
		System.out.println();
		System.out.println("optional arguments:");
		System.out.println("  -h, --help            show this help message and exit");
		System.out.println("  -V, --version         show program's version number and exit");
		System.out.println();
		System.out.println("commands:");
		System.out.println("  parse                 parses a nginx dump(nginx -T) file to raw object");

		System.exit(0);
	}

}

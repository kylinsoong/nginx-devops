package io.github.cloudadc.dumpplane.hander;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import io.github.cloudadc.dumpplane.model.Configuration;
import io.github.cloudadc.dumpplane.model.Dumpplane;

public class DumpSplitHander extends AbstractHander {

	public DumpSplitHander() {
		super(null);
	}


	public static DumpSplitHander newInstance() {
		return new DumpSplitHander();
	}
	

	public void execute(Configuration config) throws IOException {
		

		for(int i = 0 ; i < config.dumpplane().size() ; i ++) {
			Dumpplane block = config.dumpplane().get(i);
			String path = block.getPath().substring(0, block.getPath().lastIndexOf("/"));
			String fileName = block.getPath().substring(path.length() + 1);
			
			String subPath = null;
			if(path.length() > config.getBasePath().length()) {
				subPath = path.substring(config.getBasePath().length() + 1);
			}
			
			Path filePath = null;
			
			if(subPath != null) {
				filePath = Paths.get(DISK_PATH, config.getDumpFileName(), subPath, fileName);
			} else {
				filePath = Paths.get(DISK_PATH, config.getDumpFileName(), fileName);
			}

			File directory = filePath.getParent().toFile();
			if (!directory.exists()) {
			    directory.mkdirs();
			}
			
			byte[] decodedBytes = Base64.getDecoder().decode(block.getContent());
					
			FileWriter writer = new FileWriter(filePath.toFile());
			writer.write(new String(decodedBytes));
			writer.close();
		}
		
		System.out.println("split " + config.getDumpFileName() + " to " + Paths.get(config.getDiskPath(), config.getDumpFileName()) + ", total blocks: " + config.dumpplane().size());
		
	}


	@Override
	public void execute(List<Configuration> list) throws Exception {
		for(Configuration c : list) {
			execute(c);
		}
	}

}

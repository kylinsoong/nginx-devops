package io.github.cloudadc.dumpplane.hander;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.cloudadc.dumpplane.model.Configuration;
import io.github.cloudadc.dumpplane.model.Crossplane;

/**
 * 
 * Load the crossplane parsed jSON to object, and set to Configuration
 * 
 * @author ksong
 *
 */
public class CrossplaneHander extends AbstractHander {
	
	/**
	 * @param file - crossplane parsed jSON file
	 * @return
	 */
	public static CrossplaneHander newInstance(File file) {
		return new CrossplaneHander(file);
	}

	public CrossplaneHander(File file) {
		super(file);
	}
	
    public void execute(Configuration config) throws IOException {
		
		String rawCrossFile = readStreamFromfile(getFile());
				
		ObjectMapper mapper = new ObjectMapper();
		Crossplane crossplane = mapper.readValue(rawCrossFile.getBytes(), Crossplane.class);
		config.setCrossplane(crossplane);
		
		crossplane.getConfig().forEach(c -> {
			
			String prefix = Paths.get(config.getDiskPath(), config.getNgxHost()).toString();
		
			c.setFile(c.getFile().replace(prefix, config.getBasePath()));
		});
		
	}

	private String readStreamFromfile(File file) throws IOException {
		
		byte[] bytes = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(bytes);
		String fileContent = new String(bytes, "UTF-8"); 
		fis.close();
		
		return fileContent;
	}


}

package io.github.cloudadc.dumpplane.hander;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.cloudadc.dumpplane.NGXConfiguration;
import io.github.cloudadc.dumpplane.NGXConfigurationBlock;


public class ParseHander extends AbstractHander {
	
	private NGXConfiguration config = null;
	
	public ParseHander(File file) throws Exception {
		super(file);
		config = new NGXConfiguration();
		execute() ;
	}

	@Override
	public void execute() throws Exception {
		
		
		config.setDumpFileName(file.getName());
		config.setNgxHost(extractHost(config.getDumpFileName()));
		
		String configPath = null;

		try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            BufferedWriter writer = null;
            StringBuffer sb = null;
            while (line != null) {
                if (line.startsWith("#") && line.endsWith(":")) {
                	if (writer != null) {
                        writer.close();
                    }
                	addBlock(sb, configPath);
                    configPath = line.substring(line.indexOf("/"), line.length() -1);
                    sb = new StringBuffer();
                } else {

                    sb.append(line).append("\n");
                }
                line = reader.readLine();
            }
            addBlock(sb, configPath);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
		
		config.rawConfigBlock().forEach(block -> {
			String path = block.getPath().substring(0, block.getPath().lastIndexOf("/"));
			if(config.getBasePath() == null || config.getBasePath().length() ==0) {
				config.setBasePath(path);
			} else if (path.length() <= config.getBasePath().length()) {
				config.setBasePath(path);
			}
		});
		
	}

	

	private void addBlock(StringBuffer sb, String configPath) {

		if(sb != null && configPath != null) {
			String originalString = sb.toString();
			String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes());
			NGXConfigurationBlock block = new NGXConfigurationBlock(configPath, encodedString);
			config.addConfig(block);
			sb = null;
			configPath = null;
		}
	}

	private String extractHost(String dumpFileName) {
		
		String regex = "\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(dumpFileName);
		if(matcher.find()) {
			return matcher.group();
		} else if (dumpFileName.contains("_")) {
			return dumpFileName.substring(dumpFileName.indexOf("_") + 1);
		}
		return dumpFileName;
	}
	
	public NGXConfiguration getConfig() {
		return config;
	}

	@Override
	public void close() throws Exception {
		this.config = null;
	}

}

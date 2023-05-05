package io.github.cloudadc.dumpplane;

import java.util.ArrayList;
import java.util.List;

public class NGXConfiguration {
	
	private String dumpFileName;
	
	private String ngxHost;
	
	private String basePath;
	
	private List<NGXConfigurationBlock> rawConfig = new ArrayList<>();
	
	public NGXConfiguration() {
		
	}

	public NGXConfiguration(String dumpFileName, String ngxHost) {
		super();
		this.dumpFileName = dumpFileName;
		this.ngxHost = ngxHost;
	}

	public String getDumpFileName() {
		return dumpFileName;
	}

	public void setDumpFileName(String dumpFileName) {
		this.dumpFileName = dumpFileName;
	}

	public String getNgxHost() {
		return ngxHost;
	}

	public void setNgxHost(String ngxHost) {
		this.ngxHost = ngxHost;
	}

	public List<NGXConfigurationBlock> rawConfigBlock() {
		return rawConfig;
	}

	public void addConfig(NGXConfigurationBlock block) {
		this.rawConfig.add(block);
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	@Override
	public String toString() {
		return "[dumpFileName=" + dumpFileName + ", ngxHost=" + ngxHost + ", basePath=" + basePath
		        + ", rawConfig=" + rawConfig + "]";
	}


}

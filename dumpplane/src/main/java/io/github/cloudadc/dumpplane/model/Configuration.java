package io.github.cloudadc.dumpplane.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Configuration implements Serializable {
	
	private static final long serialVersionUID = 5338581958567066631L;

	private String dumpFileName;
	
	private String ngxHost;
	
	private String basePath;
	
	private List<Dumpplane> dumpplane = new ArrayList<>();
	
	private Crossplane crossplane;
	
	public Configuration() {
		
	}

	public Configuration(String dumpFileName, String ngxHost) {
		super();
		this.dumpFileName = dumpFileName;
		this.ngxHost = ngxHost;
	}
	
	public Configuration(String dumpFileName, String ngxHost, String basePath) {
		super();
		this.dumpFileName = dumpFileName;
		this.ngxHost = ngxHost;
		this.basePath = basePath;
	}
	
	public Configuration(String dumpFileName, String ngxHost, String basePath, List<Dumpplane> dumpplane) {
		super();
		this.dumpFileName = dumpFileName;
		this.ngxHost = ngxHost;
		this.basePath = basePath;
		this.dumpplane = dumpplane;
	}
	
	public Configuration(String dumpFileName, String ngxHost, String basePath, List<Dumpplane> dumpplane, Crossplane crossplane) {
		super();
		this.dumpFileName = dumpFileName;
		this.ngxHost = ngxHost;
		this.basePath = basePath;
		this.dumpplane = dumpplane;
		this.crossplane = crossplane;
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

	public List<Dumpplane> dumpplane() {
		return dumpplane;
	}

	public void addDump(Dumpplane block) {
		this.dumpplane.add(block);
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public List<Dumpplane> getDumpplane() {
		return dumpplane;
	}

	public void setDumpplane(List<Dumpplane> dumpplane) {
		this.dumpplane = dumpplane;
	}

	public Crossplane getCrossplane() {
		return crossplane;
	}

	public void setCrossplane(Crossplane crossplane) {
		this.crossplane = crossplane;
	}

	@Override
	public String toString() {
		return "[dumpFileName=" + dumpFileName + ", ngxHost=" + ngxHost + ", basePath=" + basePath
		        + ", dumpplane=" + dumpplane + ", crossplane=" + crossplane + "]";
	}

	


}

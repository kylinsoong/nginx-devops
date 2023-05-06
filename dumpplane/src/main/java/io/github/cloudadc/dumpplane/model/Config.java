package io.github.cloudadc.dumpplane.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Config implements Serializable {

	private static final long serialVersionUID = -7434111295540737281L;
	
	private  String status;
	
	private List<Error> errors = new ArrayList<>();
	
	private List<Block> parsed = new ArrayList<>();
	
	private String file;
	
	public Config() {
		
	}

	public Config(String status, List<Error> errors, List<Block> parsed, String file) {
		super();
		this.status = status;
		this.errors = errors;
		this.parsed = parsed;
		this.file = file;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public List<Block> getParsed() {
		return parsed;
	}

	public void setParsed(List<Block> parsed) {
		this.parsed = parsed;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "[status=" + status + ", errors=" + errors + ", parsed=" + parsed + ", file=" + file + "]";
	}

}

package io.github.cloudadc.dumpplane.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Crossplane implements Serializable {

	private static final long serialVersionUID = 313907630998516176L;
	
	private  String status;
	
	private List<Error> errors = new ArrayList<>();
	
	private List<Config> config = new ArrayList<>();
	
	public Crossplane() {
		
	}

	public Crossplane(String status, List<Error> errors, List<Config> config) {
		super();
		this.status = status;
		this.errors = errors;
		this.config = config;
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

	public List<Config> getConfig() {
		return config;
	}

	public void setConfig(List<Config> config) {
		this.config = config;
	}

	@Override
	public String toString() {
		return "[status=" + status + ", errors=" + errors + ", config=" + config + "]";
	}

}

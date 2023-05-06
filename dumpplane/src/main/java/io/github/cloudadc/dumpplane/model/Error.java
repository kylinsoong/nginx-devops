package io.github.cloudadc.dumpplane.model;

import java.io.Serializable;

public class Error implements Serializable {

	private static final long serialVersionUID = -2339692954597481558L;
	
	private Integer line;
	
	private String file;
	
	private String error;
	
	public Error() {
		
	}

	public Error(Integer line, String file, String error) {
		super();
		this.line = line;
		this.file = file;
		this.error = error;
	}

	public Integer getLine() {
		return line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "[line=" + line + ", file=" + file + ", error=" + error + "]";
	}

}

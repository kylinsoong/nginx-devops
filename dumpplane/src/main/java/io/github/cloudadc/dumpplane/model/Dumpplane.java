package io.github.cloudadc.dumpplane.model;

import java.io.Serializable;

/**
 * 
 *  Dumpplane represent the nginx -T output, which is s group of configuration block, Dumpplane is one of block
 * 
 * @author ksong
 *
 */
public class Dumpplane implements Serializable {
	
	private static final long serialVersionUID = -5526117033798890872L;

	private String path;
	
	private String content;
	
	public Dumpplane() {
		
	}

	public Dumpplane(String path, String content) {
		super();
		this.path = path;
		this.content = content;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "[path=" + path + ", content=" + content + "]";
	}

}

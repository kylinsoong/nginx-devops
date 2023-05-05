package io.github.cloudadc.dumpplane;

public class NGXConfigurationBlock {
	
	private String path;
	
	private String content;
	
	public NGXConfigurationBlock() {
		
	}

	public NGXConfigurationBlock(String path, String content) {
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

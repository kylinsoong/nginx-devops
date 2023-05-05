package io.github.cloudadc.dumpplane.hander;

import java.io.File;

import io.github.cloudadc.dumpplane.NGXConfiguration;

public abstract class AbstractHander implements Hander {
	
	protected File file;

	public AbstractHander(File file) {
		super();
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	@Override
	public void execute() throws Exception {
		
	}

	@Override
	public void execute(NGXConfiguration config) throws Exception {
		
	}

	@Override
	public void close() throws Exception {
		
	}

}

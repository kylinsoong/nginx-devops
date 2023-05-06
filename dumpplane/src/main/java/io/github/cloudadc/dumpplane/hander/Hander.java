package io.github.cloudadc.dumpplane.hander;

import io.github.cloudadc.dumpplane.model.Configuration;

public interface Hander {
	
	public void execute() throws Exception;
	
	public void execute(Configuration config) throws Exception;
	
	public void close() throws Exception;

}

package io.github.cloudadc.dumpplane.hander;

import io.github.cloudadc.dumpplane.NGXConfiguration;

public interface Hander {
	
	public void execute() throws Exception;
	
	public void execute(NGXConfiguration config) throws Exception;
	
	public void close() throws Exception;

}

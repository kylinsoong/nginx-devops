package io.github.cloudadc.dumpplane.hander;


import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.cloudadc.dumpplane.model.Configuration;

public class DumpHander extends AbstractHander {
	
	public static DumpHander newInstance() {
		return new DumpHander();
	}

	public DumpHander() {
		super(null);
	}

	@Override
	public void execute(Configuration config) throws Exception {
				
		ObjectMapper objectMapper = new ObjectMapper();
		
		String json = objectMapper.writeValueAsString(config);
		
		System.out.println(json);
	}

}

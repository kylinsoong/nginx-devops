package io.github.cloudadc.dumpplane.hander;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.cloudadc.dumpplane.model.Configuration;

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
	public void execute(Configuration config) throws Exception {
		
	}

	@Override
	public void execute(List<Configuration> list) throws Exception {
		
	}

	@Override
	public void close() throws Exception {
		
	}
	
	public String objectToDocument(Configuration config) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		
		String json = mapper.writeValueAsString(config);
		return json;
	}

}

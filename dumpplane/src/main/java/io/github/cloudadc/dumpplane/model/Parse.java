package io.github.cloudadc.dumpplane.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Parse implements Serializable {

	private static final long serialVersionUID = 5475478698241283129L;
	
	private Integer line;
	
	private List<String> args = new ArrayList<>();
	
	private String block;
	
	private String directive;

}

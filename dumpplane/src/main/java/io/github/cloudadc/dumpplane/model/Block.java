package io.github.cloudadc.dumpplane.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Block implements Serializable {

	private static final long serialVersionUID = 5475478698241283129L;
	
	private Integer line;
	
	private List<String> args = new ArrayList<>();
	
	private List<Block> block = new ArrayList<>();
	
	private String directive;
	
	private List<Integer> includes = new ArrayList<>();
	
	public Block() {
		
	}

	public Block(Integer line, List<String> args, List<Block> block, String directive, List<Integer> includes) {
		super();
		this.line = line;
		this.args = args;
		this.block = block;
		this.directive = directive;
		this.includes = includes;
	}

	public Integer getLine() {
		return line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public List<String> getArgs() {
		return args;
	}

	public void setArgs(List<String> args) {
		this.args = args;
	}

	public List<Block> getBlock() {
		return block;
	}

	public void setBlock(List<Block> block) {
		this.block = block;
	}

	public String getDirective() {
		return directive;
	}

	public void setDirective(String directive) {
		this.directive = directive;
	}

	public List<Integer> getIncludes() {
		return includes;
	}

	public void setIncludes(List<Integer> includes) {
		this.includes = includes;
	}

	@Override
	public String toString() {
		return "[line=" + line + ", args=" + args + ", block=" + block + ", directive=" + directive
		        + ", includes=" + includes + "]";
	}

}

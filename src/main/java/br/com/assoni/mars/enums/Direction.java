package br.com.assoni.mars.enums;

import java.util.Arrays;
import java.util.Optional;

public enum Direction {
	RIGHT("R"),
	LEFT("L");
	
	private String key;
	
	private Direction(String key){
		this.key = key;
	}
	
	public String getKey(){
		return key;
	}
	
	public static Optional<Direction> extract(String direction){
		return Arrays.asList(values())
					 .stream()
					 .filter(f -> f.getKey().equalsIgnoreCase(direction))
					 .findFirst();
	}
}

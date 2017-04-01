package br.com.assoni.mars.objects;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.util.StringUtils;

import br.com.assoni.mars.enums.Direction;

public class Instruction {
	private List<String> commands;
	
	public Instruction(String command){
		if(StringUtils.isEmpty(command)){
			//nao encotrado nenhum comando para execucao
			throw new RuntimeException("...");
		}
		
		this.commands = Arrays.asList(command.split(""));
	}
	
	public List<String> getComands(){
		return commands;
	}
	
	public Optional<Robot> execute(Robot robot){
		return commands.stream().map(cmd ->{
			if(cmd.equalsIgnoreCase("M")){
				return robot.walk();
			}
			
			Direction direction = Direction.extract(cmd); 
			
			if(direction == null){
				throw new RuntimeException("....");
			}
			
			return robot.turn(direction);
		}).reduce((a,b) -> b);
	}
}

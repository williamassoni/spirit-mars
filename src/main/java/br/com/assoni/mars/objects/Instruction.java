package br.com.assoni.mars.objects;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.util.StringUtils;

import br.com.assoni.mars.enums.Direction;
import br.com.assoni.mars.enums.MarsExceptionType;
import br.com.assoni.mars.exception.MarsException;

public class Instruction {
	private List<String> commands;
	
	public Instruction(String command){
		if(StringUtils.isEmpty(command)){
			throw new MarsException(MarsExceptionType.EMPTY_COMMAND);
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
			
			Optional<Direction> optional = Direction.extract(cmd); 
			
			if(!optional.isPresent()){
				throw new MarsException(MarsExceptionType.INVALID_COMMAND, cmd);
			}
			
			return robot.turn(optional.get());
		}).reduce((a,b) -> b);
	}
}
